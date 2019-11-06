package module5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {
	
	//creates first hashmap for code & mass using data from a URL
	public static HashMap<Integer,Double> hashMapFromURL1(String url) throws IOException{
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//define hashmap to add integer code numbers and double mas values to
		HashMap<Integer, Double> hashmap = new HashMap<Integer, Double>();
		Scanner s= new Scanner(br);
		//while there is another line
		while (s.hasNextLine()){
			hashmap.put(s.nextInt(),s.nextDouble());
			s.nextLine();
			}
		s.close();
		return hashmap;
		}
	
	//method to create first hashmap for code & location using data from a URL
	public static HashMap<Integer,String> hashMapFromURL2(String url) throws IOException{
		//create bufferedreader to scan
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//new hashmap to add to
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		Scanner s= new Scanner(br);
		//while there is another line
		while (s.hasNextLine()){
			String location= s.next();
			//add integer code number key and string location value to hashmap
			hashmap.put(s.nextInt(),location);
			s.nextLine();
			}
		s.close();
		return hashmap;
		}
	
	//method to find the code number from a given mass value
	public static Integer getKeyFromValue(HashMap<Integer,Double> hm, Double value) {
	    for (Integer i : hm.keySet()) {
	      if (hm.get(i).equals(value)) {
	        return i;
	      }
	    }
	    return null;
	  }
	
	public static void main(String[] args) {
		try{
			//create our two hashmaps
			HashMap<Integer,Double> code_mass= new HashMap<Integer,Double> (hashMapFromURL1("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt"));
			HashMap<Integer,String> code_location= new HashMap<Integer,String> (hashMapFromURL2("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt"));
		
			System.out.println("The maximum value of mass was "+ Collections.max(code_mass.values()));
			System.out.println("The minimum value of mass was "+Collections.min(code_mass.values()));
			
			Object maxkey = getKeyFromValue( code_mass,Collections.max(code_mass.values()) );
			System.out.println("The code number of the maximum mass value was "+maxkey);	
			
			Object minkey = getKeyFromValue( code_mass,Collections.min(code_mass.values()) );
			System.out.println("The code number of the maximum mass value was "+minkey);	
			
			String maxloc = code_location.get(maxkey);
			System.out.println("The location of the maximum mass value was "+ maxloc);
			
			String minloc = code_location.get(minkey);
			System.out.println("The location of the maximum mass value was "+ minloc);
		}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}
	}

}
