import java.util.HashMap;

public interface ISponsorSystem {
	
	// returns true if a sponsor name is contained
	// within the SponsorSystem
	public boolean containsKey(String sponsorName);

	// adds or updates a sponsor with a rate
	// if the rate is less than 0 or greater than 0.1,
	// then an InvalidRateException will be thrown OR
	// if a sponsor's rate was lower than their previous,
	// then the a LowerRateException will be thrown
	public void updateRate(String sponsorName, Double newRate) throws LowerRateException, InvalidRateException;

	// finds the total rate of the 
	// sponsor rates for a single page
	public double calculateRate(String url);
}
