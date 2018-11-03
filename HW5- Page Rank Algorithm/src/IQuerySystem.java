import java.util.LinkedList;
import java.util.HashMap;

public interface IQuerySystem {
	
	// get a list of queries that are in the system
	public LinkedList<String> getKeys();
	// get a query's webpages
	public LinkedList<Webpage> getQueryPages(String queryName);
	// find existing query and add page to query
	public void addPageToPreviousQueries(Webpage newPage );
	// make new query, with list of webpages
	public LinkedList<Webpage> saveQuery(String query, LinkedList<Webpage> newPageList);
	// checks if a query exists in the QuerySytem
	public boolean isQueryExist(String query);
}
