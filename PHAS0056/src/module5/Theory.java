package module5;

public class Theory {
	double n;
	double y;
	double x;
	
	public Theory(double n_val) {
		//this.x=x_val;
		this.n=n_val;
	}

	//public void Set_n(double n_val) {
	//	this.n=n_val;
	//}
	
	public double return_y(double x) {
		this.y= Math.pow(x,n);
		return y;
	}
}
