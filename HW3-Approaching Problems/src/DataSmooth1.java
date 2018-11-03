import java.util.LinkedList;

class DataSmooth1 {
	DataSmooth1() {
	}

	// consumes a list of PHRs and smooths out the heart rates of the PHRs
	// by averaging an element, its predecessor, and its successor
	// the first heart rate and last rate are not averaged as the main element
	// because they do not have a predecessor or successor, respectively
	// produces a list of smooted heartRate values
	public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
		LinkedList<Double> smoothedData = new LinkedList<Double>();

		for (int i = 0; i < phrs.size(); i++) {
			if (i == 0 || i == phrs.size() - 1)
				smoothedData.add((double) phrs.get(i).heartRate);
			else
				smoothedData.add(findAverage(i, phrs));
		}
		return smoothedData;
	}

	// consumes the index of the selected element and a list of PHRs
	// and finds the average of the predecessor of the element,
	// successor of the element, and the element itself
	public static double findAverage(int index, LinkedList<PHR> phrs) {
		return (double) (phrs.get(index - 1).heartRate + phrs.get(index).heartRate + phrs.get(index + 1).heartRate)
				/ 3.0;
	}

	/*
	public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
		LinkedList<Double> smoothedData = new LinkedList<Double>();
		double average;
		for (int i = 0; i < phrs.size(); i++) {
			if (i == 0 || i == phrs.size() - 1)
				smoothedData.add((double) phrs.get(i).heartRate);
			else {
				average = (phrs.get(i - 1).heartRate + phrs.get(i).heartRate + phrs.get(i + 1).heartRate) / 3;
				smoothedData.add(average);
			}
		}
		return smoothedData;
	}
	 */
}