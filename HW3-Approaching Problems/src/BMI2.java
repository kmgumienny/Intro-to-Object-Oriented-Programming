import java.util.LinkedList;

class BMI2 {
	BMI2() {
	}

	// consumes a list of personal health records (defined above) and produces a
	// report containing a list of names (not the entire records) of patients in
	// each BMI classification category
	// names within each list in the report should be in the same order as in
	// the original list of health records
	// assume that no two people have the same name
	public BMISummary bmiReport(LinkedList<PHR> phrs) {
		LinkedList<PHR> under = new LinkedList<PHR>();
		LinkedList<PHR> healthy = new LinkedList<PHR>();
		LinkedList<PHR> over = new LinkedList<PHR>();
		LinkedList<PHR> obese = new LinkedList<PHR>();

		for (PHR person : phrs) {
			if (isUnderweight(person)) {
				under.add(person);
			} else if (isHealthy(person)) {
				healthy.add(person);
			} else if (isOverweight(person)) {
				over.add(person);
			} else if (isObese(person)) {
				obese.add(person);
			}
		}

		BMISummary bmiReport = new BMISummary(addNames(under), addNames(healthy), addNames(over), addNames(obese));

		return bmiReport;
	}

	// produces a list of names from a list of people
	public static LinkedList<String> addNames(LinkedList<PHR> people) {
		LinkedList<String> nameList = new LinkedList<String>();

		for (PHR person : people) {
			nameList.add(person.name);
		}
		return nameList;
	}

	// calculates the BMI of a PHR
	public double calcBMI(PHR person) {
		return person.weight / (person.height * person.height);
	}

	// checks if a PHR is underweight
	public boolean isUnderweight(PHR person) {
		return calcBMI(person) < 18.5;
	}

	// checks if a PHR is healthy
	public boolean isHealthy(PHR person) {
		return calcBMI(person) >= 18.5 && calcBMI(person) < 25;
	}

	// checks if a PHR is overweight
	public boolean isOverweight(PHR person) {
		return calcBMI(person) >= 25 && calcBMI(person) < 30;
	}

	// checks if a PHR is obese
	public boolean isObese(PHR person) {
		return calcBMI(person) >= 30;
	}

}