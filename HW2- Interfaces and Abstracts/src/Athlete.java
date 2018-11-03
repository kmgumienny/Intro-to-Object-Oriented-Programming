
public class Athlete {

	String name; // a String object named name that stores an athlete's name
	BiathlonResult aBiathlonResult; // a BiathlonResult object named aBiathlonResult that stores an athlete's
								    // result in the Biathlon event
	CyclingResult aCyclingResult; // a CyclingResult object named aCyclingResult that stores an athlete's result 
								  // in the Cycling event
	
	
	Athlete(String name, BiathlonResult aBiathlonResult, CyclingResult aCyclingResult) {
		this.name = name;
		this.aBiathlonResult = aBiathlonResult;
		this.aCyclingResult = aCyclingResult;
	}

	// totals the score of the athlete by calling the pointsEarned
	// methods in the CyclingResult and BiathlonResult classes respectively
	double totalScore() {
		return (this.aCyclingResult.pointsEarned() + this.aBiathlonResult.pointsEarned());
	}

}