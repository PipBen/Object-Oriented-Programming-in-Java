package exam1516;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zcappbe
 *
 */
public class Detector {
	
	String detectorID;
	double distance;
	SignalStore signalStore;
	ArrayList<Signal> signals;
	
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
	
	/**
	 * @return ArrayList of signals corresponding to this detector
	 */
	public ArrayList<Signal> getSignals(){
		this.signals= new ArrayList<Signal>();
		for(int n=0; n<signalStore.getSignals().size();n++) {
			Signal signal = signalStore.getSignals().get(n);
			if(detectorID.equals(signal.getDetectorID())) {
				signals.add(signal);
			}
		}
		return signals;
	}
	
	/**
	 * @return the number of signals corresponding to this detector
	 */
	public double getNoSignals() {
		signals= getSignals();
		return signals.size();
	}
	
	/**
	 * @return the mean of the amplitudes of the signals corresponding to this detector
	 */
	public double getMeanAmplitude() {
		double totalAmplitude=0;
		double noSignals= getNoSignals();
		for(int n=0;n<signalStore.getSignals().size();n++) {
			Signal signal = signalStore.getSignals().get(n);
			totalAmplitude=totalAmplitude+signal.getAmplitude();
		}
		return totalAmplitude/noSignals;
	}
	
	public double getMeanArrivalTime() {
		signals=getSignals();
		double totalArrivalTime=0;
		for(int n=0;n<signals.size();n++) {
			Signal signal = signals.get(n);
			totalArrivalTime= totalArrivalTime+signal.getArrivalTime();
			
		}
		return totalArrivalTime/signals.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[detectorID= " + detectorID + ", Mean Amplitude: "+ getMeanAmplitude()+"V, "+ "Mean Arrival Time: "+getMeanArrivalTime()+"ns, Particle Speed: "+getParticleSpeed()+"Gs]\n";
	}

	/**
	 * @return the signalStore
	 */
	public SignalStore getSignalStore() {
		return signalStore;
	}

	/**
	 * @param signalStore the signalStore to set
	 */
	public void setSignalStore(SignalStore signalStore) {
		this.signalStore = signalStore;
	}
	
	/**
	 * @param signal the signal to find the speed of
	 * @return the speed of the particles
	 * @throws Exception if signal does not correspond to this detector
	 */
	public double getParticleSpeed(){
			double meanArrivalTime= getMeanArrivalTime();
			return distance/meanArrivalTime;

	}
	
//	public double getArrivalTimeDifference

}
