package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public class Customer {

	private Address address;
	ReentrantLock lock = new ReentrantLock();

	public Customer(Address addr) {
		this.address = addr;
	}

	public void setAddress(Address address) {
		lock.lock();
		try {
			this.address = address;
			System.out.println("Thread ID: " + Thread.currentThread().getId() + " Customer's address is " + this.address.toString());
		} finally {
			lock.unlock();
		}

	}

	public Address getAddress() {
		return address;
	}
}
