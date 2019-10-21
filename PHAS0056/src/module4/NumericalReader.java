package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	
	public static String getStringFromKeyboard() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type something!");
		
		
		String s =br.readLine();
		System.out.println("You typed: "+s);
		return s;
		}
	
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
		}
	
	private void analysisStart(String dataFile) throws IOException{
		FileWriter fw = new FileWriter(dataFile);
		double minValue;
		double maxValue;
		double nValues;
		double sumOfValues;
		
	}
	
	public void analyseData(String line) throws IOException{
		
	}
	
	

	
	
	public static void main(String[] args) {
		try {
			 getStringFromKeyboard();
			 //System.out.println("You typed: "+s);
			 }
			 catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
			 }
	}

}
