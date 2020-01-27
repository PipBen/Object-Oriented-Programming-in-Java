package midterm1718;

import java.util.ArrayList;

public class Year {
	
	ArrayList<Month> months;
	int year;
	
	public Year(ArrayList<Month> months) {
		this.months =months;
		this.year=months.get(0).getYear();
	}
	
	public String toString() {
		return Integer.toString(year);
	}

	/**
	 * @return the months
	 */
	public ArrayList<Month> getMonths() {
		return months;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(ArrayList<Month> months) {
		this.months = months;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
