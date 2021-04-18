package fooditempublisher;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import resturantdb.Database;
import resturantdb.DatabaseImpl;

public class FoodItemServiceImpl implements FoodItemInterface {
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);

	public FoodItemServiceImpl() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	@Override
	public void insertFoodItem() {
		
		FoodItem foodItem = new FoodItem();
		
		System.out.println("Enter Food Name : ");
		foodItem.setFoodName(sc.nextLine().trim());
		
		System.out.println("Enter Food Type : ");
		foodItem.setFoodType(sc.nextLine().trim());
		
		System.out.println("Enter Food Price : ");
		foodItem.setFoodPrice(Double.parseDouble(sc.nextLine().trim()));
		
		
		String sqlQueryFoodItem = "INSERT INTO fooditems(foodname, foodtype, foodprice) "
				+ "VALUES('"+ foodItem.getFoodName() +"', '"+ foodItem.getFoodType() +"', '"+ foodItem.getFoodPrice() + "')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQueryFoodItem);
			System.out.println("Food Item successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Error with insert Food Item");
			System.out.println(exc.getMessage());
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public void getAllFoodItems() {
		FoodItem foodItem = new FoodItem();
		List<FoodItem> foodList = new ArrayList<>();
		String sqlQueryFoodItem = "SELECT * FROM fooditems";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
		      while (resultSet.next()) {  
		    	  System.out.printf("%20d %20s %20s %20.2f\n",resultSet.getInt("id"),resultSet.getString("foodname"),resultSet.getString("foodtype"),resultSet.getDouble("foodprice"));		    	
		      }
		} catch (SQLException exc) {
			System.out.println("Error with get all Food Item");
			System.out.println(exc.getMessage());
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public void getFoodDetailById() {
		
		int foodId;
		
		System.out.println("Enter Food Name : ");
		foodId = Integer.parseInt(sc.nextLine().trim());
		
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE id = '"+ foodId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
	    	System.out.printf("%20d %20s %20s %20.2f\n",resultSet.getInt("id"),resultSet.getString("foodname"),resultSet.getString("foodtype"),resultSet.getDouble("foodprice"));		    	

		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Id");
			System.out.println(exc.getMessage());
		}
	}


}
