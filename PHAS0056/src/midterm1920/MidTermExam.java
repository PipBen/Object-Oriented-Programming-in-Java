package midterm1920;

import java.io.IOException;

public class MidTermExam {

	public static void main(String[] args) throws IOException{
		ConstituencyStore constituencies = new ConstituencyStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv");
		//System.out.println(constituencies);
		CandidateStore candidates = new CandidateStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
		//System.out.println(candidates);
		System.out.println("Total number of candidates:" +candidates.getTotalCandidates());
		double turnout = (candidates.getTotalVoters()/constituencies.getTotalElectorate())*100;
		System.out.println("Turnout: "+turnout+"%");
		double lostDeposits= candidates.getLostDeposits();
		System.out.println("Number of lost deposits: "+ lostDeposits);
		System.out.println("Candidate with most votes: "+ candidates.getMostVotesCandidate());
		System.out.println(candidates.getSecondPlaceCandidates());
		System.out.println("Winner with least votes: "+candidates.getLeastVotesWinner());
		//System
		System.out.println("Second place with most votes: "+candidates.getMostVotesSecondPlace());
		//System.out
	}

}
