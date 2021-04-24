package fooditemconsumer;

import fooditempublisher.FoodItemInterface;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;


	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		//Register Consumer Service
		serviceReference = context.getServiceReference(FoodItemInterface.class.getName());
		@SuppressWarnings("unchecked")
		FoodItemInterface foodItemInterface = (FoodItemInterface)context.getService(serviceReference);	
		displayMainMenu(foodItemInterface);
	}


	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}
	
	public void displayMainMenu(FoodItemInterface foodItemInterface) {
		
		int option;
		String suboption = "y";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.println("----------Imeero Family Restaurant - Admin Menu Section ----------");
		System.out.println("1  - Add Food Item into the Menu");
		System.out.println("2  - Get all food Items in the Menu");
		System.out.println("3  - Search food Item by Id in the Menu");
		System.out.println("4  - Search food Item by name in the Menu");
		System.out.println("5  - Delete food Item in the Menu");
		System.out.print("Choose an option : ");
		
		option = Integer.parseInt(sc.nextLine().trim());
		
		switch(option) {
			case 1:
				foodItemInterface.insertFoodItem();
				
				while(suboption.equals("y")) {
					System.out.println("\n\nDo you want to Add Another food item (y/n)");
					suboption = sc.nextLine().trim();
		
					if(suboption.equals("y")) {
						foodItemInterface.insertFoodItem();
					}
				}
				displayMainMenu(foodItemInterface);
				break;
			case 2:
				foodItemInterface.getAllFoodItems();
				displayMainMenu(foodItemInterface);
				break;
			case 3:
				foodItemInterface.getFoodDetailById();
				displayMainMenu(foodItemInterface);
				break;
			case 4:
				foodItemInterface.getFoodDetailByName();
				displayMainMenu(foodItemInterface);
				break;
			case 5:
				foodItemInterface.getAllFoodItems();
				foodItemInterface.deleteFoodItem();
				foodItemInterface.getAllFoodItems();
				displayMainMenu(foodItemInterface);
				break;
			default:
				System.out.println("Incorrect Input. Try Again...");
				displayMainMenu(foodItemInterface);
		}
		
		
	}

}
