package module4;
import java.io.*;
import java.net.*;
import java.util.*;
public class WordCounter {
	
	//Takes the name of a URL as argument and returns a BufferedReader object.
	public static BufferedReader brFromURL(String urlName) throws IOException {
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	//takes the name of a file on the disk as argument and returns a BufferedReader object.
	public static BufferedReader brFromFile(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	//reads through the data contained in the BufferedReader object dataAsBR and then returns the number of words in the corresponding resource.
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		Scanner s = new Scanner(dataAsBR);
		int n=0;
		while(s.hasNext()) {
			n=n+1;
			s.next();
		}
		s.close();
		return n;
	}
	
	//main method
	public static void main(String[] args) {
		//call brFromURL and countWordsInResource to count the total number of words in the BufferedReader
		try {
			BufferedReader from_url =  brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			int word_count= countWordsInResource(from_url);
			System.out.println("The total word count is "+word_count);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}
