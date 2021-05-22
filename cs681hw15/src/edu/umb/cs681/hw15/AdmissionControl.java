package edu.umb.cs681.hw15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {

	private int currentVisitorsCount = 0;
	private ReentrantLock lock = new ReentrantLock();

	private Condition sufficientCondition = lock.newCondition();
	private Condition limitCondition = lock.newCondition();
	
	public int visitorsCount() {
		lock.lock();
		try {
			return currentVisitorsCount;
		} finally {
			lock.unlock();
		}
	}

	public void enter() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Visitors Count : " + currentVisitorsCount);
			while (currentVisitorsCount >= 7) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t Visitors count exceeded limit");
					sufficientCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}
			currentVisitorsCount++;
			System.out.println(Thread.currentThread().getName() + "\t Updated Current Visitors Count : " + currentVisitorsCount);
			limitCondition.signalAll();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			lock.unlock();
		}
	}

	public void exit() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Visitors count : " + currentVisitorsCount);
			while (currentVisitorsCount <= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t No Visitors waiting");
					limitCondition.await();
				} catch (InterruptedException e) {
					return;
				}
			}
			currentVisitorsCount--;
			System.out.println(Thread.currentThread().getName() + "\t Updated Count of Current Visitors	: " + currentVisitorsCount);
			sufficientCondition.signalAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}