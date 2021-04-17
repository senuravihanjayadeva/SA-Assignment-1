package foodservicepublisher;

public class Food {

	private int id;
	private String foodName;
	private String code;
	private double price;

	public Food(int id, String foodName, String code, double price) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.code = code;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
