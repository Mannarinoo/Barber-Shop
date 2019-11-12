/*
 *  Joey Mannarino
 *  Brian Craco
 *  4/18/2018
 *  
 *  Barber Shop: A reference-based Queue Activity
 */

public class App {
	private BarberShop _barberShop;
	public Arrival _arrivalQueue;
	public WaitingChairs _waitingQueue;
	public Barber _barber;

	public App() {

		_arrivalQueue = new Arrival();

		_barberShop = new BarberShop(_arrivalQueue);

	}

	public static void main(String[] args) {
		App app = new App();

	}
}
