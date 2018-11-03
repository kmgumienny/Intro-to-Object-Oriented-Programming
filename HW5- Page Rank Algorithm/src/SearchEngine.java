// Joseph Yuen jhyuen@wpi.edu
// Kamil Gumienny kmgumienny@wpi.edu

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class SearchEngine implements ISearchEngine {
	// leave these first two variables alone
	Scanner keyboard = new Scanner(System.in);
	SimpleMarkdownReader m = new SimpleMarkdownReader();

	// you are welcome to replace the pages variable with your own data
	// structures.
	// the specific name "pages" will not be referenced in any of our
	// tests/autograding
	private IPageSystem pages;

	private IQuerySystem pastQueries;

	private ISponsorSystem sponsors;

	// constructor
	// you are welcome to change what the constructor does, as long as you leave
	// the header intact
	SearchEngine(LinkedList<String> initPages) throws FileNotFoundException, UnsupportedFileExn {
		pages = new PageSystem();
		pastQueries = new QuerySystem();
		sponsors = new SponsorSystem();
		for (String pageLoc : initPages) {
			pages.add(addSite(pageLoc));
		}
	}

	// ****** THE SEARCH ENGINE METHODS YOU NEED TO PROVIDE ***********
	// Even if you encapuslate (full version), leave methods with these headers
	// in the SearchEngine class (our tests/autograding expect to find them
	// here)

	// given query string, produce webpages that meet query
	// you will need to edit this, but do not edit the header (autograding
	// expects this)
	public LinkedList<Webpage> runQuery(String query) {
		LinkedList<Webpage> aList = new LinkedList<Webpage>();
		LinkedList<Webpage> sortedRank = new LinkedList<Webpage>();
		String strippedQuery = stripFillers(query);

		if (pastQueries.isQueryExist(query)) {
			aList = pastQueries.getQueryPages(query);
			for (Webpage a : aList) {
				a.setRankZero();
			}
			updateReferences(aList);
			sortedRank = updateListRank(aList);
			return sortWebpages(sortedRank);
		} else {
			// access pages and for each page that matches the query,
			// add the page to the list of matched web pages
			// save list webpages to strippedQuery
			aList = pastQueries.saveQuery(strippedQuery, pages.getPages(strippedQuery));
			for (Webpage a : aList) {
				a.setRankZero();
			}
			updateReferences(aList);
			sortedRank = updateListRank(aList);
			return sortWebpages(sortedRank);
		}
	}

	// given a page location, return the corresponding page after updating
	// queries
	// you will need to edit this, but do not edit the header (autograding
	// expects this)
	public Webpage visitPage(String location) throws UnsupportedFileExn, FileNotFoundException {
		// check if the desired page is in the initial pages
		// set desiredWebpage to the located page
		if (pages.findPage(location) != null) {
			return pages.findPage(location);
		}

		Webpage desiredWebpage = addSite(location);
		pastQueries.addPageToPreviousQueries(desiredWebpage);
		pages.add(desiredWebpage);
		return desiredWebpage;
	}

	// produce the number of web pages known in the system
	// you are welcome to edit this method as long as you leave the header
	// intact (autograding expects this)
	public int knownPageCount() {
		return pages.size();
	}

	// determine whether given query has been seen in the search engine
	// you will need to edit this, but do not edit the header (autograding
	// expects this)
	public boolean alreadySawQuery(String query) {
		return pastQueries.isQueryExist(query);
	}

	// ****** ADDING SITES TO THE ENGINE ***************
	// parses given file into a webpage
	// you are welcome to edit this method as long as you leave the header
	// intact.
	// you should NOT need to edit the call to readPage (you may want to add
	// statements around it though)
	Webpage addSite(String locationName) throws UnsupportedFileExn, FileNotFoundException {
		Webpage newWP;
		if (locationName.endsWith(".md")) {
			return (m.readPage(locationName));
		} else {
			throw new UnsupportedFileExn(locationName);
		}
	}

	// ****** REMOVING FILLER WORDS FROM QUERIES *****************
	// Don't edit either the list of fillerWords or the stripFillers method
	private LinkedList<String> fillerWords = new LinkedList<String>(
			Arrays.asList("a", "an", "the", "of", "on", "in", "to", "by", "about", "how", "is", "what", "when"));

	// remove the filler words from a string
	// assume string has no punctuation
	private String stripFillers(String query) {
		String[] wordArray = query.toLowerCase().split(" ");
		String resultStr = "";
		for (int i = 0; i < wordArray.length; i++) {
			if (!(fillerWords.contains(wordArray[i])))
				resultStr = resultStr + wordArray[i];
		}
		return resultStr;
	}

	// sorts a list of webpages from greatest to least ranking
	public LinkedList<Webpage> sortWebpages(LinkedList<Webpage> aList) {
		Collections.sort(aList);
		return aList;
	}

	// adds or replaces a sponsor into the sponsor system 
	// with their corresponding rate
	public void updateSponsor(String sponsorName, double newRate) throws LowerRateException, InvalidRateException {
		sponsors.updateRate(sponsorName, newRate);
	}

	// consumes a webpage URL and returns a double indicating how many
	// sponsors are paying for this page
	// each page has at most one sponsor
	public double getSponsoredRate(String url) {
		return sponsors.calculateRate(url);
	}


	// examines a list of webpages and updates each webpage based on the 
	// sponsor url
	public LinkedList<Webpage> updateListRank(LinkedList<Webpage> aList) {
		for (Webpage a : aList) {
			a.updateRank(getSponsoredRate(a.url));
		}
		return aList;
	}

	// adds the proper number of rating points to the references
	public void updateReferences(LinkedList<Webpage> aList) {
		LinkedList<String> nonSelfReferenced = new LinkedList<String>();
		for (Webpage aPage : aList) {

			//aPage.updateRank(aPage.amtAddToRef(aPage.referencesList()));
			nonSelfReferenced = aPage.referencesList();
			double amtToAdd = aPage.amtAddToRef(aPage.referencesList());
			for (Webpage page : aList) {
				for (String aURL : nonSelfReferenced)
					if (page.url.equals(aURL)) {
					page.updateRank(amtToAdd);
				}
			}
			nonSelfReferenced.clear();
		}
	}

}
