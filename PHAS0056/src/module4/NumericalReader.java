package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	//define private variables
	private double minValue;
	private double maxValue;
	private int nValues;
	private double sumOfValues;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter pw;
	
	//define public variables
	public BufferedReader br;
	public BufferedReader reader;
	public String line;
	public static String saveDir;
	public  String saveFile;
	public  String dataFile;
	public static String userHome = System.getProperty("user.home");
	//double next_double;
	
	//returns user keyboard input
	public static String getStringFromKeyboard() throws Exception, IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("What directory should the file be stored in?");
		
		
		String s =br.readLine();
		System.out.println("You typed: "+s);
		//return default home directory if no user input
		if (s == null) {
			System.out.println("Default directory: "+userHome);
			return userHome;
		}
		else {
			return s;
		}
	
	}
	
	//takes the name of a URL and returns a BufferedReader object, reads contents of URL one line at a time
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	//creates a file called dataFile and initialises variables
	public void analysisStart(String dataFile) throws IOException{
		fw = new FileWriter(dataFile);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		
		//make minValue/maxValue suitably large/small to compare our data to
		minValue=1000000;
		maxValue=-1000000;
		nValues=0;
		sumOfValues=0;
	}
	
	//take each line of the file in turn & analyse, ignoring blank lines and those starting with letters
	public void analyseData(String line) throws IOException{
		Scanner s= new Scanner(line);
		//while there is either another line or another token
		while (s.hasNextLine() || s.hasNext()){
			//if line is empty or starts with a letter, proceed to the next line
			if (line.isEmpty() || Character.isLetter(line.charAt(0)) ) {
				s.nextLine();
			}
			//analyse the data if not
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
		s.close();
	}
	
	//finish our analysis & print values
	public void analysisEnd() {
		System.out.println("The minimum value is "+minValue);
		System.out.println("The maximum value is "+maxValue);
		System.out.println("The average value is "+sumOfValues/nValues);
		System.out.println("Total number of values read is "+nValues);
		pw.close();
	}
	
	
	public static void main(String[] args) {
		
		//user to specify directory
		try {
			 saveDir= NumericalReader.getStringFromKeyboard();
			 }
		catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
			 }
		catch (Exception e) {
			System.out.println(e);
		}
		
		//new instance of NumericalReader class
		NumericalReader nr = new NumericalReader();
		nr.saveFile = (saveDir + File.separator + "numbers1.txt");
		
		//return BufferedReader object from our URL
		try{
			nr.reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			}
		catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}
		
		//initialise variables and create file
		try{
			nr.analysisStart(nr.saveFile);
		}
		catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		
		//analyse our data
		try {
		while ((nr.line = nr.reader.readLine()) != null) {
		    nr.analyseData(nr.line); 
			}
		}
		catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		//end analysis
		nr.analysisEnd();
		
		
		//new instance of NumericalReader class
		NumericalReader nr2 = new NumericalReader();
		nr2.saveFile = (saveDir + File.separator + "numbers2.txt");
		
		//return BufferedReader object from our URL
		try{
			nr2.reader = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			}
		catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
			 }
		
		//initialise variables and create file
		try{
			nr2.analysisStart(nr2.saveFile);
		}
		catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		
		//analyse our data
		try {
		while ((nr2.line = nr2.reader.readLine()) != null) {
		    nr2.analyseData(nr2.line); // analyze lines, check for comments etc.
			}
		}
		catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		//end analysis
		nr2.analysisEnd();
	}
}
