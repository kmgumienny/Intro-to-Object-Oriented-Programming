import java.util.LinkedList;

public class FailedLoginPattern implements IPattern {
	FailedLoginPattern() {
	}

	// consumes a log and a username
	// traverses through the log to find the instances
	// in which the given user created a failed login
	// produces the number of instances
	// if the number of instances is greater than or equal to 10,
	// then return 10
	public int findSeverity(EventLog log, String username) {
		int severity = 0;

		// traverses the log
		for (AbsEvent event : log.getLog()) {
			// if event contains similar username and type AND is a failed login,
			// then add 1 to severity
			if ((event.isByUser(username)) && (event.getType() == AbsEvent.LOGIN)
					&& (!((Login) event).wasSuccessful())) {
				severity++;
			}
		}
		// if severity is greater than or equal to ten,
		// then return 10
		if (severity >= 10) {
			return 10;
		}
		return severity;
	}

	// consumes a LinkedList of Strings named usernames
	// and an EventLog named log
	// creates an Alert for any username that has more than three failed logins
	// within 5 minutes
	// the number of failed logins in the entire log as the severity within the
	// alert, maxing out at 10
	public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {
		LinkedList<Alert> raisedAlerts = new LinkedList<Alert>();
		int failedLogins;

		// traverses through usernames
		for (String uname : usernames) {
			// traverses through event log
			for (int x = 0; x < log.getLog().size(); x++) {
				AbsEvent event1 = log.getLog().get(x);
				// if event1 has the correct name, type, and unsuccessful login
				if ((event1.isByUser(uname)) && (event1.getType() == AbsEvent.LOGIN)
						&& (!((Login) event1).wasSuccessful())) {
					failedLogins = 0;
					// looks through event list for event2
					for (int y = x; y < log.getLog().size(); y++) {
						AbsEvent event2 = log.getLog().get(y);
						// finds difference in time between event2 and event1
						long diff = event2.getTimestamp().getTime() - event1.getTimestamp().getTime();

						// if in 5 minute interval
						if (diff / 60000.0 <= 5.0) {
							// if event2 has the correct name, type, and unsuccessful login
							if ((event2.isByUser(uname)) && (event2.getType() == AbsEvent.LOGIN)
									&& (!((Login) event2).wasSuccessful())) {
								failedLogins++;
							}
						}

						// if failedLogins is greater than 3 within 5 minute interval, 
						// then add new alert 
						// calls helper method findSeverity to find total number of failedLogin
						// instances with specific username
						if (failedLogins > 3) {
							raisedAlerts.add(new Alert(uname, findSeverity(log, uname), event2.getType()));
							// break to not add Alert again
							break;
						}
					}
					// if the method created an Alert, move on to next user because
					// an alert has already been made
					if (failedLogins > 3) {
						break;
					}
				}
			}
		}
		return raisedAlerts;
	}
}
