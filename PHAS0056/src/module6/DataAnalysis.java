package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {
	//method from notes to determine the theory in best agreement with a set of datapoint objects
	private static Theory bestTheory(Collection<DataPoint> data,
	            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
	    Theory bestTheory = null;
	    for (Theory theory : theories) {
	    	double gof = gofCalculator.goodnessOfFit(data, theory);
	        if (first) {
	        	bestTheory = theory;
	            bestGoodnessOfFit = gof;
	            first = false;
	        } else if (gof < bestGoodnessOfFit) {
	            bestTheory = theory;
	            bestGoodnessOfFit = gof;
	        }	
	    }
	    return bestTheory;
	}
	
	
	
	public static void main(String[] args) {
		try{
			//new GoodnessOfFitCalculator using the ChiSquared method
			GoodnessOfFitCalculator gofCalculator= new ChiSquared();
			//arraylist including DataPoint and LabelledDataPoint objects
			ArrayList<DataPoint> allData = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			//remove estimated and calculated values from data
			ArrayList<DataPoint> data = new ArrayList<DataPoint>(TestDataPoints.removeLabelled(allData));
			
//			System.out.println(data);
//			System.out.println(allData);
			//collec.removeAll(ArrayList<LabelledDataPoint> a);
			//System.out.println(collec);
			Theory pow2 = new PowerLawTheory(2);
			Theory pow205 = new PowerLawTheory(2.05);
			Theory quad210 = new QuadraticTheory(2,1,0);
			ArrayList<Theory> theories = new ArrayList<Theory>();
			theories.add(pow2);
			theories.add(pow205);
			theories.add(quad210);
			System.out.println(bestTheory(data,theories,gofCalculator));
		}
		catch(IOException e){
			System.out.println("Problem: "+e.getMessage());
		}
		//System.out.println(n1);
		//QuadraticTheory n2= new QuadraticTheory(1,2,3);
		//System.out.println(n2);
	}

}
