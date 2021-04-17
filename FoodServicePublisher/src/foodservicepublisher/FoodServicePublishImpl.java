package foodservicepublisher;

import java.util.ArrayList;
import java.util.List;

public class FoodServicePublishImpl implements FoodServicePublish {

	private List<Food> foods = new ArrayList<Food>();
	private String orderMore = "Y";
	
	@Override
	public List<Food> orderFood(int amount, String code, String customerName, String address) {
		
		do {
			
		}
		while(orderMore == "Y");
		return null;
	}

}
