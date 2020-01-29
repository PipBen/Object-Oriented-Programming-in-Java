package exam2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Reading {
	
	String id;
	String countryID;
	int year;
	int month;
	String type;
	ArrayList<Double> readings;
	Date date;
	StringBuilder stationName;
	StringBuilder countryName;
	
	public Reading (String line, StationStore stationStore,CountryStore countryStore) {
		Scanner s = new Scanner(line);
		s.useDelimiter(" ");
		
		this.id=s.next();
		this.countryID=this.id.substring(0,2);
		HashMap<String,StringBuilder> idNameMap =stationStore.getIdNameMap();
		HashMap<String,StringBuilder> idCountryMap = countryStore.getIdCountryMap();
		this.stationName=idNameMap.get(id);
		this.countryName=idCountryMap.get(countryID);
		this.year=s.nextInt();
		this.month=s.nextInt();
		this.type=s.next();
		this.date=new Date(year-month-01);
		readings= new ArrayList<Double>();
		while (s.hasNext()) {
			readings.add(s.nextDouble());
		}
		//System.out.println("hello");
		s.close();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the readings
	 */
	public ArrayList<Double> getReadings() {
		return readings;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

//	/**
//	 * @param readings the readings to set
//	 */
//	public void setReadings(ArrayList<Double> readings) {
//		this.readings = readings;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stationName.toString()+countryName.toString()+date.toString();
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the countryID
	 */
	public String getCountryID() {
		return countryID;
	}

	/**
	 * @return the stationName
	 */
	public StringBuilder getStationName() {
		return stationName;
	}

	/**
	 * @return the countryName
	 */
	public StringBuilder getCountryName() {
		return countryName;
	}

	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	/**
	 * @param readings the readings to set
	 */
	public void setReadings(ArrayList<Double> readings) {
		this.readings = readings;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(StringBuilder stationName) {
		this.stationName = stationName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(StringBuilder countryName) {
		this.countryName = countryName;
	}
	




}
