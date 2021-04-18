package fooditempublisher;

import java.sql.ResultSet;

public interface FoodItemInterface {
	
	public void insertFoodItem();
	public ResultSet getAllFoodItems();
	public ResultSet getFoodDetailById();

}
