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
		//print functions output the calculation inside the brackets
		System.out.println(doubVar+10);
		System.out.println(doubVar+longVar);
		//byte data type cannot handle decimal numbers, hence only the digit is show nin the output
		System.out.println(byteVar/2);
		
		//Variables whose value has not been initialised cannot be used, returns an error
		int j=1; int i=4; j=i+1;
		
		//initialise a double variable with value 4.99
		double doubVar2=4.99;
		//cast double variable to an integer variable
		int intVar2= (int) doubVar2;
		//print cast integer variable, this returns only the digit of the original double variable
		//since int variables are only integers
		System.out.println(intVar2);
	}

}
