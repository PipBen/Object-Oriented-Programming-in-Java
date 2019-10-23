package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumOfValues;
	private String mainfile;
	//double next_double;
	
	//returns user keyboard input
	public static String getStringFromKeyboard() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type something!");
		
		
		String s =br.readLine();
		System.out.println("You typed: "+s);
		return s;
		}
	
	//takes the name of a URL and returns a BufferedReader object
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
		}
	
	//creates a file called dataFile and initializes variables
	public void analysisStart(String dataFile) throws IOException{
		FileWriter fw = new FileWriter(dataFile);
		//BufferedWriter bw = new BufferedWriter(fw);
		//PrintWriter pw = new PrintWriter(bw);
		fw.close();
		minValue=10000;
		maxValue=-1000000;
		nValues=0;
		sumOfValues=0;
		mainfile=dataFile;
		
	}
	
	
	public void analyseData(String line) throws IOException{
		Scanner s= new Scanner(line);
		
		
		FileWriter fw = new FileWriter(mainfile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		//double total=0;
		while (s.hasNextLine() || s.hasNext()){
			if (line.isEmpty() || ) {
				s.nextLine();
			}
			else {
				double next_double=s.nextDouble();
				System.out.println(next_double);
				pw.println(next_double);
				
				//update min value
				if(next_double<minValue) {
					minValue=next_double;
				}
				//update max value
				if(next_double>maxValue) {
					maxValue=next_double;
				}
				
				//update number of values and sum of values
				nValues=nValues+1;
				sumOfValues=sumOfValues+next_double;
				
			}
			
		}
		
		pw.close();
		s.close();
	}
	
	

	
	
	public static void main(String[] args) {
		try {
			 getStringFromKeyboard();
			 //System.out.println("You typed: "+s);
			 }
			 catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
			 }
		NumericalReader nm = new NumericalReader();
		
		try{
			nm.analyseData("10  5  6");
		}
		catch(IOException e) {
			
		}
	}

}
