package grocerySim;

import java.util.*;

public class CheckOut {
	
	public static void main(String [] args) {
		Queue<Customer> customers = getCustomers();
		checkOutAssigner(customers);
	}
	
	public static Queue getCustomers() {
		Queue<Customer> peopleList = new LinkedList<Customer>();
		System.out.println("Enter customer name followed by # of groceries (type done to stop): ");
		
		int count = 0;
		
		while(count == 0) {
			Scanner userInput = new Scanner(System.in);
			String personInput = userInput.nextLine();
			
			if(personInput.equals("done")) {
				break;
			}
			
			int groceryNumber = userInput.nextInt();
			
			String name;
			int groceries;
			
			name = personInput;
			groceries = groceryNumber;
			
			Customer customer = new Customer(name, groceries);
			peopleList.add(customer);
		}
		return peopleList;
	}
	
	public static void checkOutAssigner(Queue<Customer> customers) {
		CheckoutLine line1 = new CheckoutLine();
		CheckoutLine line2 = new CheckoutLine();
		CheckoutLine expressLine = new CheckoutLine();
		
		for(Customer customer: customers) {
			if(customer.getGroceries() <= 10) {
				expressLine.addCustomer(customer);
			}
			else {
				if(line1.getTotalTime() <= line2.getTotalTime()) {
					line1.addCustomer(customer);
				}
				else {
					line2.addCustomer(customer);
				}
			}
		}
		
		System.out.println("\nCheckout Lines:");
        printCheckoutLine("Express Lane", expressLine);
        printCheckoutLine("Regular Lane 1", line1);
        printCheckoutLine("Regular Lane 2", line2);

        System.out.println("\nCustomer Wait Times:");
        printWaitTimes("Express Lane", expressLine);
        printWaitTimes("Regular Lane 1", line1);
        printWaitTimes("Regular Lane 2", line2);
	}
	
	private static void printCheckoutLine(String lineName, CheckoutLine line) {
        System.out.println(lineName + ":");
        for (Customer customer : line.getLine()) {
            System.out.println("  " + customer.getCustomer());
        }
    }

    private static void printWaitTimes(String lineName, CheckoutLine line) {
        int cumulativeTime = 0;
        for (Customer customer : line.getLine()) {
            cumulativeTime += customer.getGroceries();
            System.out.println(customer.getCustomer() + " waited for " + cumulativeTime + " seconds.");
        }
    }
}
