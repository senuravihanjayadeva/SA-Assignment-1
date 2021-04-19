package foodservicepublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import resturantdb.Database;
import resturantdb.DatabaseImpl;

public class FoodServiceInterfaceImpl implements FoodServiceInterface {

	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);
			
	public FoodServiceInterfaceImpl() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	//order food for a particular table
	@Override
	public void insertFood() {
		Orderfood food = new Orderfood();
		
		System.out.println("----------	Imeero Family Restaurant :  Add Food Item into the Menu	----------");
		
		System.out.println("Enter Food id : ");
		food.setId(Integer.parseInt(sc.nextLine().trim()));
		
		System.out.println("Enter quantity: ");
		food.setQuantity(Integer.parseInt(sc.nextLine().trim()));
		
		System.out.println("Enter table id : ");
		food.setTableId(Integer.parseInt(sc.nextLine().trim()));
		
		double amnt = food.getQuantity() * getFoodPriceById(food.getId());
		
		food.setTotAmnt(amnt);		
		food.setFoodName(getFoodNameById(food.getId()));
				
		String sqlQueryFoodOrder = "INSERT INTO orderfood(tableid, foodname, foodid, quantity, totalprice) "
				+ "VALUES('"+ food.getTableId() +"', '"+ food.getFoodName() +"', '"+ food.getId() + "', '"+food.getQuantity()+"', '"+food.getTotAmnt()+"')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQueryFoodOrder);
			System.out.println("Food ordered successfully ...");
		} catch (SQLException exc) {
			System.out.println("Error with ordering Food Item");
			System.out.println(exc.getMessage());
		}
		
	}
	
	//from this method user can get food price by entering the food id
	@Override
	public double getFoodPriceById(int foodId) {
		double price = 0;
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE id = '"+ foodId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
	
			while(resultSet.next()) {		
				price = resultSet.getDouble("foodprice");
			}		
				
		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Id");
			System.out.println(exc.getMessage());
			price = 0.0;
		}
		
		return price;
	}
	
	@Override
	public String getFoodNameById(int foodId) {
		
		//sql query to get food items by id
		String foodName = "";
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE id = '"+ foodId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
	
			while(resultSet.next()) {		
				foodName = resultSet.getString("foodname");
			}		
				
		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Id");
			System.out.println(exc.getMessage());
			foodName = "";
		}
		
		return foodName;
	}

	//get all the food that has been ordered
	@Override
	public void getallfoodorder() {
		
		Orderfood orderfood = new Orderfood();
		String sqlQueryFoodOrder = "SELECT * FROM orderfood";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodOrder);
		      while (resultSet.next()) {  
		    	  System.out.printf("%20d %20d %20s %20d %20d %20.2f\n",resultSet.getInt("id"),resultSet.getInt("tableid"),resultSet.getString("foodname"),resultSet.getInt("foodid"),
		    			  resultSet.getInt("quantity"), resultSet.getDouble("totalprice")	  );		    	
		      }
		} catch (SQLException exc) {
			System.out.println("Error with get all Employees");
			System.out.println(exc.getMessage());
		}
	}

}
