package module6;

public class PowerLawTheory implements Theory {
	
	double n;
	double x;
	//constructor to set the value of n
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

	//public static void main(String[] args) {
	//	PowerLawTheory n1= new PowerLawTheory(2);
//		System.out.println(n1.y(4));
//	}

}
