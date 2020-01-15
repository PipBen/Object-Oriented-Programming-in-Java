package midterm1920;


import java.util.Scanner;

public class Constituency {
	
	String ons; //constituency id
	String consName; //constitency name
	String region;
	double electorate;
	
	public Constituency(String line){
		Scanner s= new Scanner(line);
		s.useDelimiter(",");
		this.ons=s.next();
		this.consName=s.next();
		this.region=s.next();
		this.electorate=s.nextDouble();
		s.close();
	}

	public String getONS() {
		return ons;
	}

	public String getConsName() {
		return consName;
	}

	public String getRegion() {
		return region;
	}

	public double getElectorate() {
		return electorate;
	}

	public void setONS(String ons) {
		this.ons = ons;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setElectorate(double electorate) {
		this.electorate = electorate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Constituency [ons=" + ons + ", consName=" + consName + ", region=" + region + ", electorate="
				+ electorate + "]";
	}

}
