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

public class ConstituencyStore {
	
	ArrayList<Constituency> constituencies;
	double totalElectorate=0;
	HashMap<String,Constituency> onsConsHash;
	ArrayList<Candidate> secondPlaceCandidates;
	Candidate mostVotesSecondPlace;
	
	public ConstituencyStore(String constituencyURL, CandidateStore candidateStore) throws IOException{
		URL u = new URL(constituencyURL);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line=br.readLine();
		
		this.constituencies= new ArrayList<Constituency>();
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
	
	public double getTotalElectorate() {
		return totalElectorate;
	}

	public ArrayList<Constituency> getConstituencies() {
		return constituencies;
	}

	public void setConstituencies(ArrayList<Constituency> constituencies) {
		this.constituencies = constituencies;
	}
	
	public String toString() {
		return constituencies.toString();
	}
	
	public ArrayList<Candidate> getSecondPlaceCandidates(CandidateStore candidateStore){
		
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
	
	public Candidate getMostVotesSecondPlace(CandidateStore candidateStore) {
		double mostVotes=0;
		ArrayList<Candidate> secondPlaceCandidates= getSecondPlaceCandidates(candidateStore);
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
	
	
	Comparator<Constituency> compareByTurnout=new Comparator<Constituency>() {
		@Override
		public int compare(Constituency a, Constituency b) {
			return Double.valueOf(a.getTurnout()).compareTo(Double.valueOf(b.getTurnout()));
		}
	};
	
	public void sortByTurnout() {
		Collections.sort(constituencies, compareByTurnout);
	}

}
