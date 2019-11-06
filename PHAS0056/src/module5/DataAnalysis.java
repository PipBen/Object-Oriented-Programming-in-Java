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
		
		
	

	public static void main(String[] args) {
		try {
			System.out.println(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"));
		}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}
		
				
		

	}

}
