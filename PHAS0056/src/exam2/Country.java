package exam2;

import java.util.Scanner;

public class Country {
	
	String countryID;
	StringBuilder name;
	
	/** Class representing a country data point
	 * @param line line of data
	 */
	public Country(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(" ");
		this.countryID=s.next();
		StringBuilder name = new StringBuilder();
		while(s.hasNext()) {
			name.append(s.next());
		}
		this.name=name;
		s.close();
		
	}

	/**
	 * @return the countryID
	 */
	public String getCountryID() {
		return countryID;
	}

	/**
	 * @return the name
	 */
	public StringBuilder getName() {
		return name;
	}

	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(StringBuilder name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [countryID=" + countryID + ", name=" + name + "]";
	}

}
