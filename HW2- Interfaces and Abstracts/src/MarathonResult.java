
public class MarathonResult extends AbsRace{
	
	MarathonResult(double time,int position) {
		super(time, position); 
	}
	
	// calculates the points earned from a marathon
	// points are calculated by the time it takes for an athlete to finish a race
	public double pointsEarned() {
		return this.time;
	}
	
}
