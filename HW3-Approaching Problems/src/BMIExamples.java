import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class BMIExamples {
	BMI2 B1 = new BMI2();
	LinkedList<PHR> PHR1 = new LinkedList<PHR>();
	LinkedList<PHR> PHR2 = new LinkedList<PHR>();
	LinkedList<PHR> PHR3 = new LinkedList<PHR>();
	LinkedList<PHR> PHR4 = new LinkedList<PHR>();
	LinkedList<PHR> PHR5 = new LinkedList<PHR>();
	LinkedList<PHR> PHR6 = new LinkedList<PHR>();
	LinkedList<PHR> PHR7 = new LinkedList<PHR>();

	public BMIExamples() {
		// instructorTestBMI
		PHR1.add(new PHR("Eugene", 2, 60, 77));
		PHR1.add(new PHR("Marty", 1.55, 58.17, 56));
		PHR1.add(new PHR("Rai", 1.8, 55, 84));
		PHR1.add(new PHR("Nicky", 1.5, 100, 64));

		// testMissingInstructorBMI
		PHR2.add(new PHR("Eugene", 1.5, 60.75, 27));
		PHR2.add(new PHR("Marty", 1.5, 60.75, 27));
		PHR2.add(new PHR("Rai", 1.5, 60.75, 27));
		PHR2.add(new PHR("Nicky", 1.5, 60.75, 27));

		// testUnderweightBoundaryBMI
		PHR3.add(new PHR("Kamil", 1.5, 4.5, 27)); // BMI < 18.5

		// testHealthyBoundariesBMI
		PHR4.add(new PHR("Kamil", 1.5, 41.625, 27)); // BMI = 18.5
		PHR4.add(new PHR("Joe", 1.5, 45, 27)); // 18.5 < BMI < 25

		// testOverweightBoundariesBMI
		PHR5.add(new PHR("Kamil", 1.5, 56.25, 27)); // BMI = 25
		PHR5.add(new PHR("Joe", 1.5, 63, 27)); // 25 < BMI < 30

		// testObeseBoundariesBMI
		PHR6.add(new PHR("Kamil", 1.5, 67.5, 27)); // BMI = 30
		PHR6.add(new PHR("Joe", 1.5, 70, 27)); // BMI > 30
	}

	// produces names for underweight, healthy, and obese PHRs
	// and produces an empty list for overweight PHRs
	@Test
	public void instructorTestBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(Arrays.asList("Eugene", "Rai")),
				new LinkedList<String>(Arrays.asList("Marty")), new LinkedList<String>(),
				new LinkedList<String>(Arrays.asList("Nicky"))), B1.bmiReport(PHR1));
	}

	// produces an empty list for underweight, healthy, and obese PHRs
	// and produces a list for overweight PHRs.
	@Test
	public void testMissingInstructorBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(),
				new LinkedList<String>(), new LinkedList<String>(Arrays.asList("Eugene", "Marty", "Rai", "Nicky")),
				new LinkedList<String>()), B1.bmiReport(PHR2));
	}

	// underweight under 18.5 limit produces name in underweight
	// can't be 0, so must be less than 18.5
	@Test
	public void testUnderweightBoundaryBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(Arrays.asList("Kamil")),
				new LinkedList<String>(), new LinkedList<String>(),
				new LinkedList<String>()), B1.bmiReport(PHR3));
	}

	// healthy at 18.5 limit and BMI between 18.5 and 20
	// produces name in healthy
	@Test
	public void testHealthyBoundariesBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(),
				new LinkedList<String>(Arrays.asList("Kamil", "Joe")), new LinkedList<String>(),
				new LinkedList<String>()), B1.bmiReport(PHR4));
	}

	// overweight at 25 limit and BMI between 25 and 30
	// produces name in overweight
	@Test
	public void testOverweightBoundariesBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(),
				new LinkedList<String>(), new LinkedList<String>(Arrays.asList("Kamil", "Joe")),
				new LinkedList<String>()), B1.bmiReport(PHR5));
	}

	// obese at 30 limit and BMI above 30
	// produces name in obese
	@Test
	public void testObeseBoundariesBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(),
				new LinkedList<String>(), new LinkedList<String>(),
				new LinkedList<String>(Arrays.asList("Kamil", "Joe"))), B1.bmiReport(PHR6));
	}

	// empty PHR list produces empty lists in BMISummary
	@Test
	public void testEmptyBMI() {
		assertEquals(new BMISummary(new LinkedList<String>(),
				new LinkedList<String>(), new LinkedList<String>(),
				new LinkedList<String>()), B1.bmiReport(PHR7));
	}


}
