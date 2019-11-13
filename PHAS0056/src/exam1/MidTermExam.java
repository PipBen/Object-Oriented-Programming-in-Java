package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.HashMap;

public class MidTermExam {
	static double electorate=0;
	static double total_voters=0;
	static ArrayList<Integer> voters_array= new ArrayList<Integer>();
	static ArrayList<Integer> electorate_array=new ArrayList<Integer>();
	static ArrayList<String> ons_array= new ArrayList<String>();
	static HashMap<String,Integer> ONSElectorateHash =new HashMap<String,Integer>();
	//static Double [] votes_array;

	//import and create an ArrayList for our candidate data
	public static BufferedReader getMPbr(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
		
	}
	
	public static ArrayList<MPData> getMPArrayList(BufferedReader br)throws IOException{
		br.readLine();
		ArrayList<MPData> mpdata = new ArrayList<MPData>();
		//int t_votes=0;
		String line = br.readLine();
		
		while (line != null) {
			//new scanner for each line
			Scanner s= new Scanner(line);
			//comma delimiter for csv
			s.useDelimiter(","); 
			
			String ons=s.next();
			ons_array.add(ons);
			String pano=s.next();
			String cons=s.next();
			String sur=s.next();
			String first=s.next();
			String party=s.next();
			String pid=s.next(); 
			String votes=s.next();
			voters_array.add(Integer.valueOf(votes));
			total_voters=total_voters+Integer.valueOf(votes);
			//new MPData object
			MPData mp= new MPData(ons, pano, cons, sur, first, party,  pid,  votes);
			mpdata.add(mp);
			s.close();
			//count++;
			line =br.readLine();
			
			}
		return mpdata;
	}
	
	//static HashMap<String,Integer> ONSElectorateHash(){
	//	int i=0;
	//	while i<
	//}
	
	

	
	//import and create an array for our electorate data
	public static ArrayList<ElectorateData> getElecData(String fileName) throws IOException{
	
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();
		ArrayList<ElectorateData> elecdata = new ArrayList<ElectorateData>();
		//int electorate=0; 
		//int n=0;
		String line = br.readLine();
		while (line!= null) {
			Scanner s= new Scanner(line);
			s.useDelimiter(","); 
			String consid=s.next();
			String cons=s.next();
			String county=s.next();
			String elec=s.next();
			electorate_array.add(Integer.valueOf(elec));
			electorate=electorate+Integer.valueOf(elec);
			ElectorateData ed= new ElectorateData(consid,cons,county,elec);
			elecdata.add(ed);
			s.close();
			//n++;
			line =br.readLine();
			}
		//br.close();
		return elecdata;
	
	}
	
	

	public static void main(String[] args) {
		
		try{
			BufferedReader mpbr =new BufferedReader (getMPbr("N:\\Eclipse\\results.csv"));
			ArrayList<MPData> mpdata= new ArrayList<MPData>( getMPArrayList(mpbr));
			
			//BufferedReader elecbr= new BufferedReader(getMPbr("N:\\Eclipse\\constituencies.csv"));
			ArrayList<ElectorateData> elecdata =new ArrayList<ElectorateData>(getElecData("N:\\Eclipse\\constituencies.csv"));
			
			//HashMap<String,Integer> ONSElectorateHash =new HashMap<>
			
		
			
			//System.out.println( '\n');
			//System.out.println(elecdata.get(0));
			
			System.out.println(ons_array);	
			System.out.println(electorate_array);
			System.out.println(electorate);
			double turnout= total_voters / electorate;
			System.out.println("turnout= "+turnout);
			}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}

	}

}
