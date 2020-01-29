package exam2;

import java.util.ArrayList;

public class TMINMeasurements implements Measurement{
	
	ArrayList<Double> measurements;
	String name;
	
	public TMINMeasurements(ArrayList<Double> measurements) {
		this.measurements= measurements;
		
	}
	
	public String name() {
		return "name";
	}
	

}
