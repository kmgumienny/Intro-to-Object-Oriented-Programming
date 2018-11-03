
public class BiathlonRound {

	int targetsHit; // an integer named targetsHit that stores the number of targets hit
	double time; // a double named time that stores the time it took to finish (in seconds)

	BiathlonRound(int targetsHit, double time) {
		this.targetsHit = targetsHit;
		this.time = time;
	}

	// returns a double that is an athlete's points in a Biathlon for a certain round. Multiplies the number of targets
	// missed by 60 and adds it to the seconds it took to finish the round
	public double roundPointsEarned() {
		return (this.time + (60 * (5 - this.targetsHit)));
	}
}

