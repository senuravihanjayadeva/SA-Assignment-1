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
		//Establish Database Connection
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	//Method for add food items into Menu
	@Override
	public void insertFoodItem() {
		
		FoodItem foodItem = new FoodItem();
		
		System.out.println("----------	Imeero Family Restaurant :  Add Food Item into the Menu	----------");
		
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

	//Method for get all food items from Menu
	@SuppressWarnings("finally")
	@Override
	public void getAllFoodItems() {
		
		List<FoodItem> foodListRice = new ArrayList<>();
		List<FoodItem> foodListSoup = new ArrayList<>();
		List<FoodItem> foodListKottu = new ArrayList<>();
		List<FoodItem> foodListBeverage = new ArrayList<>();
		
		String sqlQueryFoodItem = "SELECT * FROM fooditems";

		try {
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(sqlQueryFoodItem);
			 
		      while (resultSet.next()) {
		    	  FoodItem foodItem = new FoodItem();
		    	  foodItem.setFoodId(resultSet.getInt("id"));
		    	  foodItem.setFoodName(resultSet.getString("foodname"));
		    	  foodItem.setFoodType(resultSet.getString("foodtype"));
		    	  foodItem.setFoodPrice(resultSet.getDouble("foodprice"));
		    	  
		    	  
		    	  if(resultSet.getString("foodtype").equals("rice")) {
		    		  foodListRice.add(foodItem);
		    	  }
		    	  if(resultSet.getString("foodtype").equals("soup")) {
		    		  foodListSoup.add(foodItem);
		    	  }
		    	  if(resultSet.getString("foodtype").equals("kottu")) {
		    		  foodListKottu.add(foodItem);
		    	  }
		    	  if(resultSet.getString("foodtype").equals("beverage")) {
		    		  foodListBeverage.add(foodItem);
		    	  }
    	
		    	   		  	    		  
		      }   
		      
		      System.out.println("\n\n\t\t------- Rice -------\n");
		      if(foodListRice.size() > 0) {
			      for(FoodItem food: foodListRice){
			    	  System.out.printf("%20d %20s %20s %20.2f\n",food.getFoodId(),food.getFoodName(),food.getFoodType(),food.getFoodPrice());
			      } 
		      }else {
		    	  System.out.println("\t\tNo Items Available\n\n");
		      }

		      
		      System.out.println("\n\n\t\t------- Soup -------\n");
		      if(foodListSoup.size() > 0) {
			      for(FoodItem food: foodListSoup){
			    	  System.out.printf("%20d %20s %20s %20.2f\n",food.getFoodId(),food.getFoodName(),food.getFoodType(),food.getFoodPrice());
			      } 
		      }else {
		    	  System.out.println("\t\tNo Items Available\n\n");
		      }
		          
		      System.out.println("\n\n\t\t------- Kottu -------\n");
		      if(foodListKottu.size() > 0) {
		    	   for(FoodItem food: foodListKottu){
				    	  System.out.printf("%20d %20s %20s %20.2f\n",food.getFoodId(),food.getFoodName(),food.getFoodType(),food.getFoodPrice());
				   }
		      }else {
		    	  System.out.println("\t\tNo Items Available\n\n");
		      }
		   
		      
		      System.out.println("\n\n\t\t------- Beverage -------\n");
		      if(foodListBeverage.size() > 0) {
			      for(FoodItem food: foodListBeverage){
			    	  System.out.printf("%20d %20s %20s %20.2f\n",food.getFoodId(),food.getFoodName(),food.getFoodType(),food.getFoodPrice());
			      }
		      }else {
		    	  System.out.println("\t\tNo Items Available\n\n");
		      }

		      
		} catch (SQLException exc) {
			System.out.println("Error with get all Food Item");
			System.out.println(exc.getMessage());
		}
		
	}

	//Method for get food item from Menu by Id
	@SuppressWarnings("finally")
	@Override
	public void getFoodDetailById() {
		
		int foodId;
		
		System.out.print("Enter Food ID : ");
		foodId = Integer.parseInt(sc.nextLine().trim());
		
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE id = '"+ foodId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
		      while (resultSet.next()) {  
		    	  System.out.printf("\n%20d %20s %20s %20.2f\n",resultSet.getInt("id"),resultSet.getString("foodname"),resultSet.getString("foodtype"),resultSet.getDouble("foodprice"));		    	
		      }
		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Id");
			System.out.println(exc.getMessage());
		}
	}

	//Method for get food item from Menu by name
	@Override
	public void getFoodDetailByName() {
		
		String foodName;
		
		System.out.print("Enter Food Name : ");
		foodName = sc.nextLine().trim();
		
		String sqlQueryFoodItem = "SELECT * FROM fooditems WHERE foodname = '"+ foodName +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
			
		    while (resultSet.next()) {    	  
		    	System.out.printf("\n%20d %20s %20s %20.2f\n",resultSet.getInt("id"),resultSet.getString("foodname"),resultSet.getString("foodtype"),resultSet.getDouble("foodprice"));		    	
		    }
		      
		} catch (SQLException exc) {
			System.out.println("Error with get Food Item by Name");
			System.out.println(exc.getMessage());
		}
		
	}
	
	//Method for get price for food item from Menu by Id
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
	
	//Method for delete food item from Menu by Id
	@Override
	public void deleteFoodItem() {
		
		int foodId;
		
		System.out.print("Enter Food ID To Delete : ");
		foodId = Integer.parseInt(sc.nextLine().trim());
		
		try {
			
			statement = connection.createStatement();
			statement.executeUpdate("\ndelete from fooditems where id='"+foodId+"' ");
			System.out.println("Successfully deleted Food Item - foodId\n");

		} catch (SQLException exc) {
			System.out.println("Error with delete Food Item by Name");
			System.out.println(exc.getMessage());
		}
		
	}
	
	


}
