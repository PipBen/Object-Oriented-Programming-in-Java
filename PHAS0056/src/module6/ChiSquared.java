package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator{
	//implement method from GoodnessOfFitCalculator to calculate chi squared
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		int i=0;
		double chi_sq_sum=0;
		ArrayList<DataPoint> data_array = new ArrayList<>(data);
		//int size= data.size();
		//compare all experimental values to theoretical prediction
		while (i < data.size()) {
			DataPoint i_point=data_array.get(i);
			//measured y
			double y_m=i_point.Gety();
			//theoretical y
			double y_t= theory.y(i_point.Getx());
			double ey= i_point.Getey();
			//calculate chi squared values and sum
			double chi_sq_i=((y_m-y_t)*(y_m-y_t))/(ey*ey);
			chi_sq_sum=chi_sq_sum+chi_sq_i;
			i++;
		}
		return chi_sq_sum;
	}
	
//	public static void main(String[] args) {
//		try{
//			GoodnessOfFitCalculator gofCalculator= new ChiSquared();
//			Theory pow2 = new PowerLawTheory(2);
//			Theory pow205 = new PowerLawTheory(2.05);
//			Theory quad210 = new QuadraticTheory(2,1,0);
//			ArrayList<DataPoint> points = new ArrayList<DataPoint> (TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
//			System.out.println(gofCalculator.goodnessOfFit(points,pow2));
//			System.out.println(gofCalculator.goodnessOfFit(points,pow205));
//			System.out.println(gofCalculator.goodnessOfFit(points,quad210));
//			//Theory n1 = new Theory(PowerLawTheory(1)); 
//			//goodnessOfFit(points,n1);
//		}
//		catch(IOException e) {
//			System.out.println("Problem: "+e.getMessage());
//		}
//	}
}

