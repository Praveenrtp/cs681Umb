package edu.umb.cs681.hw04;

public class TheInternationalDota {

		private String team;
		private int matchesPlayed;
		private int won;
		private int lost;
		private int points;
		

		public TheInternationalDota(String team, int matchesPlayed, int won, int lost, int points) {
			this.team = team;
			this.matchesPlayed = matchesPlayed;
			this.won = won;
			this.lost = lost;
			this.points = points;
		}

		public String getTeam() {
			return team;
		}

		public int getMatchesPlayed() {
			return matchesPlayed;
		}

		public int getWon() {
			return won;
		}

		public int getLost() {
			return lost;
		}

		public int getPoints() {
			return points;
		}

}
