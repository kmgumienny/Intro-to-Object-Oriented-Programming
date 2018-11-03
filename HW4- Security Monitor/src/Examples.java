import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
	// customize here, or create multiple monitors with different parameter
	// lists
	SecurityMonitor SM = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
	SecurityMonitor saveLogSM1 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new LargeFilePattern())));
	SecurityMonitor saveLog2SM2 = new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new LargeFilePattern())));
	SecurityMonitor loginLogSM3 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new FailedLoginPattern())));
	SecurityMonitor loginLog2SM4 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new FailedLoginPattern())));
	SecurityMonitor webrequestlogSM5 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
	SecurityMonitor largeLog1SM6 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new LargeFilePattern(), new FailedLoginPattern())));
	SecurityMonitor eventlog1SM7 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern(), new FailedLoginPattern())));
	SecurityMonitor eventlog2SM8 = new SecurityMonitor(
			new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern(), new FailedLoginPattern())));
	SecurityMonitor largestLogSM9 = new SecurityMonitor(new LinkedList<IPattern>(
			Arrays.asList(new SuspiciousWebPattern(), new LargeFilePattern(), new FailedLoginPattern())));

	// use this fixed set of usernames -- it is what we have in all the logs
	LinkedList<String> usernames = new LinkedList<String>(Arrays.asList("root", "kathi", "simmon", "jordan"));

	public Examples() {

		// Default Test
		// reset the queue between test cases
		SM.clearQueue();
		// populate the queue based on a specific log
		SM.runLogFile("webrequestlog.txt", usernames);

		// HW Tests
		// reset the queue between test cases
		saveLogSM1.clearQueue();
		// populate the queue based on a specific log
		saveLogSM1.runLogFile("saveLog.txt", usernames);
		// reset the queue between test cases
		saveLog2SM2.clearQueue();
		// populate the queue based on a specific log
		saveLog2SM2.runLogFile("saveLog2.txt", usernames);
		// reset the queue between test cases
		loginLogSM3.clearQueue();
		// populate the queue based on a specific log
		loginLogSM3.runLogFile("loginLog.txt", usernames);
		// reset the queue between test cases
		loginLog2SM4.clearQueue();
		// populate the queue based on a specific log
		loginLog2SM4.runLogFile("loginLog2.txt", usernames);
		// reset the queue between test cases
		webrequestlogSM5.clearQueue();
		// populate the queue based on a specific log
		webrequestlogSM5.runLogFile("webrequestlog.txt", usernames);
		// reset the queue between test cases
		largeLog1SM6.clearQueue();
		// populate the queue based on a specific log
		largeLog1SM6.runLogFile("largeLog1.txt", usernames);
		// reset the queue between test cases
		eventlog1SM7.clearQueue();
		// populate the queue based on a specific log
		eventlog1SM7.runLogFile("eventlog1.txt", usernames);
		// reset the queue between test cases
		eventlog2SM8.clearQueue();
		// populate the queue based on a specific log
		eventlog2SM8.runLogFile("eventlog2.txt", usernames);
		// reset the queue between test cases
		largestLogSM9.clearQueue();
		// populate the queue based on a specific log
		largestLogSM9.runLogFile("largestLog.txt", usernames);
	}

	// check whether the webrequest sample yields a single alert (as it should)
	@Test
	public void checkWebRequestAlertsTest() {
		assertEquals(1, SM.numAlerts());
	}

	// saveLog

	// check whether the saveLog sample yields the top alert
	// tests LargeFilePattern
	@Test
	public void saveLogTopTest() {
		Alert saveLog = new Alert("kathi", 2, 4);
		assertEquals(saveLog, saveLogSM1.topAlert());
	}

	// check whether the saveLog sample yields a single alert
	// tests LargeFilePattern
	@Test
	public void saveLogNumTest() {
		assertEquals(1, saveLogSM1.numAlerts());
	}

	// checks whether the saveLog sample yields the top alert using handleAlert
	// tests LargeFilePattern
	@Test
	public void saveLogHandle1Test() {
		Alert saveLog = new Alert("kathi", 2, 4);
		assertEquals(saveLog, saveLogSM1.handleAlert());
	}

	// checks whether the saveLog sample yields null after the top
	// alert has been taken off
	// tests LargeFilePattern
	@Test
	public void saveLogHandle2Test() {
		saveLogSM1.handleAlert();
		assertEquals(null, saveLogSM1.topAlert());
	}

	// saveLog2

	// check whether the saveLog2 sample yields the top alert out of 2
	// tests LargeFilePattern
	@Test
	public void saveLog2TopTest() {
		Alert saveLog2 = new Alert("simmon", 3, 4);
		assertEquals(saveLog2, saveLog2SM2.topAlert());
	}

	// check whether the saveLog2 sample yields 2 alerts
	// tests LargeFilePattern
	@Test
	public void saveLog2NumTest() {
		assertEquals(2, saveLog2SM2.numAlerts());
	}

	// checks whether the saveLog2 sample yields the top alert using handleAlert
	// tests LargeFilePattern
	@Test
	public void saveLog2Handle1Test() {
		Alert saveLog2 = new Alert("simmon", 3, 4);
		assertEquals(saveLog2, saveLog2SM2.handleAlert());
	}

	// checks whether the saveLog2 sample yields the remaining alert after the top
	// alert has been taken off
	// tests LargeFilePattern
	@Test
	public void saveLog2Handle2Test() {
		Alert saveLog2H = new Alert("kathi", 2, 4);
		saveLog2SM2.handleAlert();
		assertEquals(saveLog2H, saveLog2SM2.topAlert());
	}

	// loginLog

	// check whether the loginLog sample yields the top alert 
	// tests FailedLoginPattern
	@Test
	public void loginLogTopTest() {
		Alert loginLog = new Alert("root", 4, 6);
		assertEquals(loginLog, loginLogSM3.topAlert());
	}

	// check whether the loginLog sample yields 1 alert 
	// tests FailedLoginPattern
	@Test
	public void loginLogNumTest() {
		assertEquals(1, loginLogSM3.numAlerts());
	}

	// checks whether the loginLog sample yields the top alert using handleAlert
	// tests FailedLoginPattern
	@Test
	public void loginLogHandle1Test() {
		Alert loginLog = new Alert("root", 4, 6);
		assertEquals(loginLog, loginLogSM3.handleAlert());
	}

	// checks whether the loginLog sample yields null after the top
	// alert has been taken off
	// tests FailedLoginPattern
	@Test
	public void loginLogHandle2Test() {
		loginLogSM3.handleAlert();
		assertEquals(null, loginLogSM3.topAlert());
	}

	// loginLog2

	// check whether the loginLog2 sample yields null
	// tests FailedLoginPattern
	@Test
	public void loginLog2TopTest() {
		assertEquals(null, loginLog2SM4.topAlert());
	}

	// check whether the loginLog2 sample yields no alerts
	// tests FailedLoginPattern
	@Test
	public void loginLog2NumTest() {
		assertEquals(0, loginLog2SM4.numAlerts());
	}

	// checks whether the loginLog2 sample yields null using handleAlert
	// tests FailedLoginPattern
	@Test
	public void loginLog2Handle1Test() {
		assertEquals(null, loginLog2SM4.handleAlert());
	}

	// checks whether the loginLog2 sample yields null after the top
	// alert has been supposedly taken off
	// tests FailedLoginPattern
	@Test
	public void loginLog2Handle2Test() {
		loginLog2SM4.handleAlert();
		assertEquals(null, loginLog2SM4.topAlert());
	}

	// webrequestlog

	// check whether the webrequestlog sample yields the top alert
	// tests SuspiciousWebPattern
	@Test
	public void webrequestlogTopTest() {
		Alert webrequestlog = new Alert("kathi", 1, 5);
		assertEquals(webrequestlog, webrequestlogSM5.topAlert());
	}

	// check whether the webrequestlog sample yields 1 alert
	// tests SuspiciousWebPattern
	@Test
	public void webrequestlogNumTest() {
		assertEquals(1, webrequestlogSM5.numAlerts());
	}

	// checks whether the webrequestlog sample yields 1 alert using handleAlert
	// tests SuspiciousWebPattern
	@Test
	public void webrequestlogHandle1Test() {
		Alert webrequestlog = new Alert("kathi", 1, 5);
		assertEquals(webrequestlog, webrequestlogSM5.handleAlert());
	}

	// checks whether the webrequestlog sample yields null after the top
	// alert has been taken off
	// tests SuspiciousWebPattern
	@Test
	public void webrequestlogHandle2Test() {
		webrequestlogSM5.handleAlert();
		assertEquals(null, webrequestlogSM5.topAlert());
	}

	// largeLog1

	// check whether the largeLog1 sample yields the top alert
	// tests LargeFilePattern and FailedLoginPattern
	@Test
	public void largeLog1TopTest() {
		Alert largeLog1 = new Alert("jordan", 10, 6);
		assertEquals(largeLog1, largeLog1SM6.topAlert());
	}

	// check whether the largeLog1 sample yields 3 alerts
	// tests LargeFilePattern and FailedLoginPattern
	@Test
	public void largeLog1NumTest() {
		assertEquals(3, largeLog1SM6.numAlerts());
	}

	// checks whether the largeLog1 sample yields 1 alert using handleAlert
	// tests LargeFilePattern and FailedLoginPattern
	@Test
	public void largeLog1Handle1Test() {
		Alert largeLog1 = new Alert("jordan", 10, 6);
		assertEquals(largeLog1, largeLog1SM6.handleAlert());
	}

	// checks whether the largeLog1 sample yields 1 alert after the top
	// alert has been taken off
	// tests LargeFilePattern and FailedLoginPattern
	@Test
	public void largeLog1Handle2Test() {
		Alert largeLog1H = new Alert("simmon", 4, 4);
		largeLog1SM6.handleAlert();
		assertEquals(largeLog1H, largeLog1SM6.topAlert());
	}

	// eventlog1

	// check whether the eventlog1 sample yields the top alert
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog1TopTest() {
		Alert eventlog1 = new Alert("simmon", 10, 6);
		assertEquals(eventlog1, eventlog1SM7.topAlert());
	}

	// check whether the eventlog1 sample yields 4 alerts
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog1NumTest() {
		assertEquals(4, eventlog1SM7.numAlerts());
	}

	// checks whether the eventlog1 sample yields 1 alert using handleAlert
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog1Handle1Test() {
		Alert eventlog1 = new Alert("simmon", 10, 6);
		assertEquals(eventlog1, eventlog1SM7.handleAlert());
	}

	// checks whether the eventlog1 sample yields 1 alert after the top
	// alert has been taken off
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog1Handle2Test() {
		Alert eventlog1H = new Alert("kathi", 2, 5);
		eventlog1SM7.handleAlert();
		assertEquals(eventlog1H, eventlog1SM7.topAlert());
	}

	// eventlog2

	// check whether the eventlog2 sample yields the top alert
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog2TopTest() {
		Alert eventlog2 = new Alert("jordan", 10, 6);
		assertEquals(eventlog2, eventlog2SM8.topAlert());
	}

	// check whether the eventlog2 sample yields 4 alerts
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog2NumTest() {
		assertEquals(4, eventlog2SM8.numAlerts());
	}

	// checks whether the eventlog2 sample yields 1 alert using handleAlert
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog2Handle1Test() {
		Alert eventlog2 = new Alert("jordan", 10, 6);
		assertEquals(eventlog2, eventlog2SM8.handleAlert());
	}

	// checks whether the eventlog2 sample yields 1 alert after the top
	// alert has been taken off
	// tests SuspiciousWebPattern and FailedLoginPattern
	@Test
	public void eventLog2Handle2Test() {
		Alert eventlog2H = new Alert("root", 2, 5);
		eventlog2SM8.handleAlert();
		assertEquals(eventlog2H, eventlog2SM8.topAlert());
	}

	// largestLog

	// check whether the largestLog sample yields the top alert
	// tests SuspiciousWebPattern, LargeFilePattern, and FailedLoginPattern
	@Test
	public void largestLogTopTest() {
		Alert largestLog = new Alert("jordan", 10, 6);
		assertEquals(largestLog, largestLogSM9.topAlert());
	}

	// check whether the largestLog sample yields 3 alerts
	// tests SuspiciousWebPattern, LargeFilePattern, and FailedLoginPattern
	@Test
	public void largestLogNumTest() {
		assertEquals(3, largestLogSM9.numAlerts());
	}

	// checks whether the largestLog sample yields 1 alert using handleAlert
	// tests SuspiciousWebPattern, LargeFilePattern, and FailedLoginPattern
	@Test
	public void largestLogHandle1Test() {
		Alert largestLog = new Alert("jordan", 10, 6);
		assertEquals(largestLog, largestLogSM9.handleAlert());
	}

	// checks whether the largestLog sample yields 1 alert after the top
	// alert has been taken off
	// tests SuspiciousWebPattern, LargeFilePattern, and FailedLoginPattern
	@Test
	public void largestLogHandle2Test() {
		Alert largestLogH = new Alert("kathi", 2, 4);
		largestLogSM9.handleAlert();
		assertEquals(largestLogH, largestLogSM9.topAlert());
	}

}