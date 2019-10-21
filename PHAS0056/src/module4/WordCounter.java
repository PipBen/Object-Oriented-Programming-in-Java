package module4;
import java.io.*;
import java.net.*;
import java.util.*;
public class WordCounter {
	
	//URL u = new URL(urlName);
	//InputStrem is = u.openStream;
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
		
		}
	
	public static BufferedReader brFromFile(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
		}
	
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		Scanner s = new Scanner(dataAsBR);
		int n=0;
		while(s.hasNext()) {
			
			n=n+1;
			s.next();
			//System.out.println(n);
		}
		s.close();
		return n;
	}
	

	public static void main(String[] args) {
		try {
			BufferedReader from_url =  brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			int word_count= countWordsInResource(from_url);
			System.out.println(word_count);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}
