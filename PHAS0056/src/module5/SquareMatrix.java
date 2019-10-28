package module5;
import java.lang.reflect.Array;
import java.lang.StringBuilder;
import java.util.Arrays;

public class SquareMatrix {
	double[][] elements;
	double[][] matrix;
	int nRows=5;
	int nCols=5 ;
	int i=0;
	int j=0;
	
	public SquareMatrix(double[][] elements) throws Exception  {
		//double[][] matrix = elements;
		int nRows = elements.length;
		int nCols = Array.getLength(elements[0]);
		if(nRows!= nCols) {
			throw new Exception("input matrix is not square");
		}
	}
	
	public String toString() {
		StringBuilder matrixString = new StringBuilder();
		//StringBuilder rowString= new StringBuilder();
		//int n=0;
		while(i<= nRows){
			while(j<=nCols) {
				matrixString.append(elements[i][j]);
				j++;
			}
			i++;
		};
		
		return matrixString.toString();
	//	for (int i = 0; i < matrix.length; i++) {
     //      matrixString.append(matrix[i]);
     // }
		//return  Arrays.deepToString(elements[i][j]);
		
	}
	
	public static void main(String[] args) {
		double[][] A_comp= {{2,1,0},{0,1,0},{-1,0,2}};
		double[][] B_comp= {{1,3,1},{0,2,0},{1,0,-1}};
		//SquareMatrix A = new SquareMatrix(A_comp);
		//SquareMatrix B = new SquareMatrix(B_comp);
		//System.out.println(A);
		try {
			
			SquareMatrix A = new SquareMatrix(A_comp);
			SquareMatrix B = new SquareMatrix(B_comp);
			
			//System.out.println(Arrays.deepToString(A));
			System.out.println(A);
			//System.out.println(B);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println(A_comp);
		
	}

}