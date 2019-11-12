
public class Barber {
	//Instance Variables
	public Customer _customer;
	public int timeRemaining;
	public int numCustomers;
	//Constructor
	public Barber() {
		_customer = null; // ***Brian**** Barber had nothing here so this was my attempt
		timeRemaining = 0;
		numCustomers = 0;
	}
	//Checks to see if the Barber chair is empty
	public boolean isEmpty() {
		return numCustomers == 0;
	}
	//Adds a customer to the barber chair and sets their time remaining 
	public void addCustomer(Customer customer) {
		_customer = customer;
		timeRemaining = _customer.getServiceTime();
		numCustomers++;

	}
	//Removes the customer from the chair
	public Customer removeCustomer() {

		return _customer;

	}
	//Returns the service time Remaining
	public int serviceTimeRemaining() {
		return timeRemaining;
	}
	//Performs the service on the Customer and decrements its time remaining.
	public void performService() {
		if (timeRemaining == 1) {
			this.removeCustomer();
			numCustomers = 0;
		} else {
			timeRemaining--;// set set service time = get service time - 1
		}

	}
	//Checks to see if the barber chair is full
	public boolean isFull() {
		return numCustomers == 1;
	}
	//Displays the Customer in the barber chair
	public void display() { // ***Brian*** attempt at display
		if (numCustomers == 0) {
			System.out.println("Barber's chair is empty");
			System.out.println();
		}

		if (numCustomers == 1) {
			System.out.println("Barber");
			System.out.println("\t" + _customer.getCustomerName() + " is in the chair with a service time of "
					+ timeRemaining + " left");
			System.out.println();
		}

	}
}
