package module2;

public class ThreeTestVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		System.out.println("v1="+v1);
		System.out.println("v2="+v2);
		System.out.println("v3="+v3);
		System.out.println("\nThe unit vector of v1 is "+v1.unitVector());
		System.out.println("The unit vector of v2 is "+v2.unitVector());
		System.out.println("The unit vector of v3 is "+v3.unitVector()+" Since v3 has no magnitude");
		
		System.out.println("\nThe below uses static methods to calculate scalar and vector products");
		System.out.println("The scalar product of v1 and v2 is "+ThreeVector.scalarProduct(v1,v2));
		System.out.println("The scalar product of v1 and v3 is "+ThreeVector.scalarProduct(v1,v3));
		System.out.println("The vector product of v1 and v2 is "+ThreeVector.vectorProduct(v1,v2));
		System.out.println("The vector product of v1 and v3 is "+ThreeVector.vectorProduct(v1,v3));
		
		System.out.println("\nThe below uses non-static methods to calculate scalar and vector products");
		System.out.println("The scalar product of v1 and v2 is "+v2.scalarProductNS(v1));
		System.out.println("The scalar product of v1 and v3 is "+v3.scalarProductNS(v1));
		System.out.println("The vector product of v1 and v2 is "+v2.vectorProductNS(v1));
		System.out.println("The vector product of v1 and v3 is "+v3.vectorProductNS(v1));
		
		System.out.println("\nThe below uses static methods to calculate the angle between the above defined vectors");
		System.out.println("The angle between v1 and v2 is "+ThreeVector.angle(v1, v2)+" radians");
		System.out.println("The angle between v1 and v3 is "+ThreeVector.angle(v1, v3)+" since v3 is of zero magnitude");
		
		System.out.println("\nThe below uses non-static methods to calculate the angle between the above defined vectors");
		System.out.println("The angle between v1 and v2 is " +v2.angleNS(v1)+" radians");
		System.out.println("The angle between v1 and v2 is "+v3.angleNS(v1)+" since v3 is of zero magnitude");
		
		System.out.println("\nWhen we attempt to print one of our vectors using 'System.out.println(v1),' without having a"
				+ "\n'toString' method defined, the console returns 'module2.ThreeVector@4517d9a3.' This suggests that in attempting"
				+ "\nto print our vector, the package name, class name and a hash code are output, since there is no 'toString' method"
				+ "\nto clarify how we want this type of object to be displayed.");
		
		
		
	}

}
