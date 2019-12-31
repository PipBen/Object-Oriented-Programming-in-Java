package exam1819;

import java.util.ArrayList;

public class ExpertSelector implements ImageSelector {
	String species;
	public ExpertSelector(String species){
		this.species=species;
	}
	//creates a subset of images classified as the chosen species by expert
	public ArrayList<Image> select(ImageLocationStore images, ClassificationStore classifications){
		//subset arraylist
		ArrayList<Image> speciesList = new ArrayList<Image>();
		//loop over all images
		for(int n=0;n<images.noImages();n++) {
			Image image = images.getIndex(n);
			int id=image.getImageID();//find id of each image
			//loop over all classifications
			for(int i=0;i<classifications.noClassifications();i++) {
				Classification classification=classifications.getIndex(i);
				//if the classifcation has the same id as the images, compare the species to the chosen species
				if (classification.getImageID()==id) {
					String classSpecies=classification.getSpecies();
					//if the classification species is the same as our chosen species, add image to subset array
					if(species.equals(classSpecies)) {
						speciesList.add(image);
					}
				}
			}
		}
		return speciesList;
	}
}
