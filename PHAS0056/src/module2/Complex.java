package module2;

public class Complex {
	
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
			String comp1 = as+"+"+bs+"i";
			return comp1;
			}
		else {
			String comp2= as+bs+"i";
			return comp2;
		}
		
	}
	
	public static Complex setFromModulusAngle(double mag, double ang) {
		
		double pi=Math.PI;
		
		
		if(ang>=0 & ang<=pi/2) {
			double theta=ang;
			
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			Complex result= new Complex(a_real,b_imag);
			return result;
			}
		
		else if(ang>pi/2 & ang<=pi) {
			double theta=pi-ang;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(-a_real,b_imag);
		}
		
		else if(ang>pi & ang<=(3*pi/2)) {
			double theta = ang-pi;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(-a_real,-b_imag);
		}
		
		else {
			double theta=2*pi-ang;
			double a_real=Math.sqrt((mag*mag)/((Math.tan(theta)*(Math.tan(theta)))+1));
			double b_imag=a_real*Math.tan(theta);
			
			return new Complex(a_real,-b_imag);
			
		}
		
	}
		


	public static void main(String[] args) {
		Complex number = new Complex(5,-4);
		Complex number2= new Complex(2,2);
		System.out.println(number.real());
		System.out.println(number.modulus());
		System.out.println(number.angle());
		System.out.println(number);
		System.out.println(number.equals(number));
		System.out.println(setFromModulusAngle(6,2*(Math.PI/5)));
	}
	
	

}
