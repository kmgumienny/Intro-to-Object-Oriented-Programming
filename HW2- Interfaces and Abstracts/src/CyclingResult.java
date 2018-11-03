
public class CyclingResult extends AbsRace {

	CyclingResult(double time, int position) {
		super(time, position);
	}

	// a method that returns a double indicating the points an athlete earned in the cycling event. If the athlete
	// came in from position 1 to position 3, they have x amounts of points reduced from their time. Else, their
	// time is returned in seconds
	public double pointsEarned() {

		if (this.position == 1) {
			return (this.time - 10);
		}

		else if (this.position == 2) {
			return (this.time - 7);
		}

		else if (this.position == 3) {
			return (this.time - 3);
		}

		else
			return (this.time);
	}
	
 
}
