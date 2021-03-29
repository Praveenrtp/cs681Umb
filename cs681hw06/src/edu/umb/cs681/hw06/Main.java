package edu.umb.cs681.hw06;

public class Main {
	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator generator = new RunnableCancellablePrimeGenerator(1, 200);
		Thread thread = new Thread(generator);
		
		try {
			thread.start();
			generator.setDone();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		generator.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		long primeNum = generator.getPrimes().size();
		System.out.println("\n Total Number of Primes : " + primeNum);
	}
}
