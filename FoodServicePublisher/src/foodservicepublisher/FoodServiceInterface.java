package foodservicepublisher;


public interface FoodServiceInterface {

	public void insertFood();

	public double getFoodPriceById(int foodId);

	public String getFoodNameById(int foodId);

	void getallfoodorder();
}
