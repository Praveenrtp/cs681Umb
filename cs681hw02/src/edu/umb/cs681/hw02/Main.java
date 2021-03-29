package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String args[]) {

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Tesla", "ModelX", 20, 2018, 50000));
		cars.add(new Car("BMW", "X6", 50, 2019, 60000));
		cars.add(new Car("Audi", "A4", 40, 2014, 10000));
		cars.add(new Car("xxx", "A", 20, 2020, 15000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

		List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());

		List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage))
				.collect(Collectors.toList());

		List<Car> sortByDominationCount = cars.stream().sorted(Comparator.comparing(Car::getDominationCount))
				.collect(Collectors.toList());

		System.out.println("Sort by Price");
		sortByPrice.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getPrice()));

		System.out.println("Sort by Year");
		sortByYear.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getYear()));

		System.out.println("Sorted by Mileage");
		sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getMileage()));

		System.out.println("Sorted by Domination Count");
		sortByDominationCount.forEach((Car car) -> System.out.println(car.getMake() + ":" + car.getDominationCount()));
	
	}

}
