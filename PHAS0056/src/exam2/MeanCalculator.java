package exam2;

import java.util.ArrayList;
import java.util.Collection;

public class MeanCalculator implements StatisticCalculator{
	
	
	
	/** implementation of StatisticCalculator which calculates the mean of an arraylist of double values
	 * 
	 */
	public MeanCalculator(){
		
	}
	
	public double calculate(ArrayList<Double> measurements) {
		double measurementTotal=0;

		for(int n=0; n<measurements.size();n++) {
			double measurement= measurements.get(n);
			measurementTotal=measurementTotal+measurement;
		}
		return measurementTotal/measurements.size();
		
	}

}
