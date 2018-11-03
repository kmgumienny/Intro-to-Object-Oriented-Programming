import java.util.LinkedList;

class Earthquake1 {
	Earthquake1() {
	}

	// checks whether a datum is a date
	boolean isDate(double anum) {
		return (int) anum > 10000000;
	}

	// extracts the month from an 8-digit date
	int extractMonth(double dateNum) {
		return ((int) dateNum % 10000) / 100;
	}

	// consumes a list of sensor data (doubles) and a month (represented by a
	// number between 1 and 12) and produces a list of reports (maxHzReport)
	// indicating the highest frequency reading for each day in that month. Only
	// include entries for dates that are part of the data provided. Ignore data
	// for months other than the given one. Each entry in your report should be
	// an instance of the maxHzReport class in the starter files
	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
		/*
		 * LinkedList<MaxHzReport> finalReportList = new
		 * LinkedList<MaxHzReport>(); LinkedList<Double> monthList = new
		 * LinkedList<Double>();
		 * 
		 * for (int i = 0; i < data.size(); i++) { if (this.isDate(data.get(i))
		 * && this.extractMonth(data.get(i)) == month) {
		 * monthList.add(data.get(i)); for (int x = i + 1; x < data.size(); x++)
		 * { if (this.isDate(data.get(x))) { break; } else
		 * monthList.add(data.get(x)); } } }
		 * 
		 * double max = 0;
		 * 
		 * for (int y = 0; y < monthList.size(); y++) { if
		 * (this.isDate(monthList.get(y))) { max = 0; for (int z = y + 1; z <
		 * monthList.size(); z++) { if (this.isDate(monthList.get(z))) {
		 * finalReportList.add(new MaxHzReport(data.get(y), max)); break; } else
		 * { if (max < monthList.get(z)) { max = monthList.get(z); } } } } }
		 * return finalReportList; }
		 * 
		 * }
		 */

		LinkedList<MaxHzReport> maxHzReportList = new LinkedList<MaxHzReport>();

		double max = 0;
		for (int x = 0; x < data.size(); x++) {
			if (isDate(data.get(x))) {
				if (extractMonth(data.get(x)) == month) {
					for (int y = x + 1; y < data.size(); y++) {
						if (isDate(data.get(y))) {
							maxHzReportList.add(new MaxHzReport(data.get(x), max));
							max = 0;
							break;
						}
						if (y == data.size() - 1){
							if (max < data.get(y)) {
								max = data.get(y);
							}
							maxHzReportList.add(new MaxHzReport(data.get(x), max));
							max = 0;
							break;
						}
						else {
							if (max < data.get(y)) {
								max = data.get(y);
							}
						}
					}

				}
			}
		}
		return maxHzReportList;
	}
}
