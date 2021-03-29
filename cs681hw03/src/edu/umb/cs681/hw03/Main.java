package edu.umb.cs681.hw03;

import java.util.ArrayList;
import java.util.List;


public class Main { 

	public static void main(String args[]) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Tesla", "ModelX", 20, 2018, 50000));
		cars.add(new Car("BMW", "X6", 50, 2019, 60000));
		cars.add(new Car("Audi", "A4", 40, 2014, 10000));
		cars.add(new Car("xxx", "A", 20, 2020, 15000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		Integer minPrice = cars.stream().map((Car car) -> car.getPrice()).reduce(0, (result, price) -> {
			if (result == 0)
				return price;
			else if (price < result)
				return price;
			else
				return result;
		});

		System.out.println("Minimum price in the list of cars is: " + minPrice);

		Integer maxMileage = cars.stream().map((Car car) -> car.getMileage()).reduce(0, (result, mileage) -> {
			if (result == 0)
				return mileage;
			else if (mileage > result)
				return mileage;
			else
				return result;
		});

		System.out.println("Max mileage in the list of cars is: " + maxMileage);
		
		Integer carCount = cars.stream().map( (Car car)-> car.getMileage() ).reduce(0, (result, MileageOfcar)->{
			
			return ++result;
		});

		System.out.println("Number of cars in the list is: " + carCount);
	}
}
