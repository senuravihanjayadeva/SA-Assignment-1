package fooditempublisher;

import java.sql.ResultSet;

public interface FoodItemInterface {
	
	public void insertFoodItem();
	public void getAllFoodItems();
	public void getFoodDetailById();
	public void getFoodDetailByName();
	public void deleteFoodItem();
	public double getFoodPriceById(int foodId);

}
