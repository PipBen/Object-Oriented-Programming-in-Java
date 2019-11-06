package module5;
import java.lang.reflect.Array;
import java.lang.StringBuilder;
import java.util.Arrays;

public class SquareMatrix {
	double[][] elements;
	double[][] matrix;
	int nRows;
	int nCols ;

	//constructor for SquareMatrix class
	public SquareMatrix(double[][] elements) throws Exception  {
		//number of rows in matrix
		int nRows = elements.length;
		//number of columns in matrix
		int nCols = Array.getLength(elements[0]);
		//throw exception if number of rows and columns is not the same
		if(nRows!= nCols) {
			throw new Exception("input matrix is not square");
		}
		this.nRows= nRows;
		this.nCols=nCols;
		this.matrix=elements;
	}
	
	//convert SquareMatrix object to a readable string
	public String toString() {
		StringBuilder matrixString = new StringBuilder();
		int i=0;
		while(i< nRows){
			matrixString.append("{");
			int j=0;
			while(j<nCols) {
				matrixString.append(matrix[i][j]+"  ");
				j++;
			}
			matrixString.append("}\n");
			i++;
		}
		return matrixString.toString();
	}
	
	//return a unit matrix SquareMatrix object
	public static SquareMatrix unitMatrix(int size) throws Exception{
		double[][] unit =new double[size][size];
		for(int i = 0; i < size; i++) unit[i][i] = 1;
	    SquareMatrix unitmatrix=new SquareMatrix(unit);
		return unitmatrix;
	}
	
	
	
	
	//java generated method to compare the equality of two SquareMatrix objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(elements);
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + nCols;
		result = prime * result + nRows;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(elements, other.elements))
			return false;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (nCols != other.nCols)
			return false;
		if (nRows != other.nRows)
			return false;
		return true;
	}
	
	//method to add two SquareMatrix objects
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		int size= sm1.nRows;
		int size2=sm2.nRows;
		if(size!=size2) {
			throw new Exception("Cannot add square matrices of different sizes");
		}
		double[][] add=new double[size][size];
		int i=0;
		while(i< sm1.nRows){
			add[i][0]=sm1.matrix[i][0]+sm2.matrix[i][0];
			int j=0;
			while(j<sm1.nCols) {
				add[i][j]=sm1.matrix[i][j]+sm2.matrix[i][j];
				j++;
			}
			i++;
		}
		SquareMatrix sm3= new SquareMatrix (add);
		return sm3;
	}
	
	//method to subtract two SquareMatrix object
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		int size= sm1.nRows;
		int size2=sm2.nRows;
		if(size!=size2) {
			throw new Exception("Cannot subtract square matrices of different sizes");
		}
		double[][] subtract=new double[size][size];
		int i=0;
		while(i< sm1.nRows){
			subtract[i][0]=sm1.matrix[i][0]-sm2.matrix[i][0];
			int j=0;
			while(j<sm1.nCols) {
				subtract[i][j]=sm1.matrix[i][j]-sm2.matrix[i][j];
				j++;
			}
			i++;
		}
		SquareMatrix sm3= new SquareMatrix (subtract);
		return sm3;
	}
	
	//method to multiply two SquareMatrix object
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		int size= sm1.nRows;
		int size2=sm2.nRows;
		if(size!=size2) {
			throw new Exception("Cannot multiply square matrices of different sizes");
		}
		double[][] multiply=new double[size][size];
		int i=0;
		int j=0;
		int k=0;
		for(i=0;i<size;i++){
	        for(j=0;j<size;j++) {
	        	for (k=0; k < size; k++) {
	        		multiply[i][j]+=sm1.matrix[i][k]*sm2.matrix[k][j];
	        	}
			}
		}
		SquareMatrix sm3= new SquareMatrix (multiply);
		return sm3;
	}
	
	//non-static methods to call the static methods defined above
	public SquareMatrix add(SquareMatrix sm2) throws Exception {
		return add(this,sm2);
	}

	public SquareMatrix subtract(SquareMatrix sm2) throws Exception {
		return subtract(this,sm2);
	}
	
	public SquareMatrix multiply(SquareMatrix sm2) throws Exception {
		return multiply(this,sm2);
	}
	
	
	

}