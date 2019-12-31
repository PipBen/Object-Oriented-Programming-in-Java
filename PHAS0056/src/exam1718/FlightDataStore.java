package exam1718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class FlightDataStore {
	ArrayList<Flight> flights;
	Flight cheapestFlight;
	public FlightDataStore(String urlName, AirportDataStore airports) throws IOException{
		//unpack from url and create BufferedReader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		
		this.flights= new ArrayList<Flight>();
		while (line!= null) {
			Flight flight = new Flight(line,airports);
			
			flights.add(flight);
			line=br.readLine();
		}
	}
	
	public ArrayList<Flight> getArrayList(){
		return flights;
	}
	
	public int getSize() {
		return flights.size();
	}
	
	public Flight getIndex(int n) {
		return flights.get(n);
	}
	
	public String toString() {
		return flights.toString();
	}
	
	
}
