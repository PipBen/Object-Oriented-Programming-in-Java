package module5;


public class TestSquareMatrix {

	public static void main(String[] args) {
		double[][] A_comp= {{2,1,0},{0,1,0},{-1,0,2}};
		double[][] B_comp= {{1,3,1},{0,2,0},{1,0,-1}};
		
		try {
			SquareMatrix A = new SquareMatrix(A_comp);
			SquareMatrix B = new SquareMatrix(B_comp);
			System.out.println(A);
			System.out.println(B);
		}
		catch(Exception e){
			System.out.println(e);
		}
		//A= {{2,1,0},{0,1,0},{-1,0,2}};

	}

}
