package grocerySim;

import java.util.*;

public class CheckoutLine {

	Queue<Customer> line;
	int totalTime;
	
	public CheckoutLine() {
		line = new LinkedList<Customer>();
		totalTime = 0;
	}
	
	public void addCustomer(Customer customer) {
        line.add(customer);
        totalTime += customer.getWaitTime();
    }

    public int getTotalTime() {
        return totalTime;
    }

    public Queue<Customer> getLine() {
        return line;
    }
}
