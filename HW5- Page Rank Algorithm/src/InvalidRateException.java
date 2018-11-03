
public class InvalidRateException extends Exception {
	Double invalidRate; 
	
	InvalidRateException(Double invalidRate) {
		this.invalidRate = invalidRate;
	}
}
