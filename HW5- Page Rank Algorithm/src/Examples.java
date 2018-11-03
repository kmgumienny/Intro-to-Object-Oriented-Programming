
/*
 * If you are looking at this file before Thurs/Fri, the try/catch
 * statements won't make sense (unless you already know exceptions).
 * By Friday, we will cover those.  In the meantime, you can write
 * tests by creating your search engine classes in the Examples
 * constructor, as indicated by the comments.
 */

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {
	// declare variables for all of your search engines here
	SearchEngine s;
	SearchEngine emptySE;

	// local method to add a page to a search engine. Created a
	// helper so that we can isolate the exception handling here,
	// rather than clutter up each test case with the exceptions
	private void addPage(SearchEngine s, String p) {
		try {
			s.visitPage(p);
		} catch (FileNotFoundException e) {
			fail("Aborting Example setup -- file not found: " + e);
		} catch (UnsupportedFileExn e) {
			fail("Aborting Examples setup -- unsupported file extension: " + e);
		}
	}

	public Examples() {
		try {

			// set up all of your search engines with pages here
			// rather than in the individual tests (or you will have
			// to copy the exceptions code into the test classes)
			emptySE = new SearchEngine(new LinkedList<String>());
			s = new SearchEngine(new LinkedList<String>());
			addPage(s, "src/PageFiles/goats.md");
			addPage(s, "src/PageFiles/aboutWPI.md");
			addPage(s, "src/PageFiles/worcester.md");
		} catch (FileNotFoundException e) {
			System.out.println("Aborting Example setup -- file not found: " + e);
		} catch (UnsupportedFileExn e) {
			System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
		}
	}

	// HW5 Test
	// searches already filled search engine for a string
	@Test
	public void testGoatsQuery() {
		assertEquals(s.runQuery("goat").size(), 2);
	}



	// test knownPageCount on already filled search engine
	@Test
	public void testSKnownPageCount() {
		assertEquals(s.knownPageCount(), 3);
	}

	// search empty search engine for word
	// produces 0
	@Test
	public void testEmptySERunQuery() {
		assertEquals(emptySE.runQuery("").size(), 0);
	}

	// use visitPage on an empty search engine
	// to test whether the webpage is added
	@Test
	public void testEmptySEVisitWebpage() {
		try {
			emptySE.visitPage("src/PageFiles/goats.md");
			assertEquals(emptySE.knownPageCount(), 1);
		} catch (FileNotFoundException e) {
			System.out.println("Aborting Example setup -- file not found: " + e);
		} catch (UnsupportedFileExn e) {
			System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
		}

	}

	// use visitPage on an empty search engine
	// to test whether the 2 webpages are added
	@Test
	public void testEmptySEKnownPageCount1() {
		try {
			emptySE.visitPage("src/PageFiles/goats.md");
			emptySE.visitPage("src/PageFiles/aboutWPI.md");
			assertEquals(emptySE.knownPageCount(), 2);
		} catch (FileNotFoundException e) {
			System.out.println("Aborting Example setup -- file not found: " + e);
		} catch (UnsupportedFileExn e) {
			System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
		}
	}

	// check whether knownPageCount works on
	// an empty list
	// produces 0
	@Test
	public void testEmptySEKnownPageCount() {
		assertEquals(emptySE.knownPageCount(), 0);
	}

	// checks an empty search engine with no previous queries
	// to see whether a word has been searched
	@Test
	public void testEmptySEAlreadySawQueryEmpty() {
		assertFalse(emptySE.alreadySawQuery("pineapple"));
	}

	// after searching word, alreadySawQuery will produce true
	// for the same word in lowercase form
	@Test
	public void testEmptySEAlreadySawQueryItem() {
		emptySE.runQuery("WPI");
		assertTrue(emptySE.alreadySawQuery("wpi"));
	}

	// tests visitPage by adding a page and then adding another page to check
	// if runQuery updates with visitPage
	@Test
	public void testEmptySEVisitPageQuery() {
		try {
			emptySE.visitPage("src/PageFiles/goats.md");
			assertEquals(emptySE.runQuery("goat").size(), 1);
			emptySE.visitPage("src/PageFiles/aboutWPI.md");
			assertEquals(emptySE.runQuery("goat").size(), 2);
		} catch (FileNotFoundException e) {
			System.out.println("Aborting Example setup -- file not found: " + e);
		} catch (UnsupportedFileExn e) {
			System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
		}

	}

	// HW6 Tests
	
	// testing sortWebpages where all the Webpages have a set rank of zero
	// the order in which they are instantiated is the order that they appear
	// after the method is called
	@Test
	public void sortWebpagesTest1() {
		s.runQuery("WPI");
		s.runQuery("Goat");
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", new LinkedList<String>());
		Webpage w3 = new Webpage("src/PageFiles/webpage3.md", "wp3", "this is wp3", new LinkedList<String>());
		Webpage w4 = new Webpage("src/PageFiles/webpage4.md", "wp4", "this is wp4", new LinkedList<String>());
		Webpage w5 = new Webpage("src/PageFiles/webpage5.md", "wp5", "this is wp5", new LinkedList<String>());
		Webpage w6 = new Webpage("src/PageFiles/webpage6.md", "wp6", "this is wp6", new LinkedList<String>());
		Webpage w7 = new Webpage("src/PageFiles/webpage7.md", "wp7", "this is wp7", new LinkedList<String>());
		
		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);
		testWebs.add(w3);
		testWebs.add(w4);
		testWebs.add(w5);
		testWebs.add(w6);
		testWebs.add(w7);
		
		assertEquals(testWebs, emptySE.sortWebpages(testWebs));
	}
	
	// testing sortWebpages where all the Webpages are all the same
	// the time that each is instantiated will define their place in the list
	@Test
	public void sortWebpagesTest2() {
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		w1.rank = 5.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", new LinkedList<String>());
		w2.rank = 5.0;
		Webpage w3 = new Webpage("src/PageFiles/webpage3.md", "wp3", "this is wp3", new LinkedList<String>());
		w3.rank = 5.0;
		Webpage w4 = new Webpage("src/PageFiles/webpage4.md", "wp4", "this is wp4", new LinkedList<String>());
		w4.rank = 5.0;
		Webpage w5 = new Webpage("src/PageFiles/webpage5.md", "wp5", "this is wp5", new LinkedList<String>());
		w5.rank = 5.0;
		Webpage w6 = new Webpage("src/PageFiles/webpage6.md", "wp6", "this is wp6", new LinkedList<String>());
		w6.rank = 5.0;
		Webpage w7 = new Webpage("src/PageFiles/webpage7.md", "wp7", "this is wp7", new LinkedList<String>());
		w7.rank = 5.0;
		
		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);
		testWebs.add(w3);
		testWebs.add(w4);
		testWebs.add(w5);
		testWebs.add(w6);
		testWebs.add(w7);
		
		LinkedList<Webpage> sortedTestWebs = new LinkedList<Webpage>();
		sortedTestWebs.add(w1);
		sortedTestWebs.add(w2);
		sortedTestWebs.add(w3);
		sortedTestWebs.add(w4);
		sortedTestWebs.add(w5);
		sortedTestWebs.add(w6);
		sortedTestWebs.add(w7);
		
		assertEquals(sortedTestWebs, emptySE.sortWebpages(testWebs));
	}	
	
	// testing sortWebpages where all the Webpages are different and displays the webpages
	// from greatest to smallest
	@Test
	public void sortWebpagesTest3() {
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		w1.rank = 5.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", new LinkedList<String>());
		w2.rank = 4.1;
		Webpage w3 = new Webpage("src/PageFiles/webpage3.md", "wp3", "this is wp3", new LinkedList<String>());
		w3.rank = 4.3;
		Webpage w4 = new Webpage("src/PageFiles/webpage4.md", "wp4", "this is wp4", new LinkedList<String>());
		w4.rank = 4.2;
		Webpage w5 = new Webpage("src/PageFiles/webpage5.md", "wp5", "this is wp5", new LinkedList<String>());
		w5.rank = 4.4;
		Webpage w6 = new Webpage("src/PageFiles/webpage6.md", "wp6", "this is wp6", new LinkedList<String>());
		w6.rank = 4.9;
		Webpage w7 = new Webpage("src/PageFiles/webpage7.md", "wp7", "this is wp7", new LinkedList<String>());
		w7.rank = 1.0;
			
		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);
		testWebs.add(w3);
		testWebs.add(w4);
		testWebs.add(w5);
		testWebs.add(w6);
		testWebs.add(w7);
			
		LinkedList<Webpage> sortedTestWebs = new LinkedList<Webpage>();
		
		sortedTestWebs.add(w1);
		sortedTestWebs.add(w6);
		sortedTestWebs.add(w5);
		sortedTestWebs.add(w3);
		sortedTestWebs.add(w4);
		sortedTestWebs.add(w2);
		sortedTestWebs.add(w7);
			
		assertEquals(sortedTestWebs, emptySE.sortWebpages(testWebs));
		}		
	
	// testing whether updateSponsor creates a new sponsor with a rate
	// with no exception
	@Test
	public void updateRateTest1() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.09);
	}
	
	// testing whether updateSponsor creates a new sponsor with a rate and makes another sponsor with a rate
	// with no exception
	@Test
	public void updateRateTest2() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.09);
		s.updateSponsor("Goat", 0.02);
	}
	
	// testing whether updateSponsor creates a new sponsor with a rate and updates sponsor with the new rate
	// with no exception
	@Test
	public void updateRateTest3() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.09);
		s.updateSponsor("WPI", 0.091);
	}
	
	// testing whether updateSponsor can take in a newRate at the 0.0 boundary
	// with no exception
	@Test
	public void updateRateTest4() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.0);
	}
	
	// testing whether updateSponsor can take in a newRate at the 0.1 boundary
	// with no exception
	@Test
	public void updateRateTest5() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.1);
	}



	//Tests credit distribution for 2 different pages with 1 reference.
	@Test
	public void creditDistributionTest() {
		LinkedList<String> wp1String = new LinkedList<>();
		wp1String.add("src/PageFiles/webpage1.md");
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		w1.rank = 1.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", wp1String);
		w2.rank = 1.0;

		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);


		emptySE.updateReferences(testWebs);
		Double two = 2.0;
		assertEquals(w1.rank, two);
	}

	//Tests credit distribution for 2 different pages with 1 reference and 1 mutual reference.
	@Test
	public void creditDistributionTest2() {
		LinkedList<String> references = new LinkedList<>();
		references.add("src/PageFiles/webpage1.md");
		references.add("src/PageFiles/webpage2.md");
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		w1.rank = 1.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", references);
		w2.rank = 1.0;

		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);


		emptySE.updateReferences(testWebs);
		Double two = 2.0;
		Double one = 1.0;
		assertEquals(w1.rank, two);
		assertEquals(w2.rank, one);
	}

	//Tests credit distribution for 3 different pages with 2 reference and 1 mutual reference.
	@Test
	public void creditDistributionTest3() {
		LinkedList<String> references = new LinkedList<>();
		references.add("src/PageFiles/webpage1.md");
		references.add("src/PageFiles/webpage2.md");
		references.add("src/PageFiles/webpage3.md");
		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", new LinkedList<String>());
		w1.rank = 1.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", references);
		w2.rank = 1.0;
		Webpage w3 = new Webpage("src/PageFiles/webpage3.md", "wp3", "this is wp3", new LinkedList<String>());
		w3.rank = 1.0;

		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);
		testWebs.add(w3);


		emptySE.updateReferences(testWebs);
		Double oneAndHalf = 1.5;
		Double one = 1.0;
		assertEquals(w1.rank, oneAndHalf);
		assertEquals(w2.rank, one);
		assertEquals(w3.rank, oneAndHalf);
	}

	//Tests credit distribution for 1 page from 2 reference, 1 page from 1 reference and a self reference
	@Test
	public void creditDistributionTest4() {
		LinkedList<String> references = new LinkedList<>();
		references.add("src/PageFiles/webpage1.md");

		LinkedList<String> references2 = new LinkedList<>();
		references2.add("src/PageFiles/webpage2.md");
		references2.add("src/PageFiles/webpage1.md");

		Webpage w1 = new Webpage("src/PageFiles/webpage1.md", "wp1", "this is wp1", references2);
		w1.rank = 1.0;
		Webpage w2 = new Webpage("src/PageFiles/webpage2.md", "wp2", "this is wp2", references);
		w2.rank = 1.0;
		Webpage w3 = new Webpage("src/PageFiles/webpage3.md", "wp3", "this is wp3", references);
		w3.rank = 1.0;

		LinkedList<Webpage> testWebs = new LinkedList<Webpage>();
		testWebs.add(w1);
		testWebs.add(w2);
		testWebs.add(w3);


		emptySE.updateReferences(testWebs);
		Double three = 3.0;
		Double two = 2.0;
		Double one = 1.0;
		assertEquals(w1.rank, three);
		assertEquals(w2.rank, two);
		assertEquals(w3.rank, one);
	}


	//Tests to see that webpages actually get rates updates
	@Test
	public void testRunQuery() throws LowerRateException, InvalidRateException{
		s.updateSponsor("WPI", .01);
		s.runQuery("wpi");
		double pointOne = 0.1;
		assertEquals(s.getSponsoredRate("WPI"), 0.01, 0.001);

	}

	//Tests to see that webpages are sorted properly
	@Test
	public void testRunQuery2() throws LowerRateException, InvalidRateException{
		LinkedList<Webpage> aList = new LinkedList<Webpage>();
		s.updateSponsor("WPI", 0.01);
		s.updateSponsor("worcester", 0.02);
		aList= s.runQuery("wpi");
		assertEquals(aList.get(0).rank, 0.02, 0.001);
	}

	// Exception Tests
	
	// Testing an update that is too low and should throw an
	// InvalidRateException
	@Test(expected = InvalidRateException.class)
	public void invalidRateTest1() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", -1.0);
	}

	// Testing an update that is too high and should throw an
	// InvalidRateException
	@Test(expected = InvalidRateException.class)
	public void invalidRateTest2() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 11);
	}

	// Creates a sponsor with a rate and updates sponsor with a lower rate to
	// call a lower rate exception
	@Test(expected = LowerRateException.class)
	public void lowerRateTest1() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.01);
		s.updateSponsor("WPI", 0.001);
	}

	// Creates a sponsor with a rate and updates sponsor with a lower rate to
	// call a lower rate exception
	@Test(expected = LowerRateException.class)
	public void lowerRateTest2() throws LowerRateException, InvalidRateException {
		s.updateSponsor("WPI", 0.09);
		s.updateSponsor("WPI", 0.01);
	}
	
	
	

}
