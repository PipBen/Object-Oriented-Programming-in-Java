package module6;

public class PowerLawTheory implements Theory {
	
	double n;//power
	double x;
	
	//set n
	public PowerLawTheory(double n_val) {
		this.n=n_val;
	}
	//implement method y from Theory interface
	public double y(double x) {
		this.x=x;
		return Math.pow(x,n);
	}
	
	public String toString() {
		String pow = "y= x^"+n;
		return pow;
	}

}
