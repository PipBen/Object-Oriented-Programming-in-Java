package midterm1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class EarthquakeStore {
	ArrayList<Earthquake> earthquakes;
	ArrayList<Month> months;
	Earthquake maxMagQuake;
	
	public EarthquakeStore(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		this.earthquakes= new ArrayList<Earthquake>();
		br.readLine();
		br.readLine();
		String line=br.readLine();
		int initialMonth=1;
		while (line!= null) {
			Earthquake earthquake = new Earthquake(line);
			earthquakes.add(earthquake);
			line=br.readLine();
		}
	}

	/**
	 * @return the earthquakes
	 */
	public ArrayList<Earthquake> getEarthquakes() {
		return earthquakes;
	}

	/**
	 * @param earthquakes the earthquakes to set
	 */
	public void setEarthquakes(ArrayList<Earthquake> earthquakes) {
		this.earthquakes = earthquakes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return earthquakes.toString();
	}
	
	public Earthquake getLargestMagnitude() {
		double maxMag=0;
		for(int n=0; n<earthquakes.size();n++) {
			Earthquake earthquake = earthquakes.get(n);
			double magnitude = earthquake.getMagnitude();
			if(magnitude>maxMag) {
				maxMagQuake=earthquake;
				maxMag=magnitude;
			}
		}
		return maxMagQuake;
	}

}
