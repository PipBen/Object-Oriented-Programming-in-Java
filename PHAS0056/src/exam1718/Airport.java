package exam1718;

import java.util.Scanner;

/** Class containing information about an airport
 * 
 * @author pipbe
 *
 */
public class Airport {
	String code;
	String fullName;
	String timeZone;
	
	/**Constructor takes a String obtained from a BufferedReader object and scans to find required Airport information
	 * 
	 * @param line
	 */
	public Airport(String line) {
		Scanner s= new Scanner(line);
		s.useDelimiter(", ");
		this.code= s.next();
		this.fullName=s.next();
		this.timeZone=s.next();
		s.close();
	}
	/** Override toString method
	 * @return airport A String
	 */
	public String toString() {
		String  airport="{"+code+", "+fullName+", "+timeZone+"}\n";
		return airport;
	}
	/**
	 * Airport Code getter
	 * @return String code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * full Name getter
	 * @return String fullName
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * time zone getter
	 * @return String timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}




}

