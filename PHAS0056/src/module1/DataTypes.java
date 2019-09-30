package module1;

public class DataTypes {

	public static void main(String[] args) {
	   
		//initiate a double variable with the value 5.0
		double doubVar=5.0;
		System.out.println( doubVar);
		
		//initiate a float variable with value 5.0
		float floatVar=5;
		System.out.println( floatVar);
		
		//initiate a integer variable with value 5
		int intVar=5;
		System.out.println( intVar);
		
		//initiate a long variable with value 5
		long longVar=5;
		System.out.println( longVar);
		
		//initiate a byte variable with value 5
		byte byteVar=5;
		System.out.println( byteVar);
		
		//multiply each of our defined variables by themselves and print them
		System.out.println( doubVar*doubVar);
		System.out.println( floatVar*floatVar);
		System.out.println( intVar*intVar);
		System.out.println(longVar*longVar);
		System.out.println( byteVar*byteVar);
		
		//investigate the System.out.println functions
		System.out.println(doubVar+10);
		System.out.println(doubVar+longVar);
		
		
	}

}
