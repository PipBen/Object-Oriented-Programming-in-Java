package midterm1516;

import java.util.ArrayList;

public class Month {
	
	ArrayList<Earthquake> monthEarthquakes; //earthquakes that took place this month
	int year;
	int monthNo;
	Earthquake deepestQuake;
	Earthquake mostPreciseDepth;
	
	/**
	 * @param earthquakes an ArrayList of Earthquake objects with a common month
	 */
	public Month(ArrayList<Earthquake> earthquakes) {
		this.monthEarthquakes=earthquakes;
		this.year=earthquakes.get(0).getYear();
		this.monthNo=earthquakes.get(0).getMonth();
	}

	/**
	 * @return the monthEarthquakes
	 */
	public ArrayList<Earthquake> getMonthEarthquakes() {
		return monthEarthquakes;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the monthNo
	 */
	public int getMonthNo() {
		return monthNo;
	}

	/**
	 * @param monthEarthquakes the monthEarthquakes to set
	 */
	public void setMonthEarthquakes(ArrayList<Earthquake> monthEarthquakes) {
		this.monthEarthquakes = monthEarthquakes;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param monthNo the monthNo to set
	 */
	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}
	
	public String toString() {
		return monthEarthquakes.toString();
	}
	
	/**
	 * @return the number of earthquakes that took place this month
	 */
	public int getNumberMonthquakes() {
		return monthEarthquakes.size();
	}
	
	/**Finds and returns the Earthquake with the greatest depth in this month
	 * @return deepestQuake the deepest Earthquake
	 */
	public Earthquake getDeepestEarthquake() {
		double deepest=0;
		for(int n=0; n<monthEarthquakes.size();n++) {
			Earthquake earthquake = monthEarthquakes.get(n);
			if(earthquake.getDep()>deepest) {
				deepestQuake = earthquake;
				deepest = earthquake.getDep();
			}
		}
		return deepestQuake;
	}
	
	/** Returns the Earthquake whose depth is known with the smallest uncertainty 
	 * @return
	 */
	public Earthquake getMostPreciseDepth() {
		double maxEZ= 1;
		for(int n=0; n<monthEarthquakes.size();n++) {
			Earthquake earthquake = monthEarthquakes.get(n);
			if(earthquake.getEz()!=null) {
				if(earthquake.getEz()<maxEZ ) {
					mostPreciseDepth= earthquake;
					maxEZ=earthquake.getEz();
				}
			}
		}
		return mostPreciseDepth;
	}

}
