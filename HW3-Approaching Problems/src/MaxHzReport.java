public class MaxHzReport {
  double date; // an 8 digit date (yyyymmdd) in the form of a double
  double maxReading; // the max HZ reading of a day

  MaxHzReport(double date, double maxread) {
    this.date = date;
    this.maxReading = maxread;
  }

  // the equals method for use in testing
  public boolean equals(Object other) {
    MaxHzReport otherR = (MaxHzReport) other;
    return otherR.date == this.date &&
      otherR.maxReading == this.maxReading;
  }
  
  // the toString method so that reports display when tests fail
  public String toString(){
    return "Report["+ date + ", " + maxReading + "]";
  }
}
