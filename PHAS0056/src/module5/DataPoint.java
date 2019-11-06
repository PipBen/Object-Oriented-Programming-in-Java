package module5;

public class DataPoint {
	//class variables
	double x;
	double y;
	double ey;
	
	//constructor for DataPoint oject
	public DataPoint(double x_val, double y_val,double ey_val) {
		this.x=x_val;
		this.y=y_val;
		this.ey=ey_val;
	}
	
	//getter method for variable x
	public double Getx() {
		return x;
	}
	//getter method for variable y
	public double Gety() {
		return y;
	}
	//getter method for variable ey
	public double Getey() {
		return ey;
	}
	//converts DataPoint object into readable string
	public String toString() {
		String point= x+" "+y+" "+ey;
		return point;
	}
	
}
