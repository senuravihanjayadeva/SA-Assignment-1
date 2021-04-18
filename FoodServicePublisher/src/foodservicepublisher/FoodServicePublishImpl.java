package foodservicepublisher;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodServicePublishImpl implements FoodServicePublish {

	private List<Food> foods = new ArrayList<Food>();
	private String orderMore = "Y";
	
	private Connection connection = null;
	private Statement statement = null;
	
	@Override
	public List<Food> orderFood(int amount, String code) {
		
		do {
			Food foodItm = new Food(code, amount);
			
			Scanner foodCode = new Scanner(System.in);
			System.out.println("Enter food code:");
			String code1 = foodCode.nextLine();
			
			Scanner amount1 = new Scanner(System.in);
			System.out.println("Enter amount:");
			int no = amount1.nextInt();
			
			foodItm.setCode(code1);
			foodItm.setAmount(no);
			foods.add(foodItm);
			
			//clculate price & set it
			Scanner answer = new Scanner(System.in);
			System.out.println("Do you want to order more?");
			orderMore = answer.nextLine();
		}
		while(orderMore.equalsIgnoreCase("Y"));
		return foods;
	}

}
