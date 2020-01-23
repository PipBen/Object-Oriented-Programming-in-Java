package exam1516;

public class DetectorThreshold extends Detector {

	public DetectorThreshold(String line) {
		super(line);
	}

	@Override
	public double getMeanArrivalTime() {
		signals = getSignals();
		double totalArrivalTime = 0;
		for (int n = 0; n < signals.size(); n++) {
			Signal signal = signals.get(n);
			ThresholdArrivalTime oneVolt = new ThresholdArrivalTime(1);
			totalArrivalTime = totalArrivalTime + oneVolt.getArrivalTime(signal);
		}
		return totalArrivalTime / signals.size();
	}

	@Override
	public double getParticleSpeed() {
		double meanArrivalTime = getMeanArrivalTime();
		return distance / meanArrivalTime;

	}

}
