package exam2;

public class ExamPart2 {

	public static void main(String[] args) throws Exception {
		
		StationStore stationStore = new StationStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/stations.txt");
		CountryStore countryStore = new CountryStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/countries.txt");
		ReadingStore readingStore = new ReadingStore("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/2019-20/readings.txt",stationStore,countryStore);
		
		
		//i want this to find the mean of the first TMAX reading but that does not seem to be happening
		MeanCalculator mean = new MeanCalculator();
		System.out.println(mean.calculate((readingStore.getTmax().get(1).getMeasurements())));
		

	}

}
