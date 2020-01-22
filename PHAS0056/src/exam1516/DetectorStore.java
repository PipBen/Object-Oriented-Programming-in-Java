package exam1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DetectorStore {
	
	public ArrayList<Detector> detectors;
	public ArrayList<DetectorThreshold> detectorThresholds;
	public Detector maxDiffDetector;
	
	public DetectorStore(String urlName, SignalStore signalStore, ArrivalTimeCalculator arrivalTimeCalculator) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.detectors= new ArrayList<Detector>();
		this.detectorThresholds= new ArrayList<DetectorThreshold>();
		while (line!= null) {
			if(arrivalTimeCalculator instanceof MaxVoltageArrivalTime) {
				Detector detector = new Detector(line);
				detector.setSignalStore(signalStore);
				detectors.add(detector);
			}
			if(arrivalTimeCalculator instanceof ThresholdArrivalTime) {
				DetectorThreshold detector = new DetectorThreshold(line);
				detector.setSignalStore(signalStore);
				detectorThresholds.add(detector);
			}
			line=br.readLine();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(detectors.isEmpty()) {
			return detectorThresholds.toString();
		}
		else {
			return detectors.toString();
		}
	}

	/**
	 * @return the detectors
	 */
	public ArrayList<Detector> getDetectors() {
		return detectors;
	}

	/**
	 * @return the detectorThresholds
	 */
	public ArrayList<DetectorThreshold> getDetectorThresholds() {
		return detectorThresholds;
	}

	/**
	 * @param detectors the detectors to set
	 */
	public void setDetectors(ArrayList<Detector> detectors) {
		this.detectors = detectors;
	}

	/**
	 * @param detectorThresholds the detectorThresholds to set
	 */
	public void setDetectorThresholds(ArrayList<DetectorThreshold> detectorThresholds) {
		this.detectorThresholds = detectorThresholds;
	}
	
	public Detector getMaxDiffDetector() {
		double maxDifference=0;
		for(int n=0; n<detectors.size();n++) {
			double maxAmpSpeed=detectors.get(n).getParticleSpeed();
			double thresholdSpeed =detectorThresholds.get(n).getParticleSpeed();
			double difference =Math.abs(maxAmpSpeed-thresholdSpeed);
			if (difference>maxDifference) {
				maxDifference=difference;
				maxDiffDetector=detectors.get(n);
			}
		}
		return maxDiffDetector;
	}	

}
