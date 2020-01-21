package exam1516;

import java.util.Scanner;

public class Detector {
	
	String detectorID;
	double distance;
	
	public Detector(String line) {
		Scanner s = new Scanner(line);
		s.useDelimiter(" ");
		this.detectorID=s.next();
		this.distance=s.nextDouble();
		s.close();
	}

	/**
	 * @return the detectorID
	 */
	public String getDetectorID() {
		return detectorID;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param detectorID the detectorID to set
	 */
	public void setDetectorID(String detectorID) {
		this.detectorID = detectorID;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
