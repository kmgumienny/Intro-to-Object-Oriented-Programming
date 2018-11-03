import java.util.LinkedList;

public class PageSystem implements IPageSystem {
	LinkedList<Webpage> pages = new LinkedList<Webpage>();

	// adds a webpage to the LinkedList of webpages
	public void add(Webpage aPage) {
		pages.add(aPage);
	}

	// takes a query and finds all the webpages that contain that string
	public LinkedList<Webpage> getPages(String query) {
		LinkedList<Webpage> resultingPages = new LinkedList<Webpage>();
		for (Webpage aPage : pages) {
			if (aPage.contains(query) || aPage.contains(query)) {
				resultingPages.add(aPage);
			}
		}
		return resultingPages;
	}

	// looks for a page with the given location/url
	public Webpage findPage(String location) {
		for (Webpage aPage : pages) {
			if (aPage.url.equals(location)) {
				return aPage;
			}
		}
		return null;
	}

	// returns the size of the LinkedList of pages
	public Integer size() {
		return pages.size();
	}

	// returns a list of webpages
	public LinkedList<Webpage> getListOfPages() {
		return pages;
	}

	// converts a LinkedList of String urls into a LinkedList
	// of webpages
	public LinkedList<Webpage> convertToWebpage(LinkedList<String> references) {
		LinkedList<Webpage> webpages = new LinkedList<Webpage>();
		for (String link : references) {
			webpages.add(findPage(link));
		}
		return webpages;
	}

}
