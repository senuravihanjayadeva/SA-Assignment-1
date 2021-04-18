package foodservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration resgister;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Order food service started");
		FoodServicePublish foodService = new FoodServicePublishImpl();
		resgister = bundleContext.registerService(FoodServicePublish.class.getName(), foodService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Order food service stopped");
		resgister.unregister();
	}

}
