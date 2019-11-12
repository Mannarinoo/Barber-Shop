import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arrival {
	Customer _head;
	Customer _tail;
	int numItems;

	public Arrival() {
		_head = null;
		_tail = null;
		numItems = 0;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void addCustomer(int arrivalTime, int serviceTime, String name) {
		if (_head == null) {
			// Add a new head node if the list is empty, not the same as adding
			// a new node when the list isn't empty
			_head = new Customer(arrivalTime, serviceTime, name);
			_tail = _head;
		} else {
			// Start n at head
			_tail.setNext(new Customer(arrivalTime, serviceTime, name));
			_tail = _tail.getNext();

		}
		// Update count
		numItems++;
	}

	public Customer removeCustomer() {
		Customer p = _head;
		_head = _head.getNext();// _head.setNext(_head.getNext()); // setting cust 2 to cust 2
		numItems--;
		return p;
	}

	public Customer nextCustomer() {
		return _head;
	}
	//Displays Arrival List
	public void displayArrivalList() {
		System.out.println("Arrival List");

		Customer p = _head;
		for (int i = 0; i < numItems; i++) {
			System.out.println("\t" + p);
			p = p.getNext();
		}

	}
	//Reads Arrival File and puts customers into Arrival Queue
	public void readArrivals(String filename) {
		Scanner input;
		input = new Scanner(System.in);
		input.close();
		Scanner fileInput;
		File inFile = new File(filename);

		try {
			fileInput = new Scanner(inFile);

			// read header data
			while (fileInput.hasNextLine()) {

				int ArrivalTime = fileInput.nextInt();
				int ServiceTime = fileInput.nextInt();

				String name = fileInput.next();

				// fileInput.nextLine();
				this.addCustomer(ArrivalTime, ServiceTime, name);
			}

			fileInput.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1); // IO error; exit program
		} // end catch

	}
}
