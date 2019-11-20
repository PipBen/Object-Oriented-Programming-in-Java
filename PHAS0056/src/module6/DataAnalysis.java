package module6;

import java.io.IOException;
import java.util.ArrayList;
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
		try{
			Collection<Object> collec = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			Theory pow2 = new PowerLawTheory(2);
			Theory pow205 = new PowerLawTheory(2.05);
			Theory quad210 = new QuadraticTheory(2,1,0);
			ArrayList<Theory> theories = new ArrayList<Theory>();
			theories.add(pow2);
			theories.add(pow205);
			theories.add(quad210);
		}
		catch(IOException e){
			System.out.println("Problem: "+e.getMessage());
		}
		//System.out.println(n1);
		//QuadraticTheory n2= new QuadraticTheory(1,2,3);
		//System.out.println(n2);
	}

}
