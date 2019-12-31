package exam1718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class AirportDataStore {
	public ArrayList<Airport> airports;
	public HashMap<String,String> codeFullNameHash = new HashMap<String,String>();
	
	public AirportDataStore(String urlName) throws IOException{
		//unpack from url and create BufferedReader
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
	
	public void getCodeFullNameHash(){
		//HashMap<String,String> codeFullNameHash= new HashMap<String,String>();
		for(int n=0;n<airports.size();n++) {
			Airport airport= airports.get(n);
			codeFullNameHash.put(airport.getCode(), airport.getFullName());
		}
	}
	
	public int getSize(){
		return airports.size();
	}
	
	public Airport getIndex(int index) {
		return airports.get(index);
	}
	
	public String toString() {
		return airports.toString();
	}

}
