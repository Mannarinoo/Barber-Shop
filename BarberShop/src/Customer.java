
public class Customer {
	//Instance Variables
	private int _arrivalTime;
	private int _serviceTime;
	private String _name;
	private Customer _nextCustomer;
	
	public String toString() {
		return getCustomerName() + ": arrival = " + getArrivalTime() + ": service = " + getServiceTime();
	}
	//Constructor
	public Customer(int arrivalTime, int serviceTime, String name) {
		_arrivalTime = arrivalTime;
		_serviceTime = serviceTime;
		_name = name;
	}

	public Customer(int arrivalTime, int serviceTime, String name, Customer nextCustomer) {
		_arrivalTime = arrivalTime;
		_serviceTime = serviceTime;
		_name = name;
		_nextCustomer = nextCustomer;
	}
	//Displays the Customers information
	public void display() {
		System.out.print("Arrival Time: " + _arrivalTime + "\n");
		System.out.print("Service Time: " + _serviceTime + "\n");
		System.out.print("Name: " + _name + "\n");
	}
	//Returns the customers arrival time
	public int getArrivalTime() {
		return _arrivalTime;
	}
	//sets the customers arrival time
	public void setArrivalTime(int arrivalTime) {
		_arrivalTime = arrivalTime;
	}
	//Returns the customer service time
	public int getServiceTime() {
		return _serviceTime;
	}
	//Sets the customer service time
	public void setServiceTime(int serviceTime) {
		_serviceTime = serviceTime;
	}
	//Returns the customers name
	public String getCustomerName() {
		return _name;
	}
	//Sets the customers name
	public void setCustomerName(String name) {
		_name = name;
	}
	//Sets the next customer
	public void setNext(Customer n) {
		_nextCustomer = n;
	}
	//Returns the next customer
	public Customer getNext() {
		return _nextCustomer;
	}

}
