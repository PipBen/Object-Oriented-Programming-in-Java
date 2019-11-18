package module6;

import java.util.Collection;

public class DataAnalysis implements GoodnessOfFitCalculator{
	//GoodnessOfFitCalculator gofCalculator= new GoodnessOfFitCalculator();
	
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
		//PowerLawTheory n1= new PowerLawTheory(2);
		//System.out.println(n1);
		//QuadraticTheory n2= new QuadraticTheory(1,2,3);
		//System.out.println(n2);
	}

}
