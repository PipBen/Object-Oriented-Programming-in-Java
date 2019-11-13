package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class MidTermExam {

	//import and create an ArrayList for our candidate data
	public static ArrayList<MPData> getMPData(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int n=0;
		//skip first line
		br.readLine();
		ArrayList<MPData> mpdata = new ArrayList<MPData>();
		while (n<652) {
			//new scanner for each line
			Scanner s= new Scanner(br.readLine());
			//comma delimiter for csv
			s.useDelimiter(","); 
			
			String ons=s.next();
			String pano=s.next();
			String cons=s.next();
			String sur=s.next();
			String first=s.next();
			String party=s.next();
			String pid=s.next(); 
			String votes=s.next();
			//new MPData object
			MPData mp= new MPData(ons, pano, cons, sur, first, party,  pid,  votes);
			mpdata.add(mp);
			s.close();
			n++;
			}
		br.close();
		return mpdata;
	}

	//import and create an array for our electorate data
	public static ArrayList<ElectorateData> getElecData(String fileName) throws IOException{
	
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();
		ArrayList<ElectorateData> elecdata = new ArrayList<ElectorateData>();
		
		int n=0;
	
		while (n<652) {
			Scanner s= new Scanner(br.readLine());
			s.useDelimiter(","); 
			String consid=s.next();
			String cons=s.next();
			String county=s.next();
			String elec=s.next();
			
			ElectorateData ed= new ElectorateData(consid,cons,county,elec);
			elecdata.add(ed);
			s.close();
			n++;
			}
		br.close();
		return elecdata;
	
	}
	


	public static void main(String[] args) {
		
		try{
			ArrayList<MPData> mpdata =new ArrayList<MPData>(getMPData("N:\\Eclipse\\results.csv"));
			//electorate data not working for some reason
			//ArrayList<ElectorateData> elecdata =new ArrayList<ElectorateData>(getElecData("N:\\Eclipse\\constituencies.csv"));
			System.out.println(mpdata);
			System.out.println( '\n');
			System.out.println(mpdata.get(60));
			}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}

	}

}
