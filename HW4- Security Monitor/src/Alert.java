
public class Alert implements Comparable {

	String username;
	int severityRating;
	int eventType;

	Alert(String username, int severityRating, int eventType) {
		this.username = username;
		this.severityRating = severityRating;
		this.eventType = eventType;
	}

	// consumes another object and 
	// produces 0 if the severities are the same
	// -1 if the severity of this is greater than the other
	// 1 if the severity of this is less than the other
	public int compareTo(Object otherObj) {
		Alert other = (Alert) otherObj;

		if (this.severityRating == other.severityRating)
			return 0;

		else if (this.severityRating > other.severityRating)
			return -1;

		else 
			return 1;
	}

	// consumes another object and
	// produces true if the alert's username, severity rating, and event type
	// are the same as the other
	public boolean equals(Object otherObj) {
		Alert other = (Alert) otherObj;

		if ((this.username.equals(other.username)) && (this.severityRating == other.severityRating)
				&& (this.eventType == other.eventType))
			return true;

		return false;
	}

}
