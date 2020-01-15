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
	
	

}
