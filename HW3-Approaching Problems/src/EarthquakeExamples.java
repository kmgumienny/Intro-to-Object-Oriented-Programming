import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class EarthquakeExamples {
	Earthquake1		 E1 = new Earthquake1();
	LinkedList<Double> noData = new LinkedList<Double>();
	LinkedList<Double> threeDates = new LinkedList<Double>();
	LinkedList<Double> emptyList = new LinkedList<Double>();
	LinkedList<Double> singleList = new LinkedList<Double>();
	LinkedList<Double> multipleList = new LinkedList<Double>();

	LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> emptyReportList = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> singleReportList = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> multipleReportList = new LinkedList<MaxHzReport>();

	public EarthquakeExamples() {
		threeDates.add(20151013.0);
		threeDates.add(10.0);
		threeDates.add(5.0);
		threeDates.add(20151020.0);
		threeDates.add(40.0);
		threeDates.add(50.0);
		threeDates.add(45.0);
		threeDates.add(20151101.0);
		threeDates.add(6.0);

		singleList.add(20161114.0);
		singleList.add(6.0);

		multipleList.add(20151013.0);
		multipleList.add(10.0);
		multipleList.add(5.0);
		multipleList.add(20151120.0);
		multipleList.add(40.0);
		multipleList.add(50.0);
		multipleList.add(45.0);
		multipleList.add(20151121.0);
		multipleList.add(6.0);
		multipleList.add(7.0);

		NovReports.add(new MaxHzReport(20151101.0, 6.0));
		singleReportList.add(new MaxHzReport(20161114.0, 6.0));
		multipleReportList.add(new MaxHzReport(20151120.0, 50.0));
		multipleReportList.add(new MaxHzReport(20151121.0, 7.0));
	}

	// list with 1 desired month data set
	// produces the only MaxHzReport available
	@Test
	public void instructorTestEQ() {
		assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
	}

	// empty list produces an empty list of reports
	@Test
	public void emptyTestEQ() {
		assertEquals(emptyReportList, E1.dailyMaxForMonth(emptyList, 12));
	}

	// list with only 1 month and 1 max produces a list of MaxHzReport that
	// only contains that 1 report
	// max is the first number of the data
	@Test
	public void singleTestEQ() {
		assertEquals(singleReportList, E1.dailyMaxForMonth(singleList, 11));
	}

	// list contains multiple dates for month and produces a list of MaxHzReport
	// that
	// contains 2 reports
	// max is the middle number of the data and the last
	@Test
	public void multipleTestEQ() {
		assertEquals(multipleReportList, E1.dailyMaxForMonth(multipleList, 11));
	}

	// method calls non existent month produces an empty list
	@Test
	public void wrongMonthTestEQ() {
		assertEquals(emptyReportList, E1.dailyMaxForMonth(singleList, 12));
	}

}