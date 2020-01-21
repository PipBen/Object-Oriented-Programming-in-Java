package exam1516;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Signal {
	
	String  detectorID;
	ArrayList<Double> voltages;
	
	public Signal(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(" ");
		this.detectorID=s.next();
		voltages = new ArrayList<Double>();
		while(s.hasNext()) {
			voltages.add(s.nextDouble());
		}
		s.close();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Signal [detectorID=" + detectorID + ", voltages=" + voltages + "]";
	}

	/**
	 * @return the detectorID
	 */
	public String getDetectorID() {
		return detectorID;
	}

	/**
	 * @return the voltages
	 */
	public ArrayList<Double> getVoltages() {
		return voltages;
	}

	/**
	 * @param detectorID the detectorID to set
	 */
	public void setDetectorID(String detectorID) {
		this.detectorID = detectorID;
	}

	/**
	 * @param voltages the voltages to set
	 */
	public void setVoltages(ArrayList<Double> voltages) {
		this.voltages = voltages;
	}
	
	
	/**
	 * @return the amplitude of the pulse
	 */
	public double getAmplitude() {
		return Collections.max(voltages);
	}
	
	
	/**
	 * @return the arrival time in ns
	 */
	public double getArrivalTime() {
		double amplitude= getAmplitude();
		int index=voltages.indexOf(amplitude);
		return index;
	}
	
	

}
