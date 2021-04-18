package foodserviceconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import foodservicepublisher.FoodServiceInterface;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(FoodServiceInterface.class.getName());
		@SuppressWarnings("unchecked")
		FoodServiceInterface foodserviceInterface = (FoodServiceInterface)context.getService(serviceReference);	
		displayMainMenu(foodserviceInterface);
	}


	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}
	
	public void displayMainMenu(FoodServiceInterface foodServiceInterface) {
		
		int option;
		String suboption = "y";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.println("----------Imeero Family Restaurant - Admin Order Section ----------");
		System.out.println("1  - Order food");
		System.out.println("2  - Get all oredred food");
		System.out.print("Choose an option : ");
		
		option = Integer.parseInt(sc.nextLine().trim());
		
		switch(option) {
			case 1:
				foodServiceInterface.insertFood();
				
				while(suboption.equals("y")) {
					System.out.println("\n\nDo you want to Add Another order? (y/n)");
					suboption = sc.nextLine().trim();
		
					if(suboption.equals("y")) {
						foodServiceInterface.insertFood();
					}
				}
				displayMainMenu(foodServiceInterface);
				break;
			case 2:
				foodServiceInterface.getallfoodorder();
				displayMainMenu(foodServiceInterface);
				break;
			default:
				System.out.println("Incorrect Input. Try Again...");
				displayMainMenu(foodServiceInterface);
		}
		
		
	}

}
