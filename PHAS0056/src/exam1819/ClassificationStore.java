package exam1819;

import java.io.BufferedReader;
import java.util.Collections;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ClassificationStore {
	//arraylists of classifications and expertclassifications
	ArrayList<Classification> classifications;	
	ArrayList<ExpertClassification> expertClassifications;
	
	public ClassificationStore(String urlName) throws IOException{
		//unpack from url and create BufferedReader
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		
		this.classifications =new ArrayList<Classification>();
		this.expertClassifications = new ArrayList<ExpertClassification>();
		
		while (line!= null) {
			//create new classification object
			Classification classification = new Classification(line);
			//if the volunteer id of the classification is zero, classification is and expertclassification, so add to
			//appropriate array
			if (classification.getVolID()==0){
				ExpertClassification expertClassification = new ExpertClassification(line);
				expertClassifications.add(expertClassification);
				line=br.readLine();
			}
			else {
				classifications.add(classification);
				line = br.readLine();
			}
		}
	}
	
	//toString method depends on whether the classifications are expert or not
	public String toString() {
		if (classifications.isEmpty()){
			return expertClassifications.toString();
		}
		else {
			return classifications.toString();
		}
	}
	
	//return the number of classifications in the array
	public int noClassifications() {
		if (classifications.isEmpty()){
			return expertClassifications.size();
		}
		else {
			return classifications.size();
		}
	}
	
	public Classification getIndex(int n) {
		if (classifications.isEmpty()){
			return expertClassifications.get(n);
		}
		else {
			return classifications.get(n);
		}
	}
	
	//returns an arraylist of the image id of every classification
	public ArrayList<Integer> getClassifiedIDs(){
		ArrayList<Integer> classifiedIDs= new ArrayList<Integer>();
		for(int n=0;n<classifications.size();n++) {
			Classification classification= classifications.get(n);
			int classifiedID= classification.getImageID();
			classifiedIDs.add(classifiedID);
		}
		return classifiedIDs;
	}
	//returns the number of images that have been classified by at least one volunteer
	public int imageClassifiedTest(ImageLocationStore images) {
		ArrayList<Integer> classifiedIDs= getClassifiedIDs();
		int noClassifiedImages=0;
		for(int n=0;n<images.noImages();n++) {
			
			Image image= images.getIndex(n);
			int id= image.getImageID();
			if(classifiedIDs.contains(id)) {
				noClassifiedImages++;
			}
		}
		return noClassifiedImages;
	}
	//returns an arraylist of images that have been classified by at least ten volunteers
	public ArrayList<Image> getAtLeastTen(ImageLocationStore images){
		ArrayList<Image> atLeastTen = new ArrayList<Image>();
		ArrayList<Integer> classifiedIDs= getClassifiedIDs();
		for(int n=0;n<images.noImages();n++) {
			Image image = images.getIndex(n);
			int id = image.getImageID();
			if(Collections.frequency(classifiedIDs, id)>=10) {
				atLeastTen.add(image);
			}
		}
		return atLeastTen;
	}
	
	//print the expert classifications of a given arraylist of images
	public void expertIdentify(ArrayList<Image> images) {
		System.out.println("EXPERT CLASSIFICATIONS:\n");
		for(int n=0;n<images.size();n++) {
			Image image = images.get(n);
			int id= image.getImageID();
			Classification expClass= getIndex(id-1);
			
			System.out.println(expClass);
		}
	}
	
	//print volunteer classifications of a given arraylist of images 
	public void volunteerIdentify(ArrayList<Image> images) {
		System.out.println("VOLUNTEER CLASSIFICATIONS:\n");
		for(int n=0;n<images.size();n++) {
			Image image = images.get(n);
			int id= image.getImageID();
			for(int i=0;i<noClassifications();i++) {
				Classification volClass= getIndex(i);
				if (volClass.getImageID()==id) {
					int volID= volClass.getVolID();
					String species= volClass.getSpecies();
					System.out.println("Volunteer "+Integer.toString(volID)+" identified image "+id+ " as "+ species);
				}
			}
		}
	}

}
