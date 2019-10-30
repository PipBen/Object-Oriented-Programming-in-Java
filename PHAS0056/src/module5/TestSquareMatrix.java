package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		
		double[][] A_comp= {{2,1,0},{0,1,0},{-1,0,2}};
		double[][] B_comp= {{1,3,1},{0,2,0},{1,0,-1}};
		double[][] C_comp= {{2,3},{3,4}};
		double[][] D_comp= {{-4,3},{3,-2}};
		
		try {
			SquareMatrix A = new SquareMatrix(A_comp);
			SquareMatrix B = new SquareMatrix(B_comp);
			SquareMatrix C = new SquareMatrix(C_comp);
			SquareMatrix D = new SquareMatrix(D_comp);
			
			System.out.println(SquareMatrix.unitMatrix(5));
			//System.out.println(Arrays.deepToString(A));
			System.out.println("A=\n"+A);
			System.out.println("B=\n"+B);
			System.out.println("C=\n"+C);
			System.out.println("D=\n"+D);
			
			System.out.println("A+B=\n"+A.add(B));
			//System.out.println(A.subtract(B));
			System.out.println("The product AB equals\n"+A.multiply(B));
			System.out.println("The product BA equals\n"+B.multiply(A));
			System.out.println("The commutator [A,B] equals \n"+(A.multiply(B)).subtract(B.multiply(A)));
			System.out.println("The product CD equals \n"+C.multiply(D));
			System.out.println("The method checking whether the product CD and the"
					+"\n2x2 unit matrix are equal returned "+SquareMatrix.unitMatrix(2).equals(C.multiply(D))+
					".\nTherefore, CD is equal to the 2x2 unit matrix.");
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}
