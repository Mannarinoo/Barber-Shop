public class WaitingChairs {
	// Instance Variables
	private Customer[] array;
	private int front;
	private int back;
	private int count;
	private int length;

	// Constructor
	public WaitingChairs(int size) {
		length = size;
		array = new Customer[length];
		front = 0;
		count = 0;
		back = length - 1;
	}

	// Instance Methods

	// Enqueue- adds a number to the queue and updates back and count.
	public void addCustomer(Customer item) {
		if (!isFull()) {
			back = (back + 1) % length;
			array[back] = item;
			count++;
		}
	}

	// Dequeue - removes the first number in the queue and returns it.
	public Customer removeCustomer() {
		// if (count == 0) {
		// System.out.println();

		// }
		Customer p = array[front];
		front = (front + 1) % length;
		count--;
		return p;
	}

	// Checks to see if the queue is full.
	public boolean isFull() {

		return (length == count);

	}

	// Checks to see if the queue is empty.
	public boolean isEmpty() {

		return (count == 0);

	}

	// returns the top item in the queue
	public Customer nextCustomer() {

		//if (count == 0) {

		//	System.out.println(); // ************************************************

		//}

		return array[front];

	}

	// removes all numbers in the queue and updates count, front, and back.
	public void dequeueAll() {
		count = 0;
		front = 0;
		back = length - 1;
	}

	// Displays the queue along with its front, back, count, and length variables.
	public void display() {
		if (count == 0)
			System.out.println("Chairs are Empty");
	 else {
			// System.out.print("front = " + front + " back = " + back + " count = " + count
			// + " size = " + length + "\n");
			System.out.println("Chairs");
			int i = front;
			if (front <= back) {
				while (i <= back)
					System.out.println("\t" + array[i++] + " ");
					System.out.println();
			} else {
				while (i <= length - 1)
					System.out.println("\t" + array[i++] + " ");
				i = 0;
					
				while (i <= back)
					System.out.println("\t" + array[i++] + " ");
					System.out.println();
			}
		}
	}
}
