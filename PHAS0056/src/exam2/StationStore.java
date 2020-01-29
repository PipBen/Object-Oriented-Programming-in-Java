package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class StationStore {
	
	ArrayList<Station> stations;
	HashMap<String,StringBuilder> idNameMap= new HashMap<String,StringBuilder>();
	
	public StationStore(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.stations= new ArrayList<Station>();
		while(line!=null) {
			Station station = new Station(line);
			idNameMap.put(station.getId(), station.getName());
			stations.add(station);
			line= br.readLine();
		}
	}
	
	public String toString() {
		return stations.toString();
	}

	/**
	 * @return the stations
	 */
	public ArrayList<Station> getStations() {
		return stations;
	}

	/**
	 * @return the idNameMap
	 */
	public HashMap<String, StringBuilder> getIdNameMap() {
		return idNameMap;
	}

	/**
	 * @param stations the stations to set
	 */
	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	/**
	 * @param idNameMap the idNameMap to set
	 */
	public void setIdNameMap(HashMap<String, StringBuilder> idNameMap) {
		this.idNameMap = idNameMap;
	}

}
