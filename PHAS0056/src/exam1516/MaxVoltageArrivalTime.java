package exam1516;

public class MaxVoltageArrivalTime implements ArrivalTimeCalculator{
	
	public MaxVoltageArrivalTime() {}
	
	public double getArrivalTime(Signal signal) {
		double amplitude= signal.getAmplitude();
		int index=signal.voltages.indexOf(amplitude);
		return index;
	}

}
