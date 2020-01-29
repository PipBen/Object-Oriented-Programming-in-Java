package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ReadingStore {
	
	ArrayList<Reading> readingData;
	ArrayList<Reading> tmaxReadings= new ArrayList<Reading>();
	ArrayList<Reading> tminReadings= new ArrayList<Reading>();
	ArrayList<Reading> prcpReadings=new ArrayList<Reading>();
	ArrayList<Reading> snwdReadings=new ArrayList<Reading>();
	
	ArrayList<SNWDMeasurements> snwd = new ArrayList<SNWDMeasurements>();
	ArrayList<PRCPMeasurements> prcp = new ArrayList<PRCPMeasurements>();
	ArrayList<TMAXMeasurements> tmax = new ArrayList<TMAXMeasurements>();
	ArrayList<TMINMeasurements> tmin = new ArrayList<TMINMeasurements>();
	Reading earliestTMAX;
	Reading latestTMAX;
	
	
	/** Storage class for Reading objects, unpacks into relevent datatype storage objects
	 * @param urlName file url
	 * @param stationStore
	 * @param countryStore
	 * @throws IOException
	 */
	public ReadingStore(String urlName, StationStore stationStore, CountryStore countryStore) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line=br.readLine();
		this.readingData= new ArrayList<Reading>();
		
		while(line!=null) {
			Reading reading = new Reading(line,stationStore,countryStore);
			if(reading.getReadings()!=null) {
				readingData.add(reading);
				
				
				//unpack into objects depending on the dta type
				if(reading.getType().equals("SNWD")) {
					snwdReadings.add(reading);
					SNWDMeasurements snwdNew= new SNWDMeasurements(reading.getReadings());
					snwd.add(snwdNew);
				}
				
				if(reading.getType().equals("PRCP")) {
					prcpReadings.add(reading);
					PRCPMeasurements prcpNew= new PRCPMeasurements(reading.getReadings());
					prcp.add(prcpNew);
				}
				
				if(reading.getType().equals("TMIN")) {
					tminReadings.add(reading);
					TMINMeasurements tminNew= new TMINMeasurements(reading.getReadings());
					tmin.add(tminNew);
				}
				
				if(reading.getType().equals("TMAX")) {
					tmaxReadings.add(reading);
					TMAXMeasurements tmaxNew= new TMAXMeasurements(reading.getReadings());
					tmax.add(tmaxNew);
				}
				
				line= br.readLine();
			}
			
			
		}
	}
	
	public String toString(){
		return readingData.toString();
	}

	/**
	 * @return the readingData
	 */
	public ArrayList<Reading> getReadingData() {
		return readingData;
	}

	/**
	 * @param readingData the readingData to set
	 */
	public void setReadingData(ArrayList<Reading> readingData) {
		this.readingData = readingData;
	}
	
	public int getTotalStations() {
		ArrayList<String> uniqueIDs= new ArrayList<String>();
		Reading firstReading =readingData.get(0);
		String firstID= firstReading.getId();
		uniqueIDs.add(firstID);
		for(int n=0; n<readingData.size();n++) {
			Reading reading = readingData.get(n);
			if(uniqueIDs.contains(reading.getId())==false) {
				uniqueIDs.add(reading.getId());
			}
		}
		return uniqueIDs.size();
	}

	/**
	 * @return the tmaxReadings
	 */
	public ArrayList<Reading> getTmaxReadings() {
		return tmaxReadings;
	}

	/**
	 * @return the tminReadings
	 */
	public ArrayList<Reading> getTminReadings() {
		return tminReadings;
	}

	/**
	 * @return the prcpReadings
	 */
	public ArrayList<Reading> getPrcpReadings() {
		return prcpReadings;
	}

	/**
	 * @return the snwdReadings
	 */
	public ArrayList<Reading> getSnwdReadings() {
		return snwdReadings;
	}

	/**
	 * @param tmaxReadings the tmaxReadings to set
	 */
	public void setTmaxReadings(ArrayList<Reading> tmaxReadings) {
		this.tmaxReadings = tmaxReadings;
	}

	/**
	 * @param tminReadings the tminReadings to set
	 */
	public void setTminReadings(ArrayList<Reading> tminReadings) {
		this.tminReadings = tminReadings;
	}

	/**
	 * @param prcpReadings the prcpReadings to set
	 */
	public void setPrcpReadings(ArrayList<Reading> prcpReadings) {
		this.prcpReadings = prcpReadings;
	}

	/**
	 * @param snwdReadings the snwdReadings to set
	 */
	public void setSnwdReadings(ArrayList<Reading> snwdReadings) {
		this.snwdReadings = snwdReadings;
	}

	/**
	 * @return the snwd
	 */
	public ArrayList<SNWDMeasurements> getSnwd() {
		return snwd;
	}

	/**
	 * @return the prcp
	 */
	public ArrayList<PRCPMeasurements> getPrcp() {
		return prcp;
	}

	/**
	 * @return the tmax
	 */
	public ArrayList<TMAXMeasurements> getTmax() {
		return tmax;
	}

	/**
	 * @return the tmin
	 */
	public ArrayList<TMINMeasurements> getTmin() {
		return tmin;
	}

	/**
	 * @return the earliestTMAX
	 */
	public Reading getEarliestTMAX() {
		return earliestTMAX;
	}

	/**
	 * @return the latestTMAX
	 */
	public Reading getLatestTMAX() {
		return latestTMAX;
	}

	/**
	 * @param snwd the snwd to set
	 */
	public void setSnwd(ArrayList<SNWDMeasurements> snwd) {
		this.snwd = snwd;
	}

	/**
	 * @param prcp the prcp to set
	 */
	public void setPrcp(ArrayList<PRCPMeasurements> prcp) {
		this.prcp = prcp;
	}

	/**
	 * @param tmax the tmax to set
	 */
	public void setTmax(ArrayList<TMAXMeasurements> tmax) {
		this.tmax = tmax;
	}

	/**
	 * @param tmin the tmin to set
	 */
	public void setTmin(ArrayList<TMINMeasurements> tmin) {
		this.tmin = tmin;
	}

	/**
	 * @param earliestTMAX the earliestTMAX to set
	 */
	public void setEarliestTMAX(Reading earliestTMAX) {
		this.earliestTMAX = earliestTMAX;
	}

	/**
	 * @param latestTMAX the latestTMAX to set
	 */
	public void setLatestTMAX(Reading latestTMAX) {
		this.latestTMAX = latestTMAX;
	}
	
//	public ArrayList<Reading> earliestLatestTMAX(){
//		int earliestYear=2000;
//		int latestYear=1900;
//		ArrayList<Reading> earliestYearTMAX= new ArrayList<Reading>();
//		ArrayList<Reading> latestYearTMAX= new ArrayList<Reading>();
//		for(int n=0; n<tmaxReadings.size();n++) {
//			Reading reading = tmaxReadings.get(n);
//			if(reading.getYear()<=earliestYear) {
//				earliestTMAX= reading;
//				earliestYear=reading.getYear();
//			}
//			if(reading.getYear()>=latestYear) {
//				latestTMAX = reading;
//				latestYear= reading.getYear();
//			}
//		}
//		
//		
//	}
	
	
	

	
	
	
	

}
