package module2;

public class Complex {
	
	double a;
	double b;
	
	//constructor for our Complex object
	public Complex (double a,double b) {
		this.a=a;
		this.b=b;
				
	}
	
	public double real() {
		return a;
	}
	
	public  double imag() {
		return b;
	}
	
	public double modulus() {
		return Math.sqrt(real()*real()+imag()*imag());
	}

	
	
	public static void main(String[] args) {
		Complex number = new Complex(4,5);
		System.out.println(number.modulus());
	}

}
