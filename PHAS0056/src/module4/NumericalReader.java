package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumOfValues;
	//private String mainfile;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter pw;
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
		fw = new FileWriter(dataFile);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		//BufferedWriter bw = new BufferedWriter(fw);
		//PrintWriter pw = new PrintWriter(bw);
		//fw.close();
		minValue=10000;
		maxValue=-1000000;
		nValues=0;
		sumOfValues=0;
		//mainfile=dataFile;
		
	}
	
	
	public void analyseData(String line) throws IOException{
		Scanner s= new Scanner(line);
		
		
		//FileWriter fw = new FileWriter(mainfile);
		
		//double total=0;
		while (s.hasNextLine() || s.hasNext()){
			if (line.isEmpty() || Character.isLetter(line.charAt(0)) ) {
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
		//pw.close();
		s.close();
	}
	
	//finish our analysis
	public void analysisEnd() {
		System.out.println("The minimum value is "+minValue);
		System.out.println("The maximum value is "+maxValue);
		System.out.println("The average value is "+sumOfValues/nValues);
		System.out.println("Total number of values read is "+nValues);
		pw.close();
		//fw.close();
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
