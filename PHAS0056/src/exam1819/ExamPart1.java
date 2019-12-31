package exam1819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ExamPart1 {
	
	//static ArrayList<Image> images = new ArrayList<Image>();
	
	

	public static void main(String[] args) throws Exception {
		ImageLocationStore imageLocs = new ImageLocationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/locations.txt");
		//System.out.println(imageLocs);
		ClassificationStore classStore = new ClassificationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/classification.txt");
		//System.out.println(classStore);
		ClassificationStore expertClassStore= new ClassificationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2018-19/expert.txt");
		//System.out.println(expertClassStore);
		
		System.out.println("The total number of images is "+imageLocs.noImages());
		System.out.println("The number of images that have been classified is: "+classStore.imageClassifiedTest(imageLocs));
		System.out.println("\n################################################################################\n");
		//ImageLocationStore imageLocs
		ArrayList<Image> atLeastTen =(classStore.getAtLeastTen(imageLocs));
		System.out.println("Images that have been classified at least ten times:\n"+atLeastTen);
		//System.out.println(expertClassStore);
		expertClassStore.expertIdentify(atLeastTen);
		classStore.volunteerIdentify(atLeastTen);
	}

}
