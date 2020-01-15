package midterm1920;

import java.io.IOException;

public class MidTermExam {

	public static void main(String[] args) throws IOException{
		ConstituencyStore constituencies = new ConstituencyStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv");
		//System.out.println(constituencies);
		CandidateStore candidates = new CandidateStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
		System.out.println(candidates);
		System.out.println("Total number of candidates:" +candidates.totalCandidates());
		double turnout = (candidates.getTotalVoters()/constituencies.getTotalElectorate())*100;
		System.out.println("Turnout: "+turnout+"%");

	}

}
