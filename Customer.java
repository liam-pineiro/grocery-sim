package grocerySim;

public class Customer {

	private String name;
	private int groceries;
	private int time;
	
	public Customer(String name, int groceries) {
		this.name = name;
		this.groceries = groceries;
		this.time = groceries;
	}
	
	public int getGroceries() {
		return this.groceries;
	}
	
	public void setGroceries(int groceries) {
		this.groceries = groceries;
	}
	
	public String getCustomer() {
		return this.name;
	}
	
	public void setCustomer(String name) {
		this.name = name;
	}
	
	public void setWaitTime(int time) {
		this.time = time;
	}
	
	public int getWaitTime() {
		return this.time;
	}
}
