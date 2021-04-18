package foodservicepublisher;

public class Orderfood {

	private int id;
	private String foodName;
	private double totAmnt;
	private int quantity;
	private int tableId;
	
	public Orderfood() {
		super();
	}
	public Orderfood(int id, String foodName, double totAmnt, int quantity, int tableId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.totAmnt = totAmnt;
		this.quantity = quantity;
		this.tableId = tableId;
	}
	public Orderfood(String foodName, double totAmnt, int quantity, int tableId) {
		super();
		this.foodName = foodName;
		this.totAmnt = totAmnt;
		this.quantity = quantity;
		this.tableId = tableId;
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
	public double getTotAmnt() {
		return totAmnt;
	}
	public void setTotAmnt(double totAmnt) {
		this.totAmnt = totAmnt;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	

}
