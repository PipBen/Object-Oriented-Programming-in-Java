package exam1718;

public class ExamPart1 {

	public static void main(String[] args) throws Exception {
		AirportDataStore airports = new AirportDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
		FlightDataStore flights = new FlightDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt",airports);
		
		System.out.println(flights);
	}

}
