package module1;

public class DataTypes {

	public static void main(String[] args) {
	   
		//Assign a double variable with the value 5.0
		double doubVar=5.0;
		System.out.println( "doubVar= " +doubVar);
		
		//Assign a float variable with value 5.0
		float floatVar=5;
		System.out.println("floatVar= "+ floatVar);
		
		//Assign a integer variable with value 5
		int intVar=5;
		System.out.println("intVar= "+ intVar);
		
		//Assign a long variable with value 5
		long longVar=5;
		System.out.println("longVar= "+ longVar);
		
		//Assign a byte variable with value 5
		byte byteVar=5;
		System.out.println("byteVar= "+ byteVar);
		
		//multiply each of our defined variables by themselves and print them
		System.out.println("doubVar x doubVar= "+ doubVar*doubVar);
		System.out.println("floatVar x floatVar= "+ floatVar*floatVar);
		System.out.println("intVar x intVar= "+ intVar*intVar);
		System.out.println("longVar x longVar= "+longVar*longVar);
		System.out.println("byteVar x byteVar= "+ byteVar*byteVar);
		
		//investigate what happens when we mix different data types
		
		char charVar = 'c'+10;
		System.out.println("\ncharVar ="+ charVar);
		System.out.println("Adding 10 to the charv variable 'c', we can see that 'c' is assigned the value 3. Ten letters after 'c' in the alphabet"
				+ "\nis 'm,' which explains the output of the character 'm.'");
		
		
		System.out.println("\nbyteVar/2 ="+ byteVar/2);
		System.out.println("Since byteVar=5, we can see that when it is divided by 2, we get 2 rather than 2.5. This is because the byte date type can "
				+ "\nonly take on integer values, so only the integer of the value 2.5 is printed.");
		
		
		System.out.println("\n(floatVar x intVar)/3 = "+(floatVar*intVar)/3);
		System.out.println("(floatVar x doubVar)/3 = "+(floatVar*doubVar)/3);
		System.out.println("(intVar x intVar)/3 = "+(intVar*intVar)/3);
		System.out.println("Here we investigate the effect that having different data types in the numerator has on the result of a fraction. Including a double"
				+ "\nvariable results in many more decimal places being printed, due to the increased accuracy of the double variable over the float variable."
				+ "\nIn the division of the integer variables we get only an integer as the result as expected. Multiplying a decimal value by an integer"
				+ "\nmaintains the decimal in any further calculations");
		
	
		
		//Variables whose value has not been initialised cannot be used, returns an error
		int j=1; int i=4; j=i+1;
		
		
		//initialise a double variable with value 4.99
		double doubVar2=4.99;
		//cast double variable to an integer variable
		int intVar2= (int) doubVar2;
		//print cast integer variable, this returns only the digit of the original double variable
		//since int variables are only integers
		System.out.println("\n"+intVar2);
		System.out.println("Casting a double variable to an integer only preserves the integers, and anything after the decimal point is lost.");
	}

}
