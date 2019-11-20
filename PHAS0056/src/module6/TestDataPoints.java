package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {
	
	//reads the values from the given URL and returns them in the form of an ArrayList
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException{
		//convert URL to bufferedreader
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//new arraylist object for data points
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>();
		String line =br.readLine();
		
		//while there is another line
		while (line != null){
			Scanner s= new Scanner(line);
			//set values for x, y and ey
			double x = s.nextDouble();
			double y =s.nextDouble();
			double ey = s.nextDouble();
			//if there is a label, return a LabelledDataPoint, else return DataPoint
			if (s.hasNext()) {
				String label = s.next();
				LabelledDataPoint p = new LabelledDataPoint(x,y,ey,label);
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
	
	//removes LabelledDataPoint objects
	public static ArrayList<DataPoint> removeLabelled(ArrayList<DataPoint> full){
		ArrayList<DataPoint> part = new ArrayList<DataPoint>();
		for (int i=0;i<full.size();i++) {
			if (full.get(i) instanceof LabelledDataPoint ==false) {
				//Object point = full.get(i);
				part.add(full.get(i));
			}
		}
		return part;
	}

	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> points = new ArrayList<DataPoint> (dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
			
			System.out.println(points);
		}
		catch(IOException e){
			System.out.println("Problem: "+e.getMessage());
		}

	}

}
