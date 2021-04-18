package employeemanagemantpublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import resturantdb.Database;
import resturantdb.DatabaseImpl;

public class EmployeeService implements EmployeeInterface{
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);
	
	public EmployeeService() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	@Override
	public void insertEmployee() {
		// TODO Auto-generated method stub
     Employee employee = new Employee();
		
		System.out.println("Enter Employee Name : ");
		employee.setEmployeeName(sc.nextLine().trim());
		
		System.out.println("Enter Employee Age : ");
		employee.setAge(Integer.parseInt(sc.nextLine().trim()));
		
		System.out.println("Enter Employee Phone Number : ");
		employee.setPhoneNumber(sc.nextLine().trim());
		
		System.out.println("Enter Employee NIC : ");
		employee.setNIC(sc.nextLine().trim());
		
		
		String sqlQueryemployee = "INSERT INTO employee(employeename, employeeage, employeephonenumber,employeenic) "
				+ "VALUES('"+ employee.getEmployeeName() +"', '"+ employee.getAge() +"', '"+ employee.getPhoneNumber() + "','"+ employee.getNIC() +"')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQueryemployee);
			System.out.println("Employee successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Error with insert Employee");
			System.out.println(exc.getMessage());
		}
		
	}

	@Override
	public void searchEmployee() {
		// TODO Auto-generated method stub
		String nic;
		
		System.out.println("Enter NIC : ");
		nic = (sc.nextLine().trim());
		
		String sqlQueryEmployee = "SELECT * FROM employee WHERE employeenic = '"+ nic +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryEmployee);
			while (resultSet.next()) {  
		    	  System.out.printf("%20d %20s %20d %20s\n",resultSet.getInt("id"),resultSet.getString("employeename"),resultSet.getInt("employeeage"),resultSet.getString("employeephonenumber"));		    	
		      }		    	

		} catch (SQLException exc) {
			System.out.println("Error with get Employee by NIC");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void getallemployee() {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		List<Employee> Employee = new ArrayList<>();
		String sqlQueryEmployee = "SELECT * FROM employee";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryEmployee);
		      while (resultSet.next()) {  
		    	  System.out.printf("%20d %20s %20d %20s\n",resultSet.getInt("id"),resultSet.getString("employeename"),resultSet.getInt("employeeage"),resultSet.getString("employeephonenumber"));		    	
		      }
		} catch (SQLException exc) {
			System.out.println("Error with get all Employees");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void deleteemployee() {
		// TODO Auto-generated method stub
String nic;
		
		System.out.println("Enter NIC : ");
		nic = (sc.nextLine().trim());
		
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM employee WHERE employeenic = '"+ nic +"'"); 
		    	  System.out.printf("Successfully Deleted!");

		} catch (SQLException exc) {
			System.out.println("Error with get Employee by NIC");
			System.out.println(exc.getMessage());
		}
	}

		
}

