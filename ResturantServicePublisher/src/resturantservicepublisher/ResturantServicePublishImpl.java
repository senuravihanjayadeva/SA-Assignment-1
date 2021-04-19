package resturantservicepublisher;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import resturantdb.Database;
import resturantdb.DatabaseImpl;

//Service publisher class
public class ResturantServicePublishImpl implements ResturantServicePublish {
	// database connection
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);
	
	public ResturantServicePublishImpl() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	//method to insert a new reservation
	@Override
	public void insertReservation() {
		
		Reservation reservation = new Reservation();
	
		System.out.println("----------	Imeero Family Restaurant : Reservation	----------");
		
		System.out.println("Enter Customer Name : ");
		reservation.setCustomerName(sc.nextLine().trim());
		
		System.out.println("Enter Number of Guest : ");
		reservation.setNoOfguests(Integer.parseInt(sc.nextLine().trim()));
		
		System.out.println("Enter Customer Phone Number : ");
		reservation.setPhoneNumber(sc.nextLine().trim());
		
		System.out.println("Enter Reservation Date ( dd/mm/yyyy ) : ");
		reservation.setReservationDate(sc.nextLine().trim());
		
		System.out.println("Enter 1 for priority reservation and 0 for normal reservation : ");
		int flag =sc.nextInt();
		if(flag == 1) {
			reservation.setPriority(1);
		}else {
			reservation.setPriority(0);
		}
			
		String sqlQueryReservation= "INSERT INTO reservations(customername, noofguest, customerphone,reservationdate,priority) "
				+ "VALUES('"+ reservation.getCustomerName() +"', '"+ reservation.getNoOfguests() +"', '"+ reservation.getPhoneNumber()+"', '"+ reservation.getReservationDate() + "', '"+ reservation.getPriority() + "')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQueryReservation);
			System.out.println("Reservation successfully added ...");
		} catch (SQLException exc) {
			System.out.println("Error with add Reservation");
			System.out.println(exc.getMessage());
		}
		
	}

	//methods to get all the reservations in the system
	@Override
	public void getallReservations() {
		
		Reservation reservation = new Reservation();
		String sqlQueryReservation = "SELECT * FROM reservations";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryReservation);
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
	    	  System.out.printf("\n%20s %20s %20s %20s %20s %20s\n","Reservation ID","Customer Name","Number of guests","Phone number","Rservation date","Priority");
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
		      while (resultSet.next()) {  
		    	  System.out.printf("%20d %20s %20d %20s %20s %20d\n",resultSet.getInt("id"),resultSet.getString("customername"),resultSet.getInt("noofguest"),resultSet.getString("customerphone"),resultSet.getString("reservationdate"),resultSet.getInt("priority"));		    

		      }
		} catch (SQLException exc) {
			System.out.println("Error with get all reservations");
			System.out.println(exc.getMessage());
		}
	}

	//method to get all the reservations to a specific users
	@Override
	public void getReservationsByCustName() {
		// TODO Auto-generated method stub
		String custName;
		
		System.out.print("Enter customer name : ");
		custName = sc.nextLine().trim();
		
		String sqlQueryFoodItem = "SELECT * FROM reservations WHERE customername = '"+ custName +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryFoodItem);
			System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
	    	  System.out.printf("\n%20s %20s %20s %20s %20s %20s\n","Reservation ID","Customer Name","Number of guests","Phone number","Rservation date","Priority");
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
		    while (resultSet.next()) {    	  
		    	  System.out.printf("%20d %20s %20d %20s %20s %20d\n",resultSet.getInt("id"),resultSet.getString("customername"),resultSet.getInt("noofguest"),resultSet.getString("customerphone"),resultSet.getString("reservationdate"),resultSet.getInt("priority"));		    	
		    }
		      
		} catch (SQLException exc) {
			System.out.println("Error with getting reservation");
			System.out.println(exc.getMessage());
		}
		
	}

	// method to delete the user
	@Override
	public void deleteReservation() {
		// TODO Auto-generated method stub

		String custName,reservationdate;
		
		System.out.print("Enter customer name : ");
		custName = sc.nextLine().trim();
		
		System.out.print("Enter reservation date ( dd/mm/yyyy ): ");
		reservationdate = sc.nextLine().trim();
		
		try {
			
			statement = connection.createStatement();
			statement.executeUpdate("delete from reservations where customername='"+custName+"' and reservationdate='"+reservationdate+"'");
			System.out.println("Successfully deleted reservation\n");

		} catch (SQLException exc) {
			System.out.println("Error with deleting reservation");
			System.out.println(exc.getMessage());
		}
		
	}

	// method to get all the priority reservations or all the normal reservation
	@Override
	public void getPriorityNormal() {
		// TODO Auto-generated method stub
				List<Reservation> normalReservation = new ArrayList<>();
				List<Reservation> priorityReservation = new ArrayList<>();
				
				String sqlQueryFoodItem = "SELECT * FROM reservations";

				try {
					 statement = connection.createStatement();
					 resultSet = statement.executeQuery(sqlQueryFoodItem);
					 
				      while (resultSet.next()) {
				    	  Reservation res = new Reservation();
				    	  res.setReservationID(resultSet.getInt("id"));
				    	  res.setCustomerName(resultSet.getString("customername"));
				    	  res.setNoOfguests(resultSet.getInt("noofguest"));
				    	  res.setPhoneNumber(resultSet.getString("customerphone"));
				    	  res.setReservationDate(resultSet.getString("reservationdate"));
				    	  res.setPriority(resultSet.getInt("priority"));
				    	  
				    	  
				    	  
				    	  if(resultSet.getString("priority").equals("1")) {
				    		  priorityReservation.add(res);
				    	  }
				    	  else if(resultSet.getString("priority").equals("0")) {
				    		  normalReservation.add(res);
				    	  }
				    	  
				    	   		  	    		  
				      }   
				      
				      System.out.println("\n\n Enter (1) to get the list of priority list and (0) to get the normal list");
				      int flag = sc.nextInt();
				      if(flag == 1) {
				    	  if(priorityReservation.size() > 0) {
				    		  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
					    	  System.out.printf("%20s %20s %20s %20s %20s %20s\n","Reservation ID","Customer Name","Number of guests","Phone number","Rservation date","Priority");
					    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
						      for(Reservation res: priorityReservation){
						    	  System.out.printf("\n%20d %20s %20d %20s %20s %20d\n",res.getReservationID(),res.getCustomerName(),res.getNoOfguests(),res.getPhoneNumber(),res.getReservationDate(),res.getPriority());

						      } 
					      }else {
					    	  System.out.println("\t\tNo Items Available\n\n");
					      }
				      }else if(flag == 0) {
				    	  if(normalReservation.size() > 0) {
				    		  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
					    	  System.out.printf("%20s %20s %20s %20s %20s %20s\n","Reservation ID","Customer Name","Number of guests","Phone number","Rservation date","Priority");
					    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
						      for(Reservation res: normalReservation){
						    	  System.out.printf("\n%20d %20s %20d %20s %20s %20d\n",res.getReservationID(),res.getCustomerName(),res.getNoOfguests(),res.getPhoneNumber(),res.getReservationDate(),res.getPriority());   	

						      } 
					      }else {
					    	  System.out.println("\t\tNo Items Available\n\n");
					      }
				      }
				} catch (SQLException exc) {
					System.out.println("Error ");
					System.out.println(exc.getMessage());
				}
	}
		     
		      
	
	
	
	


}
