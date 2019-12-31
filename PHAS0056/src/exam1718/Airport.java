package exam1718;

import java.util.Scanner;

public class Airport {
	String code;
	String fullName;
	String timeZone;
	
	public Airport(String line) {
		Scanner s= new Scanner(line);
		s.useDelimiter(", ");
		this.code= s.next();
		this.fullName=s.next();
		this.timeZone=s.next();
		s.close();
	}
	
	public String toString() {
		String  airport="{"+code+", "+fullName+", "+timeZone+"}\n";
		return airport;
	}

	public String getCode() {
		return code;
	}

	public String getFullName() {
		return fullName;
	}

	public String getTimeZone() {
		return timeZone;
	}




}

