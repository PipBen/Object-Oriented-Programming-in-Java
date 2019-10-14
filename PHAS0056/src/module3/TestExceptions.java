package module3;

public class TestExceptions {
	public static void main(String[] args) {
	Complex n = new Complex(1,2);
	Complex m = new Complex(0,0);
	
	//divide
	try {
		Complex div= Complex.divide(n,m);
		System.out.println("n divided by m is"+div);
	}
	catch(Exception e){
		System.out.println(e);
		}
	
	//normalise
	try {
		System.out.println("The normalised version of of m is"+m.normalised());
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	
	ThreeVector v1= new ThreeVector (1,2,3);
	ThreeVector v2= new ThreeVector (0,0,0);
	//unit vector
	try {
		System.out.println("The unit vector of v1"+v1.unitVector());
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	//angle
	try {
		System.out.println("The angle between v1 and v2 is"+ThreeVector.angle(v1,v2));
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	
	
	try {
		FallingParticle FP= new FallingParticle(-4,5);
		System.out.println("The unit vector of v1"+FP);
	}
	catch(Exception e1) {
		System.out.println(e1);
	}
	
	
	}
}
