import java.util.LinkedList;

public class BiathlonResult implements IEvent{

	LinkedList<BiathlonRound> biathlonRounds; // an LinkedList called biathlonRounds that contains an empty list of BiathlonRound
	
	BiathlonResult(LinkedList<BiathlonRound> biathlonRounds) {
		this.biathlonRounds = biathlonRounds;
	}

	// totals the points across all rounds in the list biathlonRounds
	public double pointsEarned() {
		double totalScore = 0;
		
		for (BiathlonRound br : biathlonRounds) {
			totalScore = br.roundPointsEarned() + totalScore;
		}

		return totalScore;
	}

	// searches for the best round in the list biathlonRounds by using an accumulator style method
	// the better round is set to a variable, the better round is compared to the next rounds until a better round replaces it
	// the best round is returned at the end of the method
	BiathlonRound bestRound() {
		BiathlonRound bestRound = biathlonRounds.get(0);
		
		for (BiathlonRound br : biathlonRounds) {
			if (br.roundPointsEarned() < bestRound.roundPointsEarned()) {
				bestRound = br;
			}
		}
		
		return bestRound;
	}
}
