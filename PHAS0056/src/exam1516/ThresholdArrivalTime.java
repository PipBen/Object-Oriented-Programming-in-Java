package exam1516;

import java.util.ArrayList;

public class ThresholdArrivalTime implements ArrivalTimeCalculator{
	
	double threshold;
	
	public ThresholdArrivalTime(double threshold) {
		this.threshold=threshold;
	}
	
	public double getArrivalTime(Signal signal) {
		ArrayList<Double> voltages= signal.getVoltages();
		int n=0;
		double voltage=voltages.get(0);
		while(voltage<threshold) {
			n++;
			voltage=voltages.get(n);
		}
		return n;
	}

}
