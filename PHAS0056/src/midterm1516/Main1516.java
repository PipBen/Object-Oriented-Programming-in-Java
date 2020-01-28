package midterm1516;

public class Main1516 {

	public static void main(String[] args) throws Exception{
		EarthquakeStore earthquakeStore = new EarthquakeStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt");
		//System.out.println(earthquakeStore);
		System.out.println("Total no. earthquakes: "+ earthquakeStore.getEarthquakes().size());
		System.out.println("Maximum Magnitude Earthquake: "+earthquakeStore.getLargestMagnitude());
	}

}
