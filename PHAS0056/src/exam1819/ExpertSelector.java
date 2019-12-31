package exam1819;

import java.util.ArrayList;

public class ExpertSelector implements ImageSelector {
	String species;
	public ExpertSelector(String species){
		this.species=species;
	}
	
	public ArrayList<Image> select(ImageLocationStore images, ClassificationStore classifications){
		ArrayList<Image> speciesList = new ArrayList<Image>();
		for(int n=0;n<images.noImages();n++) {
			Image image = images.getIndex(n);
			int id=image.getImageID();
			for(int i=0;i<classifications.noClassifications();i++) {
				Classification classification=classifications.getIndex(i);
				if (classification.getImageID()==id) {
					String classSpecies=classification.getSpecies();
					if(species.equals(classSpecies)) {
						speciesList.add(image);
					}
				}
				//else {continue;}
			}
		}
		return speciesList;
	}
}
