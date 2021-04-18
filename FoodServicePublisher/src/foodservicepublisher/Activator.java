package foodservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("FoodOrder Publisher service started");
		FoodServiceInterface foodServiceInterface = new FoodServiceInterfaceImpl();
		serviceRegistration = bundleContext.registerService(FoodServiceInterface.class.getName(), foodServiceInterface, null);
	}


	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("FoodOrder Publisher service stopped");
		serviceRegistration.unregister();
	}

}
