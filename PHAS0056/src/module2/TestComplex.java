package module2;

public class TestComplex {

	public static void main(String[] args) {
		//define our complex number variables
		Complex c1= new Complex (1,-2);
		Complex c2= new Complex (-2,1);
		System.out.println("c1 equals "+c1+", c2 equals "+c2);
		System.out.println("c1 multipied by c2 equals "+Complex.multiply(c1,c2));
		System.out.println("c1 divided by c2 equals "+Complex.divide(c1,c2));
		System.out.println("c1 divided by i equals "+Complex.divide(c1,Complex.I));
		System.out.println("c1 divided by zero equals "+Complex.divide(c1,Complex.ZERO)+" since we cannot divide by zero");
		System.out.println("The conjugate of c1 multipied by the conjugate of c2 equals "+Complex.multiply(c1.conjugate(),c2.conjugate()));
		System.out.println("The conjugate of c2 multipied by itself equals "+Complex.multiply(c2.conjugate(),c2.conjugate()));
		
		}

}
