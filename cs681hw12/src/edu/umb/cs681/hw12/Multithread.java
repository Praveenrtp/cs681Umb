package edu.umb.cs681.hw12;

public class Multithread implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Multithread());
		Thread t2 = new Thread(new Multithread());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void run() {
		Customer customer = new Customer(new Address("25 South Point Drive", "Boston", "MA", 02125));
		System.out.println("Customer's Current Address: " + customer.getAddress());
		customer.setAddress(customer.getAddress().change("51 Ocean view Drive", "Boston", "MA", 02125));
		System.out.println("Customer's New Address: "+ customer.getAddress());
	}
}