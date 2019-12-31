package exam1718;

import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) throws Exception {
		AirportDataStore airports = new AirportDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
		FlightDataStore flights = new FlightDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt",airports);
		
		//find all flights from LHR to ATH
		OriginDestinationSelector lhrath = new OriginDestinationSelector("LHR","ATH");
		ArrayList<Flight> flightsArray =flights.getArrayList();
		ArrayList<Flight> LHRATH= lhrath.select(flights);
		//System.out.println(LHRATH);
		
		//find all flights from LHR to ATH under £200
		System.out.println("Flights from LHR to ATH under £200");
		CostLimitSelector lhrathCost = new CostLimitSelector(200);
		ArrayList<Flight> LHRATHCost = lhrathCost.select(LHRATH);
		System.out.println(LHRATHCost);
		
		//find all flights from LHR to ATH under 4 hours
		System.out.println("Flights from LHR to ATH under 4 hours");
		DurationLimitSelector lhrathDuration = new DurationLimitSelector(240);
		ArrayList<Flight> LHRATHDuration = lhrathDuration.select(LHRATH);
		System.out.println(LHRATHDuration);
		
		Flight quickestFlight =lhrathDuration.getQuickestFlight(LHRATHCost);
		System.out.println(quickestFlight);
	}

}
