import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DataSmoothExamples {
	LinkedList<PHR> PHR1 = new LinkedList<PHR>();
	LinkedList<PHR> PHR2 = new LinkedList<PHR>();
	LinkedList<PHR> PHR3 = new LinkedList<PHR>();
	LinkedList<PHR> PHR4 = new LinkedList<PHR>();

	LinkedList<Double> PHR1Results = new LinkedList<Double>();
	LinkedList<Double> PHR2Results = new LinkedList<Double>();
	LinkedList<Double> PHR3Results = new LinkedList<Double>();
	LinkedList<Double> PHR4Results = new LinkedList<Double>();
	DataSmooth1 D1 = new DataSmooth1();

	public DataSmoothExamples() {
		// four sample PHRs
		PHR1.add(new PHR("Andy", 1.8, 55, 96));
		PHR1.add(new PHR("Jill", 2, 75, 102));
		PHR1.add(new PHR("Ming", 1.7, 60, 87));
		PHR1.add(new PHR("Sophia", 1.8, 63, 105));

		// PHR2
		PHR2.add(new PHR("Kamil", 1.5, 44, 10));

		// PHR3
		PHR3.add(new PHR("Joe", 1.6, 76, 20));
		PHR3.add(new PHR("Kamil", 1.5, 44, 10));

		// the smoothing results on the sample PHRs
		PHR1Results.add(96.0);
		PHR1Results.add(95.0); // average of 96, 102, 87
		PHR1Results.add(98.0); // average of 102, 87, 105
		PHR1Results.add(105.0);
		// PHR2Results
		PHR2Results.add(10.0);
		// PHR3Results
		PHR3Results.add(20.0);
		PHR3Results.add(10.0);
	}

	// list with 2 averaged elements
	@Test
	public void instructorTestDS() {
		assertEquals(PHR1Results, D1.dataSmooth(PHR1));
	}

	// list with only 1 element
	@Test
	public void test1ElementDS() {
		assertEquals(PHR2Results, D1.dataSmooth(PHR2));
	}

	// list with only 2 elements
	@Test
	public void test2ElementsDS() {
		assertEquals(PHR3Results, D1.dataSmooth(PHR3));
	}

	// list with no elements
	@Test
	public void testNoElementsDS() {
		assertEquals(PHR4Results, D1.dataSmooth(PHR4));
	}
}