package fooditempublisher;

import java.sql.Statement;
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
	
	

	public FoodItemServiceImpl() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	@Override
	public void insertFoodItem(FoodItem foodItem) {
		
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
	public ResultSet getAllFoodItems() {
		String sqlQueryFoodItem = "SELECT * FROM fooditems";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
		} catch (SQLException exc) {
			System.out.println("Error with get all Food Item");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public ResultSet getFoodDetailById(Integer foodId) {
		
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE id = '"+ foodId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Id");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}



}
