package foodservicepublisher;

public class Food {

	private int id;
	private String foodName;
	private String code;
	private double price;
	private int amount;
	
	public Food(String code, int amount) {
		super();
		this.code = code;
		this.amount = amount;
	}
	public Food(String foodName, String code, double price, int amount) {
		super();
		this.foodName = foodName;
		this.code = code;
		this.price = price;
		this.amount = amount;
	}

	public Food(int id, String foodName, String code, double price, int amount) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.code = code;
		this.price = price;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
