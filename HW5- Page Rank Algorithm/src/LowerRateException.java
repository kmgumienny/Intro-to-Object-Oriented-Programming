
public class LowerRateException extends Exception {
	
	Double oldRates;
	Double newRates;
	
	LowerRateException(Double oldRates, Double newRates) {
		this.oldRates = oldRates;
		this.newRates = newRates;
	}
}
