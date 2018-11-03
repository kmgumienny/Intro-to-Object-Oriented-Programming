
public class Athlete {

	BiathlonResult aBiathlonResult; //a BiathlonResult object named aBiathlonResult that stores an athlete's
	                                // result in the Biathlon event.
	CyclingResult aCyclingResult; //a CyclingResult object named aCyclingResult that stores an athlete's result
	                               // in the Cycling event
	

	Athlete(BiathlonResult aBiathlonResult, CyclingResult aCyclingResult) {
		this.aBiathlonResult = aBiathlonResult;
		this.aCyclingResult = aCyclingResult;
	}

	// totals the score of the athlete by calling the pointsEarned
	// methods in CyclingResult and BiathlonResult classes respectively
	double totalScore() {
		return (this.aCyclingResult.pointsEarned() + this.aBiathlonResult.pointsEarned());
	}

	// returns a boolean that indicates whether the athlete who is used to call this method
	// has a higher score than another athlete who was entered into the parameter section of the method call.
	boolean hasBeaten(Athlete otherAthlete) {
		return (this.totalScore() < otherAthlete.totalScore());
	}

	// returns the athlete who received a higher score in the Cycling event. Compares the CyclingResult scores of the
	// athlete who was used to call this method and the other athlete who was entered in.
	Athlete betterCyclist1(Athlete otherAthlete) {
		if (this.aCyclingResult.pointsEarned() < otherAthlete.aCyclingResult.pointsEarned())
			return this;
		else
			return otherAthlete;
	}

	// returns an athlete, like the function above, however this one doesn't look at score. This function returns
	// the athlete who came in at an earlier position
	Athlete betterCyclist2(Athlete otherAthlete) {
		if (this.aCyclingResult.position < otherAthlete.aCyclingResult.position)
			return this;
		else
			return otherAthlete;
	}

}

