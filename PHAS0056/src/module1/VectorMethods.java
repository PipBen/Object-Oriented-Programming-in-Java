
package module1;

//working within the VectorMethods class
public class VectorMethods {
	
	//define our dot product function as a new method to return the scalar product of two three dimensional vectors, defining the returned data type,
	//function name, and input arguments
	public double dotProduct (double x, double y, double z, double x1, double y1, double z1) {
		
		//define dot
		double dot;
		//definition of the dot product
		dot = x*x1+y*y1+z*z1;
		return dot ;
	}
	
	//define a method to calculate the magnitude of a three-dimensional vector
	public double magnitude (double x, double y, double z) {
		
		double mag;
		mag=java.lang.Math.sqrt(x*x+y*y+z*z);
		return mag;
	}
	
	//define a method to find the angle between two 3-dimensional vectors
	public double angle (double x, double y, double z, double x1, double y1, double z1) {
		
		//VectorMethods vm = new VectorMethods();
		double ang;
		ang= Math.acos(dotProduct(x,y,z,x1,y1,z1)/(magnitude(x,y,z)*magnitude(x1,y1,z1)));
		return ang;
	}
	
	
	//main method	
	
	public static void main(String[] args) {
		
		//create VectorMethods object	
		VectorMethods vm = new VectorMethods();
		
		//define our vectors as (1,2,3) and (4,5,6)
		double x=1; double y=2; double z=3; double x1=4; double y1=5; double z1=6;
		
		//call and print the outcome of the dot product of 2 three dimensional vectors 
		System.out.println("The dot product of the vectors (1,2,3) and (4,5,6) is "+vm.dotProduct(x,y,z,x1,y1,z1));
		
		//call and print the magnitude of a three dimensional vector
		System.out.println("\nThe magnitude of the vector (1,2,3) is "+vm.magnitude(x, y, z));
		
		//call and print the angle between our 2 defined vectors, converting from radians to degrees
		System.out.println("\nThe angle product of the vectors (1,2,3) and (4,5,6) is "+Math.toDegrees(vm.angle(x, y, z, x1, y1, z1))+ " degrees");
		
		//find angle between vectors (4,3,2) and (1,5,4)
		System.out.println("\nThe angle product of the vectors (4,3,2) and (1,5,4) is "+Math.toDegrees(vm.angle(4, 3, 2, 1, 5, 4)));
		
		//find angle between vectors (4,3,2) and (0,0,0)
		System.out.println("\nIn attempting to calculate the angle between the vectors (4,3,2) and (0,0,0), we get a result of "+Math.toDegrees(vm.angle(4, 3, 2, 0, 0, 0))
				+"\nThis is because the vector (0,0,0) has a magnitude of zero, so in our angle method we end up dividing by zero, which is not possible.");
		//cannot find the angle between 2 vectors when one of them has zero magnitude
			}
		}
