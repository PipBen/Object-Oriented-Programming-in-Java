package exam1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DetectorStore {
	
	public ArrayList<Detector> detectors;
	
	public DetectorStore(String urlName) throws Exception{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.detectors= new ArrayList<Detector>();
		while (line!= null) {
			Detector detector = new Detector(line);
			detectors.add(detector);
			line=br.readLine();
		}
	}

}
