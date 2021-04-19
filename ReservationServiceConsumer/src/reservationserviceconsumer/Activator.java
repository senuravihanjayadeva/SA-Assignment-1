package reservationserviceconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import resturantservicepublisher.ResturantServicePublish;

//This is the service consumer class
public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ResturantServicePublish.class.getName());
		@SuppressWarnings("unchecked")
		ResturantServicePublish resturantServicePublish = (ResturantServicePublish)context.getService(serviceReference);	
		displayMainMenu(resturantServicePublish);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}
	
	public void displayMainMenu(ResturantServicePublish resturantServicePublish) {
		
		String type;
		int option;
		String suboption = "y";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.println("----------Imeero Family Restaurant - Reservation ----------");
		System.out.println(" Enter (c) if you are a customer and (a) if you are an admin:");
		type = sc.nextLine().trim();
		if(type.equals("c")||type.equals("C")) {
			//creating an user class object
			User user = new User(resturantServicePublish);
			user.reserve();
			
			while(suboption.equals("y")) {
				System.out.println("\n\nDo you want to Add Another Reservation(y/n)");
				suboption = sc.nextLine().trim();
	
				if(suboption.equals("y")) {
					user.reserve();
				}
			}
			displayMainMenu(resturantServicePublish);
		}
		else if(type.equals("a")||type.equals("A")) {
			//creating an admin class object
			Admin admin = new Admin(resturantServicePublish);
			 
			System.out.println("1  - Get all Reservations");
			System.out.println("2  - Get reservation by name");
			System.out.println("3  - Delete reservation");
			System.out.println("4  - Get priority/normal reservations");

			
			System.out.print("Choose an option : ");
			
			option = Integer.parseInt(sc.nextLine().trim());
			switch(option) {
			case 1:
				admin.getallReservations();
				displayMainMenu(resturantServicePublish);
				break;
			case 2:
				admin.getReservationsByCustName();
				displayMainMenu(resturantServicePublish);
				break;
			case 3:
				admin.deleteReservation();
				displayMainMenu(resturantServicePublish);
				break;
			case 4:
				admin.getPriorityNormal();
				displayMainMenu(resturantServicePublish);
				break;
			default:
				System.out.println("Incorrect Input. Try Again...");
				displayMainMenu(resturantServicePublish);
		}
	}
		
		
		
		
		
		
		
	}



}
