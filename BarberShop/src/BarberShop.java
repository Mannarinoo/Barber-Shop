
public class BarberShop {
	public Arrival _arrivalQueue;
	public WaitingChairs _chairQueue;
	public int _time = 0;
	public Customer arrivedCustomer;
	public Customer c;
	public Barber _barber;

	public BarberShop(Arrival arrivalqueue) {
		_arrivalQueue = arrivalqueue;
		_barber = new Barber();
		_chairQueue = new WaitingChairs(4);
		_arrivalQueue.readArrivals("BarberShopOutput");

		//Continue while there are still people in the BarberShop and Arrivalqueue.
		while (!_arrivalQueue.isEmpty() || !_chairQueue.isEmpty() || !_barber.isEmpty()) {
			// print the time and updates it
			System.out.println("---------------------------------------------");
			System.out.println("Time = " + _time);
			System.out.println();
			if (_barber.isEmpty() && _chairQueue.isEmpty()) {
				System.out.println("Barber takes a break");
				System.out.println();
			}
			
			//Gets the next customer in the arrival queue 
			if (!_arrivalQueue.isEmpty()) {
				arrivedCustomer = _arrivalQueue.nextCustomer();
			}
			//Checks if the customers arrival time equals the actual time
			if (arrivedCustomer.getArrivalTime() == _time) {
				if (!_chairQueue.isFull()) {
					//removes the customer from the arrival queue and adds them to the waiting queue
					arrivedCustomer = _arrivalQueue.removeCustomer();
					_chairQueue.addCustomer(arrivedCustomer);
					System.out.println("A chair is available");
					System.out.println("\t" + arrivedCustomer.getCustomerName() + " sits");
					System.out.println();
				} else {
					//If a customer arrives and the waiting chairs are full he leaves
					System.out.println("All Chairs are Full");
					System.out.println("\t" + arrivedCustomer.getCustomerName() + " left");
					_arrivalQueue.removeCustomer();
				}

			}
			//Takes a customer from the waiting chair and puts him in the barber chair
			if (_barber.isEmpty() && !_chairQueue.isEmpty() && _time >1) {
				Customer a = _chairQueue.removeCustomer();
				_barber.addCustomer(a);

			}
			//Performs service on the customer in the barber chair.
			else if (_barber.isFull()) {
				_barber.performService();
			}
			//Displays the chair, arrival, and barber queue
			_chairQueue.display();
			_barber.display();
			_arrivalQueue.displayArrivalList();
			//increments the time
			_time++;
		}

	}
}
