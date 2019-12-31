package exam1819;

import java.util.ArrayList;
import java.util.Collections;

public class CandidateSelector implements ImageSelector {
	
	String species;
	public CandidateSelector(String species){
		this.species=species;
	}
	
	public ArrayList<Image> select(ImageLocationStore images, ClassificationStore classifications){
		ArrayList<Image> speciesCandidateList = new ArrayList<Image>();
		ArrayList<Integer> classifiedIDs= classifications.getClassifiedIDs();
		for(int n=0;n<images.noImages();n++) {
			Image image = images.getIndex(n);
			int id = image.getImageID();
			if(Collections.frequency(classifiedIDs, id)>=2) {
			int speciesClassifications=0;
			double totalClassifications=0;	
				for(int i=0;i<classifications.noClassifications();i++) {
					Classification classification=classifications.getIndex(i);
					
					if (classification.getImageID()==id) {
						String classSpecies=classification.getSpecies();
						if(species.equals(classSpecies)) {
							speciesClassifications++;
							totalClassifications++;
							if (speciesClassifications>=(totalClassifications/2) & speciesCandidateList.contains(image)==false) {
								speciesCandidateList.add(image);
							}
							//speciesCandidateList.add(image);
						}
						else {
							totalClassifications++;
						}
						
					}
				}
				
			}
		}
		return speciesCandidateList;
	}
}
