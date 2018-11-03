import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class QuerySystem implements IQuerySystem {

	private HashMap<String, LinkedList<Webpage>> pastQueries = new HashMap<String, LinkedList<Webpage>>();
	
	// get a list of queries that are in the system
	public LinkedList<String> getKeys() {
		LinkedList<String> queryList = new LinkedList<String>();

		for (String query : pastQueries.keySet()) {
			queryList.add(query);
		}

		return queryList;
	}
	
	// get a query's webpages
	public LinkedList<Webpage> getQueryPages(String queryName) {
		for (String query : this.getKeys()) {
			if (query.equals(queryName)) {
				return pastQueries.get(query);
			}
		}
		return new LinkedList<Webpage>();
	}

	// find existing query and add page to query
	public void addPageToPreviousQueries(Webpage newPage) {
		for (String search : pastQueries.keySet()) {
			if (newPage.contains(search)) {
				pastQueries.get(search).add(newPage);
			}
		}
	}
	
	// make new query, with list of webpages
	public LinkedList<Webpage> saveQuery(String query, LinkedList<Webpage> newPageList) {
		pastQueries.put(query, newPageList);
		return newPageList;
	}
	
	// checks if a query exists in the QuerySytem
	public boolean isQueryExist(String query) {
		for (String search : pastQueries.keySet()) {
			if (query.equals(search)) {
				return true;
			}
		}
		return false;
	}

}
