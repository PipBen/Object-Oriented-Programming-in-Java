package exam1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SignalStore {

	public ArrayList<Signal> signals;

	public SignalStore(String urlName) throws Exception {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		this.signals = new ArrayList<Signal>();
		while (line != null) {
			Signal signal = new Signal(line);
			signals.add(signal);
			line = br.readLine();
		}
	}

	/**
	 * @return the signals
	 */
	public ArrayList<Signal> getSignals() {
		return signals;
	}

	/**
	 * @param signals the signals to set
	 */
	public void setSignals(ArrayList<Signal> signals) {
		this.signals = signals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + signals + "]\n";
	}

	/**
	 * @return total number of pulses
	 */
	public double getTotalPulses() {
		return signals.size();
	}

}
