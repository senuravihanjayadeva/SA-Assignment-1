package fooditempublisher;

import java.sql.ResultSet;

public interface FoodItemInterface {
	
	public void insertFoodItem(FoodItem foodItem);
	public ResultSet getAllFoodItems();
	public ResultSet getFoodDetailById(Integer foodId);

}
