package module2;

public class ThreeVector {
	
	double x;
	double y;
	double z;
	
	//constructor for our ThreeVector object
	public ThreeVector (double x, double y, double z) {
		this.x =x;
		this.y=y;
		this.z=z;
	}
	
	//method to find the magnitude of a vector
	public double magnitude () {	
	double mag;
	mag=java.lang.Math.sqrt(x*x+y*y+z*z);
	return mag;
	}
		
	//method to find a unit vector in the same direction as our given vector
	public ThreeVector unitVector() {
		//ThreeVector vec1 =new ThreeVector(x,y,z);
		ThreeVector unit = new ThreeVector (x/magnitude(), y/magnitude(), z/magnitude());
		return unit;
	}
	
	//method to convert our given vector into a string
	public String toString() {
		
		String xs = Double.toString(x);
		String ys = Double.toString(y);
		String zs = Double.toString(z);
		String vec= "("+xs+","+ys+","+zs+")";
	
		return vec;
	}
	
	//static method to find the scalar product of 2 three dimensional vectors
	public static double scalarProduct(ThreeVector a, ThreeVector b) {
		return (a.x*b.x)+(a.y*b.y)+(a.z*b.z);
	}
	
	//static method to find the vector product of 2 three dimensional vectors
	public static ThreeVector vectorProduct(ThreeVector a, ThreeVector b) {
		return new ThreeVector ((a.y*b.z)-(a.z*b.y),(a.z*b.x)-(a.x*b.z),(a.x*b.y)-(a.y*b.x));
	}
	
	//static method to find the resultant vector when two vectors are added 
	public static ThreeVector add(ThreeVector a, ThreeVector b) {
		return new ThreeVector ((a.x+b.x),(a.y+b.y),(a.z+b.z));
	}
	
	//static method to find the angle between two vectors
	public static double angle(ThreeVector a, ThreeVector b) {
		return (scalarProduct(a,b)/(a.magnitude()*b.magnitude()));
		//test7
	}
	
	//non static method to find the angle between two vectors, calls the calculations from the static version of the method
	public double angleNS(ThreeVector a) {
		return angle(a,this);
	}
	
	//non static method to find the scalar product of 2 three dimensional vectors
	public double scalarProductNS(ThreeVector a) {
		return scalarProduct(a,this);
	}
	
	//non static method to find the vector product of 2 three dimensional vectors
	public ThreeVector vectorProductNS(ThreeVector a) {
		return vectorProduct(a,this);
	}
	
	//non static method to find the resultant vector when two vectors are added 
	public ThreeVector addNS(ThreeVector a) {
		return add(a,this);
	}
	
	//public static void main(String[] args) {
		
//		ThreeVector myThreeVec = new ThreeVector(1,2,3);
//		ThreeVector myThreeVec2 = new ThreeVector(4,5,6);
//		System.out.println(myThreeVec.magnitude());
//		System.out.println(myThreeVec);
//		System.out.println(myThreeVec.unitVector());
//		System.out.println(angle(myThreeVec,myThreeVec2));
//		System.out.println(myThreeVec.angleNS(myThreeVec2));
		
//	}

}
