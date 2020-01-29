package exam2;

import java.util.ArrayList;

public class TMAXMeasurements implements Measurement{
	
	ArrayList<Double> measurements;
	String name;
	
	public TMAXMeasurements(ArrayList<Double> measurements) {
		this.measurements= measurements;
		
	}
	
	public String name() {
		return "name";
	}

	/**
	 * @return the measurements
	 */
	public ArrayList<Double> getMeasurements() {
		return measurements;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param measurements the measurements to set
	 */
	public void setMeasurements(ArrayList<Double> measurements) {
		this.measurements = measurements;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
