package fooditempublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import resturantdb.Database;
import resturantdb.DatabaseImpl;

public class Activator implements BundleActivator {
	
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("FoodItem Publisher service started");
		
		//Register Publisher Service
		FoodItemInterface foodItemInterface = new FoodItemServiceImpl();
		serviceRegistration = context.registerService(FoodItemInterface.class.getName(), foodItemInterface, null);
	}


	public void stop(BundleContext context) throws Exception {
		System.out.println("FoodItem Publisher service stopped");
		serviceRegistration.unregister();
	}

}
