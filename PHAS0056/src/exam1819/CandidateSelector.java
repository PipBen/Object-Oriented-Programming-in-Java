package exam1819;

import java.util.ArrayList;
import java.util.Collections;

public class CandidateSelector implements ImageSelector {
	
	String species;
	public CandidateSelector(String species){
		this.species=species;
	}
	//creates a subset of images classified as candidates to be the chosen species
	public ArrayList<Image> select(ImageLocationStore images, ClassificationStore classifications){
		ArrayList<Image> speciesCandidateList = new ArrayList<Image>();
		for(int n=0;n<images.noImages();n++) {
			Image image = images.getIndex(n);
			int id = image.getImageID();
			double speciesClassifications=0;
			double totalClassifications=0;	
				for(int i=0;i<classifications.noClassifications();i++) {
					Classification classification=classifications.getIndex(i);
					
					if (classification.getImageID()==id) {
						String classSpecies=classification.getSpecies();
						totalClassifications++;
						if(species.equals(classSpecies)) {
							speciesClassifications++;
						if (speciesClassifications>(int)(totalClassifications/2) & speciesCandidateList.contains(image)==false) {
								speciesCandidateList.add(image);
							}
							//speciesCandidateList.add(image);
						}
					}
				}
				
			}
		return speciesCandidateList;
	}
}
