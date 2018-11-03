import java.util.LinkedList;
import java.util.Collections;

public interface IPageSystem {
	// adds a webpage to the LinkedList of webpages
	public void add(Webpage aPage);

	// takes a query and finds all the webpages that contain that string
	public LinkedList<Webpage> getPages(String query);

	// looks for a page with the given location/url
	public Webpage findPage(String location);

	// returns the size of the LinkedList of pages
	public Integer size();

	// returns a list of webpages
	public LinkedList<Webpage> getListOfPages();

	// converts a LinkedList of String urls into a LinkedList
	// of webpages
	public LinkedList<Webpage> convertToWebpage(LinkedList<String> references);
}
