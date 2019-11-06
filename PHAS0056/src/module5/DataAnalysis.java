package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {
	
	//reads the values from the given URL and returns them in the form of an ArrayList
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException{
		//convert URL to bufferedreader
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//new arraylist object for data points
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>();
		Scanner s= new Scanner(br);
		//while there is another line
		while (s.hasNextLine()){
			//set values for x, y and ey
			double x = s.nextDouble();
			double y =s.nextDouble();
			double ey = s.nextDouble();
			DataPoint p =new DataPoint(x,y,ey);
			mypoints.add(p);
			}
		s.close();
		return mypoints;
		}
	
	//takes as arguments a Theory object and an ArrayList of DataPoint objects, and returns the calculated value of chi squared
	public static double goodnessOfFit(Theory theory,ArrayList<DataPoint> points) {
		int i=0;
		double chi_sq_sum=0;
		//compare all experimental values to theoretical prediction
		while(i<249) {
			DataPoint i_point=points.get(i);
			//measured y
			double y_m=i_point.Gety();
			//theoretical y
			double y_t= theory.return_y(i_point.Getx());
			double ey= i_point.Getey();
			//calculate chi squared values and sum
			double chi_sq_i=((y_m-y_t)*(y_m-y_t))/(ey*ey);
			chi_sq_sum=chi_sq_sum+chi_sq_i;
			i++;
		}
		return chi_sq_sum;
	}
		
	public static void main(String[] args) {
		try {
			//create ArrayList of DataPoint objects
			ArrayList<DataPoint> points =new ArrayList<DataPoint>(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"));
			
			//x^2 theoretical prediction
			Theory two = new Theory(2);
			System.out.println("When n=2 the value of chi squared is "+goodnessOfFit(two, points));
			
			//x^4 theoretical prediction
			Theory four = new Theory(4);
			System.out.println("When n=4 the value of chi squared is "+ goodnessOfFit(four, points));
			System.out.println("A fit using n=4 much better describes the data, since the value of Chi squared"
					+ "\nwhen n=4 is much closer to unity than when n=2, which suggests a better fit.");	
		}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}
	}

}
