package exam2;

import java.util.ArrayList;

public class PRCPMeasurements implements Measurement{
	
	ArrayList<Double> measurements;
	String name;
	
	public PRCPMeasurements(ArrayList<Double> measurements) {
		this.measurements= measurements;
		
	}
	
	public String name() {
		return "name";
	}

}
