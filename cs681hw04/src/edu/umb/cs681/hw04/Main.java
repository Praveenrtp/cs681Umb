package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import java.util.List;

public class Main {
	public static void main(String args[]) {
		ArrayList<TheInternationalDota> dota  = new ArrayList<>();

		dota.add(new TheInternationalDota("Liquid", 14, 9, 5, 18));
		dota.add(new TheInternationalDota("OG", 14, 6, 8, 12));
		dota.add(new TheInternationalDota("Evil Genius", 14, 5, 8, 11));
		
		long numberOfTeams = dota.stream().count();
		System.out.println("Number of teams in Dota: " + numberOfTeams);


		TheInternationalDota minPointsTeam = dota.stream().min(Comparator.comparing(TheInternationalDota::getPoints)).get();
		System.out.println("Team that has min points: " + minPointsTeam.getTeam());
		
		TheInternationalDota maxPointsTeam = dota.stream().max(Comparator.comparing(TheInternationalDota::getPoints)).get();
		System.out.println("Team that has max points: " + maxPointsTeam.getTeam());
		

		List<TheInternationalDota> sortedByPoints = dota.stream().sorted(Comparator.comparing(TheInternationalDota::getPoints, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		System.out.println("Teams sorted by Points: ");
		sortedByPoints.forEach((TheInternationalDota dota1) -> System.out.println(dota1.getTeam() + ": " + dota1.getPoints()));
		

		List<TheInternationalDota> sortedByMatchesWon = dota.stream().sorted(Comparator.comparing(TheInternationalDota::getWon, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		System.out.println("Teams sorted by matchesWon: ");
		sortedByMatchesWon.forEach((TheInternationalDota dota1) -> System.out.println(dota1.getTeam() + ": " + dota1.getWon()));
	}

}
