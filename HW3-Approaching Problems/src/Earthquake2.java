import java.util.LinkedList;

class Earthquake2 {
    Earthquake2() {
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
    // for months other than the given one. Each entry in your report should be an
    // instance of the maxHzReport class in the starter files
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<Double> dataDoubles = new LinkedList<Double>();
        LinkedList<MaxHzReport> maxHzReportList = new LinkedList<MaxHzReport>();
        double maxNum = 0;
        for (int i = 0; i < data.size(); i++) {
            if (this.isDate(data.get(i)) && this.extractMonth(data.get(i)) == month) {
                for (int x = i + 1; x < data.size(); x++) {
                    if (data.get(x) < 10000) {
                        dataDoubles.add(data.get(x));
                    }
                    if (data.size() == x + 1 || isDate(data.get(x))){
                        for (double p : dataDoubles) {
                            if (maxNum < p)
                                maxNum = p;
                        }
                        maxHzReportList.add(new MaxHzReport(data.get(i), maxNum));
                        maxNum = 0;
                        dataDoubles = new LinkedList<Double>();
                        i = x - 1;
                        break;
                    }
                }
            }
        }
        return maxHzReportList;
    }
}