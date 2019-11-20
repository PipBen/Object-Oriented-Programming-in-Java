package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import module5.DataPoint;

public class TestDataPoints {
	
	//reads the values from the given URL and returns them in the form of an ArrayList
	public static ArrayList<Object> dataFromURL(String url) throws IOException{
		//convert URL to bufferedreader
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//new arraylist object for data points
		ArrayList<Object> mypoints = new ArrayList<Object>();
		String line =br.readLine();
		
		//while there is another line
		while (line != null){
			Scanner s= new Scanner(line);
			//set values for x, y and ey
			double x = s.nextDouble();
			double y =s.nextDouble();
			double ey = s.nextDouble();
			if (s.hasNext()) {
				LabelledDataPoint p = new LabelledDataPoint(x,y,ey);
				mypoints.add(p);
			}
			else {
				DataPoint p =new DataPoint(x,y,ey);
				mypoints.add(p);
			}
			s.close();
			line= br.readLine();
		}
		return mypoints;
	}

	public static void main(String[] args) {
		try {
			ArrayList<Object> points = new ArrayList<Object> (dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
			System.out.println(points);
			DataPoint a= new DataPoint(1,2,3);
			System.out.println(a);
		
		}
		catch(IOException e){
			System.out.println("Problem: "+e.getMessage());
		}

	}

}
