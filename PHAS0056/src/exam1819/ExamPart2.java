package exam1819;

public class ExamPart2 {

	public static void main(String[] args) throws Exception {
		ImageLocationStore imageLocs = new ImageLocationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
		ClassificationStore expertClassStore= new ClassificationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");
		ClassificationStore classStore = new ClassificationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
		
		String species=new String("lion");
		
		ImageSelector expertLions = new ExpertSelector(species);
		System.out.println("THE BELOW IMAGES ARE LIONS:");
		System.out.println(expertLions.select(imageLocs, expertClassStore));
		
		ImageSelector candidateLions = new CandidateSelector(species);
		System.out.println("THE BELOW ARE LION CANDIDATES:");
		System.out.println(candidateLions.select(imageLocs, classStore));
	}

}
