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


public class ResturantServicePublishImpl implements ResturantServicePublish {
	
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
		
		System.out.println("Enter Reservation Date ( dd/MM/yyyy ) : ");
		reservation.setReservationDate(sc.nextLine().trim());
			
		String sqlQueryReservation= "INSERT INTO reservations(customername, noofguest, customerphone,reservationdate) "
				+ "VALUES('"+ reservation.getCustomerName() +"', '"+ reservation.getNoOfguests() +"', '"+ reservation.getPhoneNumber()+"', '"+ reservation.getReservationDate() + "')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQueryReservation);
			System.out.println("Reservation successfully added ...");
		} catch (SQLException exc) {
			System.out.println("Error with add Reservation");
			System.out.println(exc.getMessage());
		}
		
	}

	@Override
	public void getallReservations() {
		
		Reservation reservation = new Reservation();
		String sqlQueryReservation = "SELECT * FROM reservations";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQueryReservation);
		      while (resultSet.next()) {  
		    	  System.out.printf("%20d %20s %20d %20s %20s\n",resultSet.getInt("id"),resultSet.getString("customername"),resultSet.getInt("noofguest"),resultSet.getString("customerphone"),resultSet.getString("reservationdate"));		    	
		      }
		} catch (SQLException exc) {
			System.out.println("Error with get all reservations");
			System.out.println(exc.getMessage());
		}
	}


}
