package module5;

public class DataPoint {
	double x;
	double y;
	double ey;
	
	public DataPoint(double x_val, double y_val,double ey_val) {
		this.x=x_val;
		this.y=y_val;
		this.ey=ey_val;
		
	}
	
	public double Getx() {
		return x;
	}
	
	public double Gety() {
		return y;
	}
	
	public double Getey() {
		return ey;
	}
	
	public String toString() {
		String point= x+" "+y+" "+ey;
		return point;
	}
	


}
