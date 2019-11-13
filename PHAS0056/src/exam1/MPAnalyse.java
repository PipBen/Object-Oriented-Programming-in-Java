package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MPAnalyse {

	
	
	public static ArrayList<MPData> getData(String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		Scanner s= new Scanner(br.readLine());
		s.useDelimiter(", *"); 
		s.nextLine();
		ArrayList<MPData> mpdata = new ArrayList<MPData>();
		//MPData mp = new MPData();
		while (s.hasNextLine()){
			
			//set values for x, y and ey
			String ons=s.next();
			String pano=s.next();
			String cons=s.next();
			String sur=s.next();
			String first=s.next();
			String party=s.next();
			String pid=s.next(); 
			String votes=s.next();
			MPData mp= new MPData(ons, pano, cons, sur, first, party,  pid,  votes);
			mpdata.add(mp);
			}
		
		s.close();
		br.close();
		return mpdata;
		
				
	}
	

}
