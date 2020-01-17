package midterm1920;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Constituency {
	
	String ons; //constituency id
	String consName; //constitency name
	String region;
	double electorate;
	double totalVoters;
	CandidateStore candidateStore;
	//CandidateStore candidateStore=new CandidateStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Constituency [ons=" + ons + ", consName=" + consName + ", region=" + region + ", electorate="
				+ electorate + "]";
	}
	
	
	public double getTurnout() {
		ArrayList<Candidate> candidates= candidateStore.getCandidates();
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate= candidates.get(n);
			String candidateONS=candidate.getOns();
			if(candidateONS.equals(ons)) {
			totalVoters=totalVoters+candidate.getVotes();
			}
		}
		double turnout=totalVoters/electorate;
		return turnout;
	}
	
	
	

}
