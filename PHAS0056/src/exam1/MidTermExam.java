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
	static double totalVoters=0;
	static ArrayList<Integer> votersArray= new ArrayList<Integer>();
	static ArrayList<Integer> electorateArray=new ArrayList<Integer>();
	static ArrayList<String> onsArray= new ArrayList<String>();
	static ArrayList<MPData> winners= new ArrayList<MPData>();
	//private static ArrayList<MPData> onsCandidate= new ArrayList<MPData>();
	static HashMap<String,Integer> ONSVotersHash =new HashMap<String,Integer>();
	
	static HashMap<String,ArrayList<MPData>> ONSCandidateHash =new HashMap<String,ArrayList<MPData>>();
	static int noReturn=0;
	static Integer totalVote=0;
	//static String onsCompare="E14000530";
	static int maxVotes=0; //find candidate with most votes
	//public static int winnerVotes=0;
	static MPData mostVotesMP;
	static MPData winner;
	//public static MPData winner;
	//static int panoComp =7;
	static int index=0;
	static String ons1;
	//static Double [] votes_array;

	public static BufferedReader getBR(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	
	
	public static HashMap<String,Integer> getONSVotersHash(BufferedReader mpbr)throws IOException{
		mpbr.readLine();
		String line = mpbr.readLine();
		while (line != null) {
			//new scanner for each line
			Scanner s= new Scanner(line);
			//comma delimiter for csv
			s.useDelimiter(","); 
			
			String ons=s.next();
			if (ONSVotersHash.containsKey(ons)==false) {
				totalVote=0;
				ONSVotersHash.put(ons,totalVote);
			}
			String pano=s.next();
			String cons=s.next();
			String sur=s.next();
			String first=s.next();
			String party=s.next();
			String pid=s.next(); 
			String votes=s.next();
			
			//HashMap of ONS and total number of voters
			totalVote=totalVote+Integer.valueOf(votes);
			ONSVotersHash.put(ons,totalVote);
			s.close();
			line =mpbr.readLine();
			}
		mpbr.close();
		return ONSVotersHash;
	}
	
	public static HashMap<String,ArrayList<MPData>> getONSCandidateHash(BufferedReader mpbr) throws IOException{
		//String ons1;
		mpbr.readLine();
		String line = mpbr.readLine();
		//ArrayList<MPData> onsCandidate = new ArrayList<MPData>();
		while (line != null) {
			//new scanner for each line
			Scanner s= new Scanner(line);
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
			MPData mp= new MPData(ons, pano, cons, sur, first, party, pid, votes);
			ArrayList<MPData> onsCandidate = new ArrayList<MPData>();
			if (ONSCandidateHash.isEmpty()) {
				ons1=ons;
				//onsCandidate.add(mp);
				
				onsCandidate.add(mp);
				ONSCandidateHash.put(ons1,null);
				
			}
			
			if (ons == ons1) {
				onsCandidate.add(mp);
				
				//ONSCandidateHash.put(ons,mp);
			}
			else {
				
				ONSCandidateHash.put(ons1,onsCandidate);
				onsCandidate.clear();
				
				
				onsCandidate.add(mp);
				ons1 =ons;
				//ons1 =ons;
				
				
			}
			s.close();
			line =mpbr.readLine();
		}
		mpbr.close();
		return ONSCandidateHash;
	}
	
	
	
	public static ArrayList<MPData> getMPArrayList(BufferedReader mpbr)throws IOException{
		
		mpbr.readLine();
		ArrayList<MPData> mpdata = new ArrayList<MPData>();
		//int t_votes=0;
		String line = mpbr.readLine();
		//int maxVotes=0;
		while (line != null) {
			//new scanner for each line
			Scanner s= new Scanner(line);
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
			totalVoters=totalVoters+Integer.valueOf(votes);
			//determine if candidate is a winner, if so add them to a winners list
//			if (Integer.valueOf(pano)==panoComp) {
//				if(Integer.valueOf(votes)>winnerVotes) {
//					MPData winner =new MPData(ons, pano, cons, sur, first, party, pid, votes);
//				
//					winnerVotes=Integer.valueOf(votes);
//					winners.set(index,winner);
//				}
//			}
//			else {
//				index++;
//				panoComp=Integer.valueOf(pano);
//				MPData winner =new MPData(ons, pano, cons, sur, first, party, pid, votes);
//				winnerVotes=Integer.valueOf(votes);
//				winners.set(index,winner);
//			}
			
			//determine candidate with most votes
			if (Integer.valueOf(votes)>maxVotes) {
				maxVotes=Integer.valueOf(votes);
				mostVotesMP = new MPData(ons, pano, cons, sur, first, party, pid, votes);
			}
			
			//determine if a candidate got less then 5% of the vote
			int consTotal= ONSVotersHash.get(ons);
			if(Double.valueOf(votes)/consTotal<0.05) {
				noReturn++;
			}
			
			//new MPData object
			MPData mp= new MPData(ons, pano, cons, sur, first, party, pid, votes);
			mpdata.add(mp);
			//s.next();
			s.close();
			line =mpbr.readLine();
			//count++;
			}
		
		mpbr.close();
		return mpdata;
	}
	

	
	//import and create an array for our electorate data
	public static ArrayList<Constituency> getElecData(BufferedReader elecBR) throws IOException{
	
		elecBR.readLine();
		ArrayList<Constituency> elecdata = new ArrayList<Constituency>();
		//int electorate=0; 
		//int n=0;
		String line = elecBR.readLine();
		while (line!= null) {
			Scanner s= new Scanner(line);
			s.useDelimiter(","); 
			String consid=s.next();
			onsArray.add(consid);
			String cons=s.next();
			String county=s.next();
			int elec=Integer.valueOf(s.next());
			//ONSElectorateHash.put(consid, Integer.valueOf(elec));
			
			electorateArray.add(Integer.valueOf(elec));
			electorate=electorate+Integer.valueOf(elec);
			Constituency ed= new Constituency(consid,cons,county,elec);
			elecdata.add(ed);
			s.close();
			//n++;
			line =elecBR.readLine();
			}
		elecBR.close();
		return elecdata;
	
	}
	
	public static ArrayList<MPData> findWinners(ArrayList<MPData> candidates){
		//winners= new ArrayList<MPData>();
		//for (int i=0;i<candidates.size()-1;i++) {
			
			//int votes =Integer.valueOf(candidate.getVotes());
			int n=0;
			int winnerVotes=0;
			//MPData winner;
			MPData candidate= candidates.get(n);
			
			int pano=Integer.valueOf(candidate.getPano());
			System.out.println(pano);
			while (n<candidates.size()) {
				candidate=candidates.get(n);
				int panoComp=Integer.valueOf(candidate.getPano());
				int votes = Integer.valueOf(candidate.getVotes());
				if(panoComp==pano){
					
					
					if(votes>winnerVotes) {
						winner = candidate;
						winnerVotes=Integer.valueOf(winner.getVotes());
						
					}
					//System.out.println("hello");
					n++;
					candidate=candidates.get(n-1);
					panoComp=Integer.valueOf(candidate.getPano());
					
				}
				else {
					winnerVotes=0;
					pano=Integer.valueOf(candidate.getPano());
					if(votes>winnerVotes) {
						winner = candidate;
						winnerVotes=Integer.valueOf(winner.getVotes());
						
					}
					//System.out.println("hello");
					n++;
					candidate=candidates.get(n);
					panoComp=Integer.valueOf(candidate.getPano());
				}
				winners.add(winner);
				//pano=Integer.valueOf(candidate.getPano());
				//System.out.println(winner);
			}
			//panoComp = Integer.valueOf((candidates.get(i+1)).getPano());
			//winnerVotes=0;
		return winners;
		
	}
	

	public static void main(String[] args) {
		
		try{
			
			BufferedReader elecBR= new BufferedReader(getBR("C:\\Users\\pipbe\\Downloads\\constituencies.csv"));
			BufferedReader mpBR1= new BufferedReader(getBR("C:\\Users\\pipbe\\Downloads\\results.csv"));
			BufferedReader mpBR2= new BufferedReader(getBR("C:\\Users\\pipbe\\Downloads\\results.csv"));
			BufferedReader mpBR3= new BufferedReader(getBR("C:\\Users\\pipbe\\Downloads\\results.csv"));
			HashMap<String,Integer> ONSVotersHash =getONSVotersHash(mpBR1);
			ArrayList<Constituency> elecdata =new ArrayList<Constituency>(getElecData(elecBR));
			ArrayList<MPData> mpdata= new ArrayList<MPData>( getMPArrayList(mpBR2));
			//System.out.println(getONSCandidateHash(mpBR3));
			//System.out.println(findWinners(mpdata));
			//System.out.println(mpdata.size());
			//System.out.println(mpdata);
			//BufferedReader elecbr= new BufferedReader(getMPbr("N:\\Eclipse\\constituencies.csv"));
			
			//System.out.println(elecdata);
			//HashMap<String,Integer> ONSElectorateHash =new HashMap<>
			
		
			
			//System.out.println( '\n');
			//System.out.println(elecdata.get(0));
			
			//System.out.println(ons_array);	
			//System.out.println(electorate_array);
			//System.out.println(electorate);
			System.out.println("Total number of candidates= "+mpdata.size());
			double turnout= totalVoters / electorate;
			System.out.println("turnout= "+turnout);
			//System.out.println(onsArray);
			//System.out.println(electorateArray);
			System.out.println(ONSVotersHash);
			System.out.println("The number of candidates that did not have their deposit returned was: "+noReturn);
			System.out.println("The candidate with the most votes was: "+ mostVotesMP);
			//String key= "S14000047";
			
			//System.out.println(ONSVotersHash.get(key));
			}
		catch(IOException e) {
			 System.out.println("Problem: "+e.getMessage());
		}

	}

}
