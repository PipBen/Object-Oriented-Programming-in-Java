package midterm1920;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**Class representing a constituency in 2017 general election
 * @author zcappbe
 *
 */
/**
 * @author zcappbe
 *
 */
public class Constituency {
	
	String ons; //constituency id
	String consName; //constitency name
	String region;
	double electorate;
	double totalVoters;
	CandidateStore candidateStore;
	ArrayList<Candidate> allCandidates;
	ArrayList<Candidate> candidates;
	
	public Constituency(String line)throws IOException{
		Scanner s= new Scanner(line);
		s.useDelimiter(",");
		this.ons=s.next();
		this.consName=s.next();
		this.region=s.next();
		this.electorate=s.nextDouble();
		s.close();
	}

	public String getONS() {
		return ons;
	}

	public String getConsName() {
		return consName;
	}

	public String getRegion() {
		return region;
	}

	public double getElectorate() {
		return electorate;
	}

	public void setONS(String ons) {
		this.ons = ons;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setElectorate(double electorate) {
		this.electorate = electorate;
	}
	
	public void setCandidateStore(CandidateStore candidateStore) throws IOException{
		this.candidateStore= candidateStore;
		
	}
	
	public ArrayList<Candidate> getCandidates(){
		allCandidates=candidateStore.getCandidates();
		candidates= new ArrayList<Candidate>();
		for(int n=0; n<allCandidates.size();n++) {
			Candidate candidate = allCandidates.get(n);
			if(candidate.getOns().equals(ons)) {
				candidates.add(candidate);
			}
		}
		return candidates;
	}
	
	public Candidate getWinner() {
		candidates=getCandidates();
		Collections.sort(candidates, new SortByVotes());
		return candidates.get(candidates.size()-1);
	}
	
	public Candidate getSecond() {
		candidates=getCandidates();
		Collections.sort(candidates, new SortByVotes());
		return candidates.get(candidates.size()-2);
	}
	
	public double getCloseness() {
		return getWinner().getVotes()-getSecond().getVotes();
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return consName; 
	}
	
	
	public double getTurnout() {
		totalVoters=0;
		ArrayList<Candidate> candidates= candidateStore.getCandidates();
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate= candidates.get(n);
			String candidateONS=candidate.getOns();
			if(candidateONS.equals(ons)) {
			totalVoters=totalVoters+candidate.getVotes();
			}
		}
		double turnout=totalVoters/getElectorate();
		return turnout;
	}	
	
	
}
