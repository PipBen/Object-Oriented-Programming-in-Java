package midterm1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

/**Class to unpack Earthquake data and unpack into suitable objects
 * @author zcappbe
 *
 */
public class EarthquakeStore {
	ArrayList<Earthquake> earthquakes;
	ArrayList<Month> months= new ArrayList<Month>();
	Earthquake maxMagQuake;
	ArrayList<Earthquake> monthQuakes= new ArrayList<Earthquake>();
	
	/**Unpacks data from url into an ArrayList of Earthquake objects and and an ArrayList of Month objects containing earthquakes
	 * that took place in that month
	 * @param urlName data url
	 * @throws IOException
	 */
	public EarthquakeStore(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		this.earthquakes= new ArrayList<Earthquake>();
		br.readLine();
		br.readLine();
		String line=br.readLine();
		int monthInt=1;
		while (line!= null) {
			Earthquake earthquake = new Earthquake(line);
			if(earthquake.getMonth()==monthInt) {
				monthQuakes.add(earthquake);
			}
			else {
				Month month= new Month(monthQuakes);
				monthQuakes=new ArrayList<Earthquake>();
				months.add(month);
				//monthQuakes.clear();
				monthQuakes.add(earthquake);
				monthInt=earthquake.getMonth();
				
			}
			earthquakes.add(earthquake);
			line=br.readLine();
		}
		Month month= new Month(monthQuakes);
		months.add(month);
		
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
	
	/**
	 * @return maxMagQuake earthquake with greatest magnitude
	 */
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

	/**
	 * @return the months
	 */
	public ArrayList<Month> getMonths() {
		return months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(ArrayList<Month> months) {
		this.months = months;
	}
	
	/**Scans over each month and prints relevant data
	 * 
	 */
	public void scanMonths() {
		for(int i=0;i<months.size();i++) {
			Month month = months.get(i);
			String monthName =new DateFormatSymbols().getMonths()[i];
			System.out.println(monthName+": \nNumber of Earthquakes: "+ month.getNumberMonthquakes()
			+ "\nDeepest Earthquake: "+ month.getDeepestEarthquake()+ "\nMost Accurately Known Depth:"
					+ month.getMostPreciseDepth());
		}
	}

}
