package exam2;

import java.util.ArrayList;

public class SNWDMeasurements implements Measurement{
	
	ArrayList<Double> measurements;
	String name;
	
	public SNWDMeasurements(ArrayList<Double> measurements) {
		this.measurements= measurements;
		
	}
	
	public String name() {
		return "name";
	}
}
