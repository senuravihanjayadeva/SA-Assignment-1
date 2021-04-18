package foodservicepublisher;

import java.util.List;

public interface FoodServicePublish {

	public List<Food> orderFood(int amount, String code);
}
