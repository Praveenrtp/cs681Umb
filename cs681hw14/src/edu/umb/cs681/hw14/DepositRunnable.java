package edu.umb.cs681.hw14;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {

	private ThreadSafeBankAccount bankAccount = null;
	private AtomicBoolean done = new AtomicBoolean(false);
	
	@Override
	public void run() {
		while (true) {
			if (done.get()) {
				System.out.println(Thread.currentThread().getName() + "\t Money Deposited");
				break;
			}
			System.out.println(Thread.currentThread().getName() + "\t Depositing money");
			bankAccount.deposit(500);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public DepositRunnable(ThreadSafeBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void setDone() {
		done.getAndSet(true);
	}

}