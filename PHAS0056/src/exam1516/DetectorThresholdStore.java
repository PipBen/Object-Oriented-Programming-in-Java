package exam1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DetectorThresholdStore {

	public ArrayList<DetectorThreshold> detectors;
	
	
	public DetectorThresholdStore(String urlName, SignalStore signalStore) throws Exception {
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.detectors= new ArrayList<DetectorThreshold>();
		while (line!= null) {
			DetectorThreshold detector = new DetectorThreshold(line);
			detector.setSignalStore(signalStore);
			detectors.add(detector);
			line=br.readLine();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  detectors.toString();
	}
}


