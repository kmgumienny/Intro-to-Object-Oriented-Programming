import java.util.HashMap;
import java.util.LinkedList;

public class SponsorSystem implements ISponsorSystem {

	private HashMap<String, Double> sponsors = new HashMap<String, Double>();

	// returns true if a sponsor name is contained 
	// within the SponsorSystem
	public boolean containsKey(String sponsorName) {
		return this.containsKey(sponsorName);
	}

	// adds or updates a sponsor with a rate
	// if the rate is less than 0 or greater than 0.1, 
	// then an InvalidRateException will be thrown OR
	// if a sponsor's rate was lower than their previous,
	// then the a LowerRateException will be thrown
	public void updateRate(String sponsorName, Double newRate) throws LowerRateException, InvalidRateException {
		if (newRate < 0.0 || newRate > 0.1) {
			throw new InvalidRateException(newRate);
		} else if (sponsors.containsKey(sponsorName)) {
			if (newRate < sponsors.get(sponsorName)) {
				throw new LowerRateException(sponsors.get(sponsorName), newRate);
			}
		} else {
			sponsors.put(sponsorName, newRate);
		}
	}

	// finds the total rate of the sponsor rates for a single page
	public double calculateRate(String url) {
		double totalRate = 0.0;
		for (String sponsor : sponsors.keySet()) {
			if (url.contains(sponsor)) {
				totalRate = sponsors.get(sponsor) + totalRate;
			}
		}
		return totalRate;
	}
}
