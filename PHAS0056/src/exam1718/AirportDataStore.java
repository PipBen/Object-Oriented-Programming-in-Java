package exam1718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**A Class that stores Airport data read from a url
 * @author P.Benjamin
 */
public class AirportDataStore {
	public ArrayList<Airport> airports;
	public HashMap<String,String> codeFullNameHash = new HashMap<String,String>();
	
	
	/**Constructs an AirportDataStore object from a url containing Airport information
	 * @param urlName 
	 * @throws IOException
	 */
	public AirportDataStore(String urlName) throws IOException{
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.airports= new ArrayList<Airport>();
		while (line!= null) {
			Airport airport = new Airport(line);
			airports.add(airport);
			line=br.readLine();
			
		}
	}
	
	/**get HashMap of with code as key and full name as value
	 * @return HashMap of code key and full name value*/
	public void getCodeFullNameHash(){
		//HashMap<String,String> codeFullNameHash= new HashMap<String,String>();
		for(int n=0;n<airports.size();n++) {
			Airport airport= airports.get(n);
			codeFullNameHash.put(airport.getCode(), airport.getFullName());
		}
	}
	
	/**return the number of airport objects in the data store
	 * @return int size number of airports in data store*/
	public int getSize(){
		return airports.size();
	}
	
	/**get airport object at the given index
	 * @return Airport getIndex*/
	public Airport getIndex(int index) {
		return airports.get(index);
	}
	/** return toString method of each Airport object in ArrayList
	 * @return String*/
	public String toString() {
		return airports.toString();
	}

}
