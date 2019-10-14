package module2;

public class Complex {
	static double pi=Math.PI;
	
	double a;
	double b;
	
	//constructor for our Complex object
	public Complex (double a,double b) {
		this.a=a;
		this.b=b;
				
	}
	
	//method to return the real part of a complex number
	public double real() {
		return a;
	}
	
	//method to return the imaginary part of a complex number
	public  double imag() {
		return b;
	}
	
	//method to return the modulus of a complex number
	public double modulus() {
		return Math.sqrt(a*a+b*b);
	}
	
	//method to return the argument of a complex number (angle anticlockwise from positive x axis on argand diagram)
	public double angle() {
		double theta=Math.atan(b/a);
		if( a>0 & b>0){
			return theta;
		}
		else if (a<0 & b>0){ 
			return Math.PI-Math.atan(b/(-a));
		}
		else if(a<0 & b<0) {
			return Math.PI+Math.atan((-b)/(-a));
		}
		else {
			return (2*Math.PI)-Math.atan((-b)/a);
		}
	}
	
	//method to return the complex conjugate of a complex number
	public Complex conjugate() {
		Complex conj = new Complex(a,-b);
		return conj;
	}
	
	//method to return a normalised version of our complex number
	public Complex normalised() {
		return new Complex (a/modulus(),b/modulus());
	}
	
	//method to return true or false if our complex number is equal to the complex number passed in the argument or not
	public boolean equals(Complex c) {
		if (a==c.a & b==c.b) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method to convert our complex number into a readable string
	public String toString() {
		String as = Double.toString(a);
		String bs = Double.toString(b);
		if (b>=0) {
			String comp1 = "("+as+"+"+bs+"i)";
			return comp1;
			}
		else {
			String comp2= "("+as+bs+"i)";
			return comp2;
		}
		
	}
	
	//method to determine the real and imaginary parts of a complex number given its magnitude and argument 
	public static Complex setFromModulusAngle(double mag, double ang) {
		
		//use if, else if and else statements to calculate the real and imaginary values depending on which quadrant
		//the argument lies in on an argand diagram
		//first quadrant
		if(ang>=0 & ang<=pi/2) {
			double theta=ang;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			return new Complex(a_real,b_imag);
			}
		//second quadrant
		else if(ang>pi/2 & ang<=pi) {
			double theta=pi-ang;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(-a_real,b_imag);
		}
		//third quadrant
		else if(ang>pi & ang<=(3*pi/2)) {
			double theta = ang-pi;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(-a_real,-b_imag);
		}
		//fourth quadrant
		else {
			double theta=2*pi-ang;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(a_real,-b_imag);
			}
	}
	
	//static method to add two complex numbers
	public static Complex add(Complex x, Complex y) {
		double a_add=x.a+y.a;
		double b_add=x.b+y.b;
		return new Complex(a_add,b_add);
	}
	
	//static method to subtract two complex numbers
	public static Complex subtract(Complex x, Complex y) {
		double a_sub=x.a-y.a;
		double b_sub=x.b-y.b;
		return new Complex(a_sub,b_sub);
	}
	
	//static method to multiply two complex numbers
	public static Complex multiply(Complex x, Complex y) {
		double real= x.a*y.a-x.b*y.b;
		double imag= x.a*y.b+y.a*x.b;
		return new Complex (real,imag);
	}
	
	//static method to divide two complex numbers
	public static Complex divide(Complex x, Complex y) {
		double real= (x.a*y.a+x.b*y.b)/(y.a*y.a+y.b*y.b);
		double imag= ((x.b*y.a)-(x.a*y.b))/(y.a*y.a+y.b*y.b);
		return new Complex (real,imag);
	}
	
	//define complex number objects for 1, 0 and i
	static Complex ONE =new Complex(1,0);
	static Complex ZERO = new Complex (0,0);
	static Complex I= new Complex (0,1);
	
	

}
