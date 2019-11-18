package module6;

public class LabelledDataPoint extends DataPoint{

	String data_point_label;

	public LabelledDataPoint(double x, double y ,double ey) {
		super(x,y,ey);
		data_point_label = "x="+x+",  y="+y+"+-"+ey;
	}
	
	public String toString() {
		return data_point_label;
	}


}