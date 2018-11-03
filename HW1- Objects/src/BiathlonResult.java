
public class BiathlonResult implements IEvent{

	BiathlonRound round1; //a BiathlonRound object named round1 that stores the athletes result of the first biathlon
	BiathlonRound round2; //a BiathlonRound object named round2 that stores the athletes result of the second biathlon
	BiathlonRound round3; //a BiathlonRound object named round3 that stores the athletes result of the third biathlon

	BiathlonResult(BiathlonRound round1, BiathlonRound round2, BiathlonRound round3) {
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
	}

	// calculates the points earned by taking the scores of round1, round2, and round3 and adding them up. This method
	// calls roundPointsEarned in the BiathlonRound class that calculates the points earned in a round.
	public double pointsEarned() {
		return (this.round1.roundPointsEarned() + this.round2.roundPointsEarned() + this.round3.roundPointsEarned());
	}

	// returns the round that an athlete scored the lowest in by using if else operators. Compares all three rounds
	// to each other to see if, firstly, one is lower than the other three and, secondly, if there are two that are
	// equal in points and smaller than the third, in which case the method would return the first to occur of the
	// two equal rounds. Returns round 1 if none of the conditions are met, such as if all rounds have an equal score.
	BiathlonRound bestRound() {
		if ((this.round1.roundPointsEarned() < this.round2.roundPointsEarned())
				&& (this.round1.roundPointsEarned() < this.round3.roundPointsEarned())) {
			return round1;
		}

		else if ((this.round2.roundPointsEarned() < this.round1.roundPointsEarned())
				&& (this.round2.roundPointsEarned() < this.round3.roundPointsEarned())) {
			return round2;
		}

		else if ((this.round3.roundPointsEarned() < this.round1.roundPointsEarned())
				&& (this.round3.roundPointsEarned() < this.round2.roundPointsEarned())) {
			return round3;
		}

		else if ((this.round1.roundPointsEarned() == this.round2.roundPointsEarned())
				&& (this.round1.roundPointsEarned() < this.round3.roundPointsEarned())) {
			return round1;
		}

		else if ((this.round1.roundPointsEarned() == this.round3.roundPointsEarned())
				&& (this.round1.roundPointsEarned() < this.round2.roundPointsEarned())) {
			return round1;
		}

		else if ((this.round2.roundPointsEarned() == this.round3.roundPointsEarned())
				&& (this.round2.roundPointsEarned() < this.round1.roundPointsEarned())) {
			return round2;
		}

		else {
			return round1;
		}
	}
}
