package exam1617;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Class to store Index objects
 * @author pipbe
 *
 */
public class IndexStore {
	
	public ArrayList<Index> indices;
	
	/**
	 * Creates a storage object of Index object from file
	 * @param urlName url to read from
	 * @throws Exception
	 */
	public IndexStore(String urlName) throws Exception {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.indices= new ArrayList<Index>();
		while (line!= null) {
			Index index = new Index(line);
			indices.add(index);
			line=br.readLine();
		}
	}
	/**
	 * Get ArrayList of Index objects
	 * @return indices an ArrayList of objects
	 */
	public ArrayList<Index> getIndices() {
		return indices;
	}

	public void setIndices(ArrayList<Index> indices) {
		this.indices = indices;
	}
	
	

}
