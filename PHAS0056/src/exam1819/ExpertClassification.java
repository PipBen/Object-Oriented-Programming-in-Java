package exam1819;

public class ExpertClassification extends Classification {
	
	//same as Classification, but printing volunteer ID is unnecessary
	public ExpertClassification(String line) {
		super(line);
	}
	
	public String toString() {
		String classification ="{image "+ Integer.toString(imageID)+" is a "+(species)+"}";
		return classification;
	}

}
