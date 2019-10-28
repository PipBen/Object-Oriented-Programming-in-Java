package module5;
import java.lang.reflect.Array;

public class SquareMatrix {
	
	
	public SquareMatrix(double[][] elements) throws Exception {
		double[][] matrix = elements;
		int nRows = matrix.length;
		int nCols = Array.getLength(matrix[0]);
		if(nRows!= nCols) {
			throw new Exception("input matrix is not square");
		}
	}
	
	public String toString() {
		String row1= double.toString
		
	}

}
