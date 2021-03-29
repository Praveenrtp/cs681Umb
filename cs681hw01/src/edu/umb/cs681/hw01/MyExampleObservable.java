package edu.umb.cs681.hw01;

public class MyExampleObservable extends Observable{
	public static void main(String args[]) {

		StockQuoteObservable stockQuote = new StockQuoteObservable();
		
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer  has been notified.");
		});
		stockQuote.changeQuote("Salesforce", 1);
		
		stockQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("Stock Observer  has been notified.");
		});
		stockQuote.changeQuote("Tesla", 2);		
		
		DJIAQuoteObservable djiaQuote = new DJIAQuoteObservable();
		
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer  has been notified.");
		});
		djiaQuote.changeQuote("Qwerty", 22);
		
		djiaQuote.addObserver((Observable o, Object obj) -> {
			System.out.println("DJIA Observer  has been notified.");
		});
		djiaQuote.changeQuote("Adidas", 33);

	}
}
