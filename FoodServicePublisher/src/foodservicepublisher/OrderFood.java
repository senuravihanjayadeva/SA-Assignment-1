package foodservicepublisher;

public class OrderFood {

	private int amount;
	private String customerName;
	private String customerAddress;
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public OrderFood(int amount, String customerName, String customerAddress) {
		super();
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

}
