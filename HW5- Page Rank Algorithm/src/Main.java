import java.util.LinkedList;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String [] args) throws FileNotFoundException, UnsupportedFileExn{
		BrowserWindow bw = new BrowserWindow(new SearchEngine(new LinkedList<String>()));
		bw.screen();
	}
}

