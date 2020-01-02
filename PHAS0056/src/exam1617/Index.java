package exam1617;

import java.util.Scanner;

/**
 * Class representing the index of a recording
 * @author pipbe
 *
 */
public class Index {
	String fileName; //name of recording
	String instrument; //instrument that made the sound
	
	/**
	 * Create an Index object from a line from file
	 * @param line from BufferedReader
	 */
	public Index(String line) {
		Scanner s= new Scanner(line);
		s.useDelimiter(" ");
		this.fileName=s.next();
		this.instrument=s.next();
		s.close();
	}

	public String getFileName() {
		return fileName;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	
	
}
