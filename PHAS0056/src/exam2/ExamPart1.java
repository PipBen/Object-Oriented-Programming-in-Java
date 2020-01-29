package exam2;

import java.util.ArrayList;
import java.util.Collections;

public class ExamPart1 {
	
	public static void main(String[] args) throws Exception{
		StationStore stationStore = new StationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/stations.txt");
		CountryStore countryStore = new CountryStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/countries.txt");
		ReadingStore readingStore = new ReadingStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/readings.txt",stationStore,countryStore);
		System.out.println("Total number of unique stations in readings.txt: "  +readingStore.getTotalStations());
		System.out.println("Total number of TMAX readings: "+ readingStore.getTmaxReadings().size());
		System.out.println("Total number of TMIN readings: "+ readingStore.getTminReadings().size());
		System.out.println("Total number of PRCP readings: "+ readingStore.getPrcpReadings().size());
		System.out.println("Total number of SNWD readings: "+ readingStore.getSnwdReadings().size());
		ArrayList<Reading> readings = readingStore.getReadingData();
		ArrayList<Reading> tmaxReadings = readingStore.getTmaxReadings();
		ArrayList<Reading> tminReadings = readingStore.getTminReadings();
		Collections.sort(tmaxReadings, new SortByDate());
		System.out.println("Earliest TMAX Reading:" +tmaxReadings.get(0));
		System.out.println("Latest TMAX Reading:" +tmaxReadings.get(tmaxReadings.size()-1));
		Collections.sort(tmaxReadings, new SortByMaxValue());
		System.out.println("Highest TMAX Value: "+tmaxReadings.get(tmaxReadings.size()-1));
		System.out.println("Lowest TMAX Value: "+tmaxReadings.get(0));
		System.out.println("Highest TMIN Value: "+tminReadings.get(tminReadings.size()-1));
		System.out.println("Lowest TMIN Value: "+tminReadings.get(0));
		
	}

}
