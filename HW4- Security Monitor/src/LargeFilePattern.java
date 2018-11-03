import java.util.LinkedList;

public class LargeFilePattern implements IPattern {

	LargeFilePattern() {
	}

	// consumes a LinkedList of Strings named usernames and an EventLog named log
	// creates an Alert for any username that has created more than one large file
	// severity for each user is the number of large files they have created
	public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {
		LinkedList<Alert> raiseAlerts = new LinkedList<Alert>();
		int severity;
		
		// traverses through usernames list
		for (String username : usernames) {
			severity = 0;
			// traverses through log for events
			for (AbsEvent event : log.getLog()) {
				// if username and event matches AND file is too big, add 1 to severity
				if ((event.isByUser(username) && event.getType() == AbsEvent.FILE_SAVED)
						&& (((FileSaved) event).getSize() > 1000000)) {
					severity = severity + 1;
				}
			}
			
			// if severity is 10 or greater, keep 10 as max 
			// add alert to alert list
			if (severity >= 10) {
				raiseAlerts.add(new Alert(username, 10, AbsEvent.FILE_SAVED));
			}
			// if severity is greater than 1, keep severity
			// add alert to alert list
			else if (severity > 1) {
				raiseAlerts.add(new Alert(username, severity, AbsEvent.FILE_SAVED));
			}
		}
		return raiseAlerts;
	}
}
