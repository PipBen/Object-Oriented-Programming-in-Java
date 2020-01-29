package exam2;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Station {
	
	String id;
	StringBuilder name;
	String countryID;
	
	/**Class representing a line of data from stations.txt
	 * @param line line of date
	 */
	public Station(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(" ");
		this.id=s.next();
		StringBuilder name = new StringBuilder();
		while(s.hasNext()) {
			name.append(s.next());
		}
		this.name=name;
		s.close();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public StringBuilder getName() {
		return name;
	}

	/**
	 * @return the countryID
	 */
	public String getCountryID() {
		return countryID;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(StringBuilder name) {
		this.name = name;
	}

	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", countryID=" + countryID + "]";
	}
	

}
