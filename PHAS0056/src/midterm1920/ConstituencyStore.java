package midterm1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author zcappbe
 *
 */
public class ConstituencyStore {
	
	ArrayList<Constituency> constituencies;
	double totalElectorate=0;
	HashMap<String,Constituency> onsConsHash;
	ArrayList<Candidate> secondPlaceCandidates;
	Candidate mostVotesSecondPlace;
	static ArrayList<Constituency> fiveLowestTurnout;
	static ArrayList<Constituency> sortedConstituencies;
	CandidateStore candidateStore;
	
	
	/**
	 * @param constituencyURL
	 * @param candidateStore
	 * @throws IOException
	 */
	public ConstituencyStore(String constituencyURL, CandidateStore candidateStore) throws IOException{
		URL u = new URL(constituencyURL);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line=br.readLine();
		
		constituencies= new ArrayList<Constituency>();
		this.onsConsHash = new HashMap<String, Constituency>();
		
		while (line!= null) {
			Constituency constituency = new Constituency(line);
			constituency.setCandidateStore(candidateStore);
			constituencies.add(constituency);
			this.totalElectorate=this.totalElectorate +constituency.getElectorate();
			this.onsConsHash.put(constituency.getONS(), constituency);
			line= br.readLine();
		}
	}
	
	/**
	 * @return
	 */
	public double getTotalElectorate() {
		return totalElectorate;
	}

	/**
	 * @return
	 */
	public ArrayList<Constituency> getConstituencies() {
		return constituencies;
	}
	
	/**
	 * @param candidateStore
	 * @throws IOException
	 */
	public void setCandidateStore(CandidateStore candidateStore) throws IOException{
		this.candidateStore= candidateStore;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return constituencies.toString();
	}
	
	/**
	 * @return
	 */
	public ArrayList<Candidate> getSecondPlaceCandidates(){
		
		ArrayList<Constituency> constituencies =getConstituencies();
		this.secondPlaceCandidates= new ArrayList<Candidate>();
		for(int n=0; n<constituencies.size();n++) {
			Constituency constituency =constituencies.get(n);
			String consONS= constituency.getONS();
			Candidate secondPlaceCandidate=candidateStore.getSecondPlaceCandidate(consONS);
			secondPlaceCandidates.add(secondPlaceCandidate);
		}
		return secondPlaceCandidates;
	}
	
	public Candidate getMostVotesSecondPlace() {
		double mostVotes=0;
		ArrayList<Candidate> secondPlaceCandidates= getSecondPlaceCandidates();
		for(int n=0; n<secondPlaceCandidates.size();n++) {
			Candidate candidate = secondPlaceCandidates.get(n);
			double votes=candidate.getVotes();
			if(votes>mostVotes) {
				mostVotesSecondPlace= candidate;
				mostVotes=candidate.getVotes();
			}
		}
		return mostVotesSecondPlace;
	}
	
	
	
	
//	public ArrayList<Constituency> sortByTurnout() {
//		Collections.sort(constituencies, new SortByTurnout());
//		sortedConstituencies=constituencies;
//		return sortedConstituencies;
//	}
	
	public ArrayList<Constituency> getFiveLowestTurnouts(ArrayList<Constituency> sortedConstituencies){
		int n=0;
		fiveLowestTurnout= new ArrayList<Constituency>();
		while(n<5) {
			Constituency constituency =sortedConstituencies.get(n);
			
			double turnout=constituency.getTurnout()*constituency.getElectorate();
			fiveLowestTurnout.add(constituency);
			double nonVotePerc= (1-constituency.getTurnout())*100;
			System.out.println(Integer.toString(n+1)+". "+constituency+ "Percentage of non-voters: "+nonVotePerc+"%");
			
			ArrayList<Candidate> candidates=constituency.getCandidates();
			for(int i=0; i<candidates.size();i++) {
				double votes= candidates.get(i).getVotes();
				double voteShare= (votes/turnout)*100;
				System.out.println(candidates.get(i)+"Vote Share: "+Double.toString(voteShare)+"%");
				
			}
			System.out.println("\n");
			n++;
		}
		return fiveLowestTurnout;
	}
	
	public ArrayList<Constituency> getFiveHighestTurnouts(ArrayList<Constituency> sortedConstituencies){
		int size=sortedConstituencies.size();
		int n=size-1;
		fiveLowestTurnout= new ArrayList<Constituency>();
		while(n>size-6) {
			Constituency constituency =sortedConstituencies.get(n);
			
			double turnout=constituency.getTurnout()*constituency.getElectorate();
			fiveLowestTurnout.add(constituency);
			double nonVotePerc= (1-constituency.getTurnout())*100;
			System.out.println(Integer.toString(size-n)+". "+constituency+ ", Percentage of non-voters: "+nonVotePerc+"%");
			
			ArrayList<Candidate> candidates=constituency.getCandidates();
			for(int i=0; i<candidates.size();i++) {
				double votes= candidates.get(i).getVotes();
				double voteShare= (votes/turnout)*100;
				System.out.println(candidates.get(i)+"Vote Share: "+Double.toString(voteShare)+"%");
				
			}
			System.out.println("\n");
			n--;
		}
		return fiveLowestTurnout;
	}
	
	public ArrayList<Constituency> sortByCloseness(){
		Collections.sort(constituencies, new SortByCloseness());
		return constituencies;
	}
	
	/**
	 * 
	 */
	public void printTenClosest() {
		constituencies= sortByCloseness();
		int n=0;
		while(n<10) {
			Constituency constituency= constituencies.get(n);
			double winnerPerc =(constituency.getWinner().getVotes())/(constituency.getTurnout()*constituency.getElectorate())*100;
			double secondPerc=(constituency.getSecond().getVotes())/(constituency.getTurnout()*constituency.getElectorate())*100;
			System.out.println(Integer.toString(n+1)+". "+constituency);
			System.out.println("Winner: "+constituency.getWinner()+ "Vote Share: "+winnerPerc+"%");
			System.out.println("Second: "+constituency.getSecond()+ "Vote Share: "+secondPerc+"%");
			int nonVoters= (int)((1-constituency.getTurnout())*constituency.getElectorate());
			double nonVotePerc= (1-constituency.getTurnout())*100;
			System.out.println("Non-voters: "+nonVoters +", Percentage: "+nonVotePerc+"%\n");
			n++;
		}
	}
	
}
