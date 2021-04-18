package resturantservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Resturant reservation service started");
		ResturantServicePublish resturantServicePublish = new ResturantServicePublishImpl();
		serviceRegistration = context.registerService(ResturantServicePublish.class.getName(), resturantServicePublish, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Resturant reservation service ended");
		serviceRegistration.unregister();
	}

}
