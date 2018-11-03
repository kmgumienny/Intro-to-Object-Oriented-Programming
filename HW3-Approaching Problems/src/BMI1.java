import java.util.LinkedList;

class BMI1 {
	BMI1() {
	}

	// consumes a list of personal health records (defined above) and produces a
	// report containing a list of names (not the entire records) of patients in
	// each BMI classification category
	// names within each list in the report should be in the same order as in
	// the original list of health records
	// assume that no two people have the same name
	public BMISummary bmiReport(LinkedList<PHR> phrs) {
		LinkedList<String> under = new LinkedList<String>();
		LinkedList<String> healthy = new LinkedList<String>();
		LinkedList<String> over = new LinkedList<String>();
		LinkedList<String> obese = new LinkedList<String>();
		BMISummary bmiReport = new BMISummary(under, healthy, over, obese);

		for (PHR person : phrs) {
			if (isUnderweight(person)) {
				under.add(person.name);
			} else if (isHealthy(person)) {
				healthy.add(person.name);
			} else if (isOverweight(person)) {
				over.add(person.name);
			} else if (isObese(person)) {
				obese.add(person.name);
			}
		}

		return bmiReport;
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