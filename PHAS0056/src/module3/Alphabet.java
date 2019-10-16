package module3;
//import necessary packages
import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;


public class Alphabet {
	
	//method to return a random character
	public static char randomCharacter() {
		Random random = new Random();
		//random integer
		int c= random.nextInt(127);
		//convert integer to a character
		return (char) c ;
	}
	
	
	public static void main(String[] args) {
		//create a string to which we can append
		StringBuilder newstring =new StringBuilder();
		double n=0;//number of loops
		long total=0; //total value of characters in the string
		int exceptions=0; //number of exceptions
		//400 loops
		while(n<=400) {
			//find a random characater
			char c=randomCharacter();
			//if the character is in the alphabet or a digit, append it to the string
			if(Character.isAlphabetic(c)==true || Character.isDigit(c)==true) {
				newstring.append(c);
				
				//if we are able to convert the character to a number, add it to the total
				//if not add 1 to the number of exceptions
				try {
					total=total +Integer.parseInt(Character.toString(c));
				}
				catch(Exception e) {
					exceptions=exceptions+1;
				}
			}
			n=n+1;
		}
	System.out.println("Our complete string: "+newstring);
	System.out.println("The total value of the characters in the string is "+total);
	System.out.println("The total number of exceptions was "+exceptions);	
	
			
		}

	

}
