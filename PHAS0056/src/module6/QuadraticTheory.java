package module6;

public class QuadraticTheory implements Theory{
	double a;
	double b;
	double c;
	double x;
	
	public QuadraticTheory(double a_val,double b_val, double c_val) {
		this.a=a_val;
		this.b=b_val;
		this.c=c_val;
	}
	
	public double y(double x) {
		this.x=x;
		return a*Math.pow(x, 2)+ b*x+c;
	}
	
	public String toString() {
		String quad= "y= "+ a+"x"+"^2 + "+b+"x "+"+ "+c;
		return quad;
	}
	
	public static void main(String[] args) {
		QuadraticTheory n1= new QuadraticTheory(1,2,3);
		System.out.println(n1.y(4));
	}


}
