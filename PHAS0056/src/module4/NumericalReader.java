package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	
	public static String getStringFromKeyboard() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type something!");
		
		
		String s =br.readLine();
		System.out.println("You typed: "+s);
		return s;

	}

	
	
	public static void main(String[] args) {
		try {
			 getStringFromKeyboard();
			 //System.out.println("You typed: "+s);
			 }
			 catch (IOException e) {
			 System.out.println("Problem: "+e.getMessage());
			 }
	}

}
