import java.util.LinkedList;

class Webpage implements Comparable<Webpage> {
	public String url;
	private String title;
	private String body;
	private LinkedList<String> referencedURLs;
	public Double rank;

	// The constructor converts title and body to lowercase, to ease
	// other computations later
	Webpage(String locator, String title, String body, LinkedList<String> referencedURLs) {
		this.url = locator;
		this.title = title.toLowerCase();
		this.body = body.toLowerCase();
		this.referencedURLs = referencedURLs;
		this.rank = 0.0;
	}

	// returns true the webpage contains the inputed
	// query in it's title and body
	public boolean contains(String query) {
		if (this.title.toLowerCase().contains(query) || this.body.toLowerCase().contains(query)) {
			return true;
		}
		return false;
	}

	// compares a webpage's rank with another webpage's rank
	// returns an int
	public int compareTo(Webpage aPage) {
		Double otherRank = aPage.rank;

		if (this.rank < otherRank)
			return 1;
		else if (this.rank > otherRank)
			return -1;
		else
			return 0;
	}

	// sets a webpage's rank to zero
	public void setRankZero() {
		this.rank = 0.0;
	}

	// accesses a webpage's rank and adds the given double to the rank
	public void updateRank(double x) {
		this.rank = this.rank + x;
	}

	// generates a list of references from a page that will earn
	// rating points
	public LinkedList<String> referencesList() {
		LinkedList<String> willUpdateURLs = new LinkedList<String>();
		for (String link : this.referencedURLs) {
			if (!link.equals(this.url)) {
				willUpdateURLs.add(link);
			}
		}
		return willUpdateURLs;
	}

	// calculates how much rating to give to each page in the references list
	public double amtAddToRef(LinkedList<String> references) {
		if (references.size() == 0) {
			return 0;
		}
		return (1.0 / references.size());
	}

}