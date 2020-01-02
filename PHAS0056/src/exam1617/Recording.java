package exam1617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
/** Class containing data representing a recording
 * 
 * @author pipbe
 *
 */
public class Recording {

	double frequency;
	int noSamples;
	double maxAmp;
	String fileName;
	String instrument;
	double duration;
	double amplitudeDBFS;
	double[] amplitudes;
	
	/**
	 * Read recording data from file and store in an object
	 * @param urlName url to read from
	 * @param indexStore storage object for recording index
	 * @throws IOException
	 */
	public Recording(String urlName, IndexStore indexStore) throws IOException {
		this.fileName=urlName.replace("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/", "");
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Scan over first line to get initial data
		String firstLine=br.readLine();
		Scanner firstScanner= new Scanner(firstLine);
		firstScanner.useDelimiter(" ");
		this.frequency=firstScanner.nextDouble();
		this.noSamples=firstScanner.nextInt();
		this.maxAmp=firstScanner.nextDouble();
		firstScanner.close();
		ArrayList<Index> indices= indexStore.getIndices();
		
		for(Index index: indices) {		
			if(this.fileName.equals(index.getFileName())) {
			this.instrument= index.getInstrument();
			}
		}
		//Scan over rest of file to obtain amplitude data
		String line=br.readLine();
		int n=0;
		double[] setAmplitudes=new double[noSamples];
		while(line!=null) {
			setAmplitudes[n]=Double.valueOf(line);
			line= br.readLine();
			n++;
		}
		this.amplitudes=setAmplitudes;
	}
	
	/**
	 * toString override method
	 */
	public String toString() {
		String kHz= Double.toString(frequency/1000);
		String sampleString =Integer.toString(noSamples);
		String maxAmpString= Double.toString(maxAmp);
		return fileName+" Duration= "+ Double.toString(getDuration())+"s, Amplitude: "+Double.toString(getAmplitudeDBFS())+" Instrument: "+instrument;
	}

	public double getFrequency() {
		return frequency;
	}

	public long getNoSamples() {
		return noSamples;
	}

	public double getMaxAmp() {
		return maxAmp;
	}

	public double[] getAmplitudes() {
		return amplitudes;
	}
	
	public double getDuration() {
		return noSamples/frequency;
	}
	
	/**
	 * Get the root mean squared of the amplitudes
	 * @return rootMeanSquare 
	 */
	public double getRMSAmp() {
		double [] amplitudes= getAmplitudes();
		double squareTotal=0;
		for(Double amplitude: amplitudes) {
			squareTotal=squareTotal+(amplitude*amplitude);
		}
		double meanSquare= squareTotal/getNoSamples();
		double rootMeanSquare= Math.sqrt(meanSquare);
		return rootMeanSquare;
	}
	
	/**
	 * Get the overall amplitude of the recording in dbFS
	 * @return amplitude dBFS
	 */
	public double getAmplitudeDBFS() {
		double rmsAmp =getRMSAmp();
		double maxAmp = getMaxAmp();
		double amplitudeDBFS= 20*Math.log10(rmsAmp/maxAmp);
		return amplitudeDBFS;
	}
	
	public String getInstrument() {
		return instrument;
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public void setNoSamples(int noSamples) {
		this.noSamples = noSamples;
	}

	public void setMaxAmp(long maxAmp) {
		this.maxAmp = maxAmp;
	}

	public void setAmplitudes(double[] amplitudes) {
		this.amplitudes = amplitudes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
