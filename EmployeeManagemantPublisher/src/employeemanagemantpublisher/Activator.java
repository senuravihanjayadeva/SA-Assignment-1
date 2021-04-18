package employeemanagemantpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Employee Publisher service started");
		EmployeeInterface employeeInterface = new EmployeeService();
		serviceRegistration = context.registerService(EmployeeInterface.class.getName(), employeeInterface, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Employee Publisher service stopped");
		serviceRegistration.unregister();
	}

}
