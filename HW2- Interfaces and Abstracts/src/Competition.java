import java.util.LinkedList;

public class Competition {
	LinkedList<Athlete> athletes; // a LinkedList named athletes that creates an
									// empty list of Athlete
	int numBiathlonRounds; // an integer that contains the number of biathlon
							// rounds in a BiathlonResult

	Competition(LinkedList<Athlete> athletes, int numBiathlonRounds) {
		this.athletes = athletes;
		this.numBiathlonRounds = numBiathlonRounds;
	}

	// produces a LinkedList of the Athletes in the competition whose list of
	// BiathlonRounds
	// is less than the number of rounds stored in the Competition class
	public LinkedList<Athlete> BiathlonDNF() {
		LinkedList<Athlete> athletesDNF = new LinkedList<Athlete>();
		for (Athlete athlete : athletes) {
			if (athlete.aBiathlonResult.biathlonRounds.size() < numBiathlonRounds) {
				athletesDNF.add(athlete);
			}
		}
		return athletesDNF;
	}

	// takes the name of an athlete and returns the totalScore that the athlete
	// earned in the competition
	// assume that no two athletes have the same name
	// assume that the athlete name given is in the competition
	public double scoreForAthlete(String name) {
		for (Athlete athlete : athletes) {
			if (athlete.name.equals(name)) {
				return athlete.totalScore();

			}
		}
		return 0;
	}

	// takes another Competition as input and returns the number (integer) of
	// athletes whose
	// pointsEarned in cycling was lower in "this" competition than in the given
	// competition
	// assume that both competitions have the same athletes
	// athletes may appear in different orders within the athlete lists in both
	// competitions
	public int countCyclingImproved(Competition otherCompetition) {
		int numImprovedCyclists = 0;
		for (Athlete thisAthlete : this.athletes) {
			for (Athlete sameAthlete : otherCompetition.athletes) {
				if (thisAthlete.name.equals(sameAthlete.name)) {
					if (thisAthlete.aCyclingResult.pointsEarned() < sameAthlete.aCyclingResult.pointsEarned()) {
						numImprovedCyclists = numImprovedCyclists + 1;
					}
				}
			}
		}
		return numImprovedCyclists;
	}
}

// Question 10
// A helper method could have been written since both scoreForAthlete and
// countCyclingImproved start off by
// going through a linked list and looking for an athlete using a name. A helper
// method could take a
// linked list and a name as a parameter and return a boolean indicating whether
// or not that athlete was
// found in that list. Therefore, it would reduce the redundancy within the code
// because that same code
// wouldn't have to be written in both functions as opposed to once in a helper
// method.
