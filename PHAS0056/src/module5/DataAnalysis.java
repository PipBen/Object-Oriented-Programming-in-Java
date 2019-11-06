package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {
	
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException{
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>();
		
		Scanner s= new Scanner(br);
		//while there is another line
		while (s.hasNextLine()){
			double x = s.nextDouble();
			double y =s.nextDouble();
			double ey = s.nextDouble();
			DataPoint p =new DataPoint(x,y,ey);
			mypoints.add(p);
			}
		s.close();
		return mypoints;
		
		}
	
	//Theory theory=new Theory( x,n);
	public static double goodnessOfFit(Theory theory,ArrayList<DataPoint> points) {
		
		int i=0;
		double chi_sq_sum=0;
		while(i<249) {
			DataPoint i_point=points.get(i);
			double y_m=i_point.Gety();
			double y_t= theory.return_y(i_point.Getx());
			double ey= i_point.Getey();
			double chi_sq_i=((y_m-y_t)*(y_m-y_t))/(ey*ey);
			chi_sq_sum=chi_sq_sum+chi_sq_i;
			i++;
		}
		return chi_sq_sum;
	}
		
		
	

	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> points =new ArrayList<DataPoint>(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"));
			
			Theory two = new Theory(2);
			System.out.println("When n=2 the value of chi squared is "+goodnessOfFit(two, points));
			
			Theory four = new Theory(4);
			System.out.println("When n=4 the value of chi squared is "+ goodnessOfFit(four, points));
			System.out.println("A fit using n=4 much better describes the data, since the value of Chi squared"
					+ "\nwhen n=4 is much closer to unity than when n=2, which suggests a better fit.");
			
			//DataPoint i_point=points.get(0);
			//double x=i_point.Getx();
			//double y=i_point.Gety();
			//System.out.println(y);
			//Theory theory=new Theory (2);
			//System.out.println(theory.n);
			
			
		}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}
		
				
		

	}

}
