package midterm1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CandidateStore {
	
	ArrayList<Candidate> candidates;
	double totalVoters;
	Candidate mostVotesCandidate;
	Candidate winningCandidate;
	ArrayList<Candidate> winningCandidates;
	Candidate leastVotesWinner;
	Candidate secondPlaceCandidate;
	
	Candidate mostVotesSecondPlace;
	//ConstituencyStore constituencyStore= new ConstituencyStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv");
	
	public CandidateStore(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line=br.readLine();
		this.candidates=new ArrayList<Candidate>();
		
		while (line!= null) {
			Candidate candidate= new Candidate(line);
			candidates.add(candidate);
			this.totalVoters=this.totalVoters+candidate.getVotes();
			line= br.readLine();
		}
	}

	/**
	 * @return the candidates
	 */
	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}

	/**
	 * @param candidates the candidates to set
	 */
	public void setCandidates(ArrayList<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	public String toString() {
		return candidates.toString();
	}
	
	public int getTotalCandidates(){
		return candidates.size();
	}
	
	public double getTotalVoters() {
		return totalVoters;
	}
	
	public double getTotalVotes(String onsCode) {
		
		double totalVotes=0;
		for(int n=0; n<candidates.size(); n++) {
			Candidate candidate=candidates.get(n);
			String onsCompare=candidate.getOns();
			if(onsCompare.equals(onsCode)) {
				totalVotes=totalVotes+candidate.getVotes();
			}
		}
		return totalVotes;
		
	}
	
	public double getLostDeposits() {
		int lostDeposits=0;
		for(int n=0;n<candidates.size();n++) {
			Candidate candidate = candidates.get(n);
			String candidateONS= candidate.getOns();
			double totalVotes = getTotalVotes(candidateONS);
			double candidateVotes = candidate.getVotes();
			if(candidateVotes<(0.05*totalVotes)) {
				lostDeposits=lostDeposits+1;
			}
		}
		return lostDeposits;
	}
	
	public Candidate getMostVotesCandidate() {
		double mostVotes=0;
		//Candidate mostVotesCandidate;
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate = candidates.get(n);
			if (candidate.getVotes()>mostVotes) {
				mostVotes=candidate.getVotes();
				this.mostVotesCandidate=candidate;
			}
		}
		return this.mostVotesCandidate;
	}
	
	public Candidate getWinningCandidate(String ons){
		double mostVotes=0;
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate = candidates.get(n);
			String onsCandidate= candidate.getOns();
			if(onsCandidate.equals(ons) & candidate.getVotes()>mostVotes) {
				winningCandidate= candidate;
				mostVotes=candidate.getVotes();
			}
		}
		return winningCandidate;
	}
	
	public ArrayList<Candidate> getWinningCandidates(ConstituencyStore constituencyStore){
		ArrayList<Constituency> constituencies =constituencyStore.getConstituencies();
		this.winningCandidates= new ArrayList<Candidate>();
		for(int n=0; n<constituencies.size();n++) {
			Constituency constituency =constituencies.get(n);
			String consONS= constituency.getONS();
			winningCandidate=getWinningCandidate(consONS);
			winningCandidates.add(winningCandidate);
		}
		return winningCandidates;
	}
	
	public Candidate getLeastVotesWinner(ConstituencyStore constituencyStore) {
		double leastVotes=1000000;
		winningCandidates= getWinningCandidates(constituencyStore);
		for(int n=0; n<winningCandidates.size();n++) {
			Candidate candidate= winningCandidates.get(n);
			double votes=candidate.getVotes();
			if(votes<leastVotes) {
				leastVotesWinner= candidate;
				leastVotes=votes;
			}
		}
		return leastVotesWinner;
	}
	
	public Candidate getSecondPlaceCandidate(String ons) {
		mostVotesCandidate= getWinningCandidate(ons);
		double mostVotes=0;
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate = candidates.get(n);
			String onsCandidate= candidate.getOns();
			if(onsCandidate.equals(ons) & candidate.equals(mostVotesCandidate)==false & candidate.getVotes()>mostVotes) {
				secondPlaceCandidate= candidate;
				mostVotes=candidate.getVotes();
			}
		}
		return secondPlaceCandidate;
	}

}
