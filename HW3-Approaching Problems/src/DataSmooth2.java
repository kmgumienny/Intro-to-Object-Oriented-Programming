import java.util.LinkedList;

class DataSmooth2 {
	DataSmooth2() {
	}

	// consumes a list of PHRs and smooths out the heart rates of the PHRs
	// by averaging an element, its predecessor, and its successor
	// the first heart rate and last rate are not averaged as the main element
	// because they do not have a predecessor or successor, respectively
	// produces a list of smoothed heartRate values
	public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
		LinkedList<Double> heartRates = new LinkedList<Double>();
		LinkedList<Double> smoothedData = new LinkedList<Double>();
		double average;

		for(int x=0; x<phrs.size(); x++) {
			heartRates.add((double)phrs.get(x).heartRate);
		}

		for(int i=0; i<heartRates.size(); i++) {
			if (i == 0 || i == heartRates.size() - 1)
				smoothedData.add((double) heartRates.get(i));
			else {
				average = (heartRates.get(i - 1) + heartRates.get(i) + heartRates.get(i + 1)) / 3;
				smoothedData.add(average);
			}
		}

		return smoothedData;
	}
}