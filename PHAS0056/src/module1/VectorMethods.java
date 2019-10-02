package module1;

public class VectorMethods {
	
	

		public static double dotProduct (double x, double y, double z, double x1, double y1, double z1) {
		
		
			double dot;
			dot = x*x1+y*y1+z*z1;
			return dot ;
		}
		
	public static void main(String[] args) {
			
		VectorMethods vm = new VectorMethods();
		System.out.println(vm.dotProduct(1,2,3,4,5,6));
			}
		}
