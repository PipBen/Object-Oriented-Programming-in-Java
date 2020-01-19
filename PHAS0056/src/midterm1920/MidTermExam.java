package midterm1920;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MidTermExam {

	public static void main(String[] args) throws IOException{
		
		//System.out.println(constituencies);
		CandidateStore candidates = new CandidateStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
		ConstituencyStore constituencies = new ConstituencyStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv", candidates);
		constituencies.setCandidateStore(candidates);
		//System.out.println(candidates);
		System.out.println("Total number of candidates:" +candidates.getTotalCandidates());
		double turnout = (candidates.getTotalVoters()/constituencies.getTotalElectorate())*100;
		System.out.println("Turnout: "+turnout+"%");
		double lostDeposits= candidates.getLostDeposits();
		System.out.println("Number of lost deposits: "+ lostDeposits);
		System.out.println("Candidate with most votes: "+ candidates.getMostVotesCandidate());
		//System.out.println(constituencies.getSecondPlaceCandidates(candidates));
		System.out.println("Winner with least votes: "+candidates.getLeastVotesWinner(constituencies));
		//System
		System.out.println("Second place with most votes: "+constituencies.getMostVotesSecondPlace());
		
		//System.out.println(constituencies.getFiveLowestTurnouts());
		ArrayList<Constituency> consList= constituencies.getConstituencies();
		Collections.sort(consList, new SortByTurnout());
		//System.out.println(consList);
		System.out.println("##########################################");
		System.out.println("LOWEST OVERALL TURNOUT:");
		constituencies.getFiveLowestTurnouts(consList);
		System.out.println("\n##########################################");
		System.out.println("HIGHEST OVERALL TURNOUT:");
		constituencies.getFiveHighestTurnouts(consList);
		System.out.println("\n##########################################");
		System.out.println("CLOSEST ELECTIONS:\n");
		constituencies.printTenClosest();
		
		//System.out.println()
		//System.out
	}

}
