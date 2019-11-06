package module5;

public class Theory {
	double n;
	double y;
	double x;
	
	//constructor to set the value o n
	public Theory(double n_val) {
		this.n=n_val;
	}

	//method returning the functon y=x^n
	public double return_y(double x) {
		this.y= Math.pow(x,n);
		return y;
	}
}
