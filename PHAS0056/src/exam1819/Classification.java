package exam1819;

import java.util.Scanner;

public class Classification {
	int imageID;
	int volID;
	String species;
	
	public Classification(String line) {
		Scanner s= new Scanner(line);
		s.useDelimiter(" ");
		this.imageID= s.nextInt();
		this.volID=s.nextInt();
		this.species=s.next();
		s.close();
	}
	
	public String toString() {
		String classification ="{"+ Integer.toString(imageID)+", "+Integer.toString(volID)+", "+(species)+"}";
		return classification;
	}

	public int getVolID() {
		return volID;
	}
	
	public int getImageID() {
		return imageID;
	}
	
	public String getSpecies() {
		return species;
	}

	
	

}
