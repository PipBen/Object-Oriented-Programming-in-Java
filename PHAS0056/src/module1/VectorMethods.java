
package module1;
import java.lang.Math.*; 
//working within the VectorMethods class
public class VectorMethods {
	
	//define our dot product function as a new method, defining the returned data type,
	//function name, and input arguments
	public static double dotProduct (double x, double y, double z, double x1, double y1, double z1) {
		
		//define dot
		double dot;
		//definition of the dot product
		dot = x*x1+y*y1+z*z1;
		return dot ;
	}
	
	public static double magnitude (double x, double y, double z) {
		
		double mag;
		mag=java.lang.Math.sqrt(x*x+y*y+z*z);
		return mag;
	}
	
	public static double angle (double x, double y, double z, double x1, double y1, double z1) {
		
		VectorMethods vm = new VectorMethods();
		double ang;
		ang= Math.acos(vm.dotProduct(x,y,z,x1,y1,z1)/(vm.magnitude(x,y,z)*vm.magnitude(x1,y1,z1)));
		return ang;
	}
	
	
	//main method	
	
	public static void main(String[] args) {
		
		//create VectorMethods object	
		VectorMethods vm = new VectorMethods();
		
		//define our vectors as (1,2,3) and (4,5,6)
		double x=1; double y=2; double z=3; double x1=4; double y1=5; double z1=6;
		
		//call and print the outcome of the dot product of 2 three dimensional vectors 
		System.out.println(vm.dotProduct(x,y,z,x1,y1,z1));
		
		//call and print the magnitude of a three dimensional vector
		System.out.println(vm.magnitude(x, y, z));
		//call and print the angle between our 2 defined vectors, converting from radians to degrees
		System.out.println(Math.toDegrees(vm.angle(x, y, z, x1, y1, z1)));
		
		//find angle between vectors (4,3,2) and (1,5,4)
		System.out.println(Math.toDegrees(vm.angle(4, 3, 2, 1, 5, 4)));
		//find angle between vectors (4,3,2) and (0,0,0)
		System.out.println(Math.toDegrees(vm.angle(4, 3, 2, 0, 0, 0)));
			}
		}
