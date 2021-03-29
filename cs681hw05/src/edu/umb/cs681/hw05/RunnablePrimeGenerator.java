package edu.umb.cs681.hw05;



public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		// Single thread
		System.out.println("Running with single thread");
		RunnablePrimeGenerator generator = new RunnablePrimeGenerator(1L, 2000000L);
		Thread thread = new Thread(generator);
		long start = System.currentTimeMillis();
		try {
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
		}
		
		long end = System.currentTimeMillis();
		float time1 = (end - start);
		
		long primeNum1 = generator.getPrimes().size();
		System.out.println("Total number of primes is = " + primeNum1);
		System.out.println("Time taken with 1 thread: " + time1 + " seconds");

		// Two threads
		System.out.println("Running with Two Threads");
		RunnablePrimeGenerator generator1 = new RunnablePrimeGenerator(1L, 1000000L);
		RunnablePrimeGenerator generator2 = new RunnablePrimeGenerator(1000000L, 2000000L);
		Thread thread1 = new Thread(generator1);
		Thread thread2 = new Thread(generator2);
		long start1 = System.currentTimeMillis();
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
		}
		
		long end1 = System.currentTimeMillis();
		float time2 = (end1 - start1);
		
		long primeNum2 = generator1.getPrimes().size() + generator2.getPrimes().size();
		System.out.println("Total number of primes is = " + primeNum2);
		System.out.println("Time taken with 2 thread: " + time2 + " seconds");
		
		// With 4 threads
		System.out.println("Running with four Threads");
		RunnablePrimeGenerator generator3 = new RunnablePrimeGenerator(1L, 500000L);
		RunnablePrimeGenerator generator4 = new RunnablePrimeGenerator(500000L, 1000000L);
		RunnablePrimeGenerator generator5 = new RunnablePrimeGenerator(1000000L, 1500000L);
		RunnablePrimeGenerator generator6 = new RunnablePrimeGenerator(1500000L, 2000000L);

		Thread thread3 = new Thread(generator3);
		Thread thread4 = new Thread(generator4);
		Thread thread5 = new Thread(generator5);
		Thread thread6 = new Thread(generator6);
		
		long start2 = System.currentTimeMillis();
		try {
			thread3.start();
			thread4.start();
			thread5.start();
			thread6.start();
			thread3.join();
			thread4.join();
			thread5.join();
			thread6.join();
		} catch (InterruptedException e) {
		}
		
		long end2 = System.currentTimeMillis();
		float time3 = (end2 - start2);
		System.out.println("Time taken with 4 thread: " + time3 + " seconds");
		
		long primeNum3 = generator3.getPrimes().size() + generator4.getPrimes().size() + generator5.getPrimes().size() + generator6.getPrimes().size();

		System.out.println("Total number of primes is = " + primeNum3);
		
		// 8 threads
		System.out.println("Running with eight threads");
		RunnablePrimeGenerator generator7 = new RunnablePrimeGenerator(1L, 250000L);
		RunnablePrimeGenerator generator8 = new RunnablePrimeGenerator(250000L, 500000L);
		RunnablePrimeGenerator generator9 = new RunnablePrimeGenerator(500000L, 750000L);
		RunnablePrimeGenerator generator10 = new RunnablePrimeGenerator(750000L, 1000000L);
		RunnablePrimeGenerator generator11 = new RunnablePrimeGenerator(1000000L, 1250000L);
		RunnablePrimeGenerator generator12 = new RunnablePrimeGenerator(1250000L, 1500000L);
		RunnablePrimeGenerator generator13 = new RunnablePrimeGenerator(1500000L, 1750000L);
		RunnablePrimeGenerator generator14 = new RunnablePrimeGenerator(1750000L, 2000000L);

		Thread thread7 = new Thread(generator7);
		Thread thread8 = new Thread(generator8);
		Thread thread9 = new Thread(generator9);
		Thread thread10 = new Thread(generator10);
		Thread thread11 = new Thread(generator11);
		Thread thread12 = new Thread(generator12);
		Thread thread13 = new Thread(generator13);
		Thread thread14 = new Thread(generator14);

		start = System.currentTimeMillis();
		
		try {
			thread7.start();
			thread8.start();
			thread9.start();
			thread10.start();
			thread11.start();
			thread12.start();
			thread13.start();
			thread14.start();
			thread7.join();
			thread8.join();
			thread9.join();
			thread10.join();
			thread11.join();
			thread12.join();
			thread13.join();
			thread14.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time4 = (end - start);

		long primeNum4 = generator7.getPrimes().size() + generator8.getPrimes().size() + generator9.getPrimes().size() + generator10.getPrimes().size()
				+ generator11.getPrimes().size() + generator12.getPrimes().size() + generator13.getPrimes().size() + generator14.getPrimes().size();
		System.out.println("Total number of primes : " +primeNum4);
		System.out.println("Time taken with 8 threads: " + time4 + " seconds");

		// With 16 threads
		System.out.println("Running with 16 threads :");
		RunnablePrimeGenerator generator15 = new RunnablePrimeGenerator(1L, 125000L);
		RunnablePrimeGenerator generator16 = new RunnablePrimeGenerator(125000L, 250000L);
		RunnablePrimeGenerator generator17 = new RunnablePrimeGenerator(250000L, 375000L);
		RunnablePrimeGenerator generator18 = new RunnablePrimeGenerator(375000L, 500000L);
		RunnablePrimeGenerator generator19 = new RunnablePrimeGenerator(500000L, 625000L);
		RunnablePrimeGenerator generator20 = new RunnablePrimeGenerator(625000L, 750000L);
		RunnablePrimeGenerator generator21 = new RunnablePrimeGenerator(750000L, 875000L);
		RunnablePrimeGenerator generator22 = new RunnablePrimeGenerator(875000L, 1000000L);
		RunnablePrimeGenerator generator23 = new RunnablePrimeGenerator(1000000L, 1125000L);
		RunnablePrimeGenerator generator24 = new RunnablePrimeGenerator(1125000L, 1250000L);
		RunnablePrimeGenerator generator25 = new RunnablePrimeGenerator(1250000L, 1375000L);
		RunnablePrimeGenerator generator26 = new RunnablePrimeGenerator(1375000L, 1500000L);
		RunnablePrimeGenerator generator27 = new RunnablePrimeGenerator(1500000L, 1625000L);
		RunnablePrimeGenerator generator28 = new RunnablePrimeGenerator(1625000L, 1750000L);
		RunnablePrimeGenerator generator29 = new RunnablePrimeGenerator(1750000L, 1875000L);
		RunnablePrimeGenerator generator30 = new RunnablePrimeGenerator(1875000L, 2000000L);

		Thread thread15 = new Thread(generator15);
		Thread thread16 = new Thread(generator16);
		Thread thread17 = new Thread(generator17);
		Thread thread18 = new Thread(generator18);
		Thread thread19 = new Thread(generator19);
		Thread thread20 = new Thread(generator20);
		Thread thread21 = new Thread(generator21);
		Thread thread22 = new Thread(generator22);
		Thread thread23 = new Thread(generator23);
		Thread thread24 = new Thread(generator24);
		Thread thread25 = new Thread(generator25);
		Thread thread26 = new Thread(generator26);
		Thread thread27 = new Thread(generator27);
		Thread thread28 = new Thread(generator28);
		Thread thread29 = new Thread(generator29);
		Thread thread30 = new Thread(generator30);

		start = System.currentTimeMillis();
		
		try {
			thread15.start();
			thread16.start();
			thread17.start();
			thread18.start();
			thread19.start();
			thread20.start();
			thread21.start();
			thread22.start();
			thread23.start();
			thread24.start();
			thread25.start();
			thread26.start();
			thread27.start();
			thread28.start();
			thread29.start();
			thread30.start();
			thread15.join();
			thread16.join();
			thread27.join();
			thread18.join();
			thread19.join();
			thread20.join();
			thread21.join();
			thread22.join();
			thread23.join();
			thread24.join();
			thread25.join();
			thread26.join();
			thread27.join();
			thread28.join();
			thread29.join();
			thread30.join();
		} catch (InterruptedException e) {
		}

		end = System.currentTimeMillis();
		float time5 = (end - start);

		long primeNum5 = generator15.getPrimes().size() + generator16.getPrimes().size() + generator17.getPrimes().size()
				+ generator18.getPrimes().size() + generator19.getPrimes().size() + generator20.getPrimes().size() + generator21.getPrimes().size()
				+ generator22.getPrimes().size() + generator23.getPrimes().size() + generator24.getPrimes().size() + generator25.getPrimes().size()
				+ generator26.getPrimes().size() + generator27.getPrimes().size() + generator28.getPrimes().size() + generator29.getPrimes().size()
				+ generator30.getPrimes().size();
		System.out.println("Total number of primes : " +primeNum5);
		System.out.println("Time taken with 16 threads: " + time5 + " seconds");	
	}
}
	
		