package midterm1516;

import java.util.Scanner;

public class Earthquake {
	
	//variable names as given
	int year;
	int month;
	int day;
	int hour;
	int minute;
	double second;
	double latitude;
	double longitude;
	double dep;
	Double eh1;
	Double eh2;
	Double az;
	Double ez;
	double magnitude;
	double id;
	
	/**Takes a line from data file and assigns variables to each earthquake
	 * @param line a single line of data
	 */
	public Earthquake(String line) {
		Scanner s = new Scanner(line);
		this.year=s.nextInt();
		this.month=s.nextInt();
		this.day=s.nextInt();
		this.hour=s.nextInt();
		this.minute=s.nextInt();
		this.second=s.nextDouble();
		this.latitude=s.nextDouble();
		this.longitude=s.nextDouble();
		this.dep=s.nextDouble();
		double eh1=s.nextDouble();
		double eh2=s.nextDouble();
		double az=s.nextDouble();
		double ez=s.nextDouble();
		if(eh1==-1) {
			this.eh1=null;
			this.eh2=null;
			this.az=null;
			this.ez=null;
		}
		else {
			this.eh1=eh1;
			this.eh2=eh2;
			this.az=az;
			this.ez=ez;
		}
		
		this.magnitude=s.nextDouble();
		this.id=s.nextDouble();
		s.close();
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
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @return the second
	 */
	public double getSecond() {
		return second;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the dep
	 */
	public double getDep() {
		return dep;
	}

	/**
	 * @return the eh1
	 */
	public Double getEh1() {
		return eh1;
	}

	/**
	 * @return the eh2
	 */
	public Double getEh2() {
		return eh2;
	}

	/**
	 * @return the az
	 */
	public Double getAz() {
		return az;
	}

	/**
	 * @return the ez
	 */
	public Double getEz() {
		return ez;
	}

	/**
	 * @return the magnitude
	 */
	public double getMagnitude() {
		return magnitude;
	}

	/**
	 * @return the id
	 */
	public double getId() {
		return id;
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
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(double second) {
		this.second = second;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param dep the dep to set
	 */
	public void setDep(double dep) {
		this.dep = dep;
	}

	/**
	 * @param eh1 the eh1 to set
	 */
	public void setEh1(Double eh1) {
		this.eh1 = eh1;
	}

	/**
	 * @param eh2 the eh2 to set
	 */
	public void setEh2(Double eh2) {
		this.eh2 = eh2;
	}

	/**
	 * @param az the az to set
	 */
	public void setAz(Double az) {
		this.az = az;
	}

	/**
	 * @param ez the ez to set
	 */
	public void setEz(Double ez) {
		this.ez = ez;
	}

	/**
	 * @param magnitude the magnitude to set
	 */
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(double id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "[Date: "+day +"/"+month+"/98"+ " Time: "  + hour + ":"
				+ minute + ":" + second + ", Latitude: " + latitude + ", Longitude=" + longitude + ", Depth=" + dep
				+ "+-" + ez + "km, Magnitude=" + magnitude + ", ID=" + id + "]";
	}
	
	

}
