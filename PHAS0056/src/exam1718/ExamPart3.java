package exam1718;

import java.util.ArrayList;

public class ExamPart3 {
	
	//public Flight chepeastInitialFlight;
	//Flight cheapestDestinationFLight;

	public static void main(String[] args) throws Exception{
		
		AirportDataStore airports = new AirportDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/airports.txt");
		FlightDataStore flights = new FlightDataStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2017-18/flights.txt",airports);
		ArrayList<Flight> flightsArray =flights.getArrayList();
		
		//find all direct flights LHR to CPT
		OriginDestinationSelector LHRtoCPT = new OriginDestinationSelector("LHR","CPT");
		ArrayList<Flight> LHRtoCPTArray= LHRtoCPT.select(flightsArray);

		//find all direct flights under 24 hours
		DurationLimitSelector LHRtoCPTUnder24 = new DurationLimitSelector(24*60);
		ArrayList<Flight> LHRtoCPTUnder24Array= LHRtoCPTUnder24.select(LHRtoCPTArray);
		System.out.println("Direct flights LHR to CPT under 24 hours"+LHRtoCPTUnder24Array);
		Flight cheapestDirect= LHRtoCPTUnder24.getCheapestFlight(LHRtoCPTUnder24Array);
		
		//find all flights departing from LHR
		OriginSelector originLHR = new OriginSelector("LHR");
		ArrayList<Flight> originLHRArray=originLHR.select(flightsArray);
		
		//find all flights arriving at CPT
		DestinationSelector destinationCPT = new DestinationSelector("CPT");
		ArrayList<Flight> destinationCPTArray = destinationCPT.select(flightsArray);
		
		//find cheapest stopover flight between these LHR and CPT
		CheapestStopover cheapestStopover= new CheapestStopover(originLHRArray,destinationCPTArray) ;
		System.out.println(cheapestStopover);
		double stopoverCost= cheapestStopover.getTotalCost();
		double stopoverDuration= cheapestStopover.getTotalDuration();
		
		
		//if the cost of the cheapest stopover flight is less than the direct flight, print flights
		if(stopoverCost<cheapestDirect.getCost()) {
			System.out.println("The Cheapest route from LHR to CPT is"+ cheapestStopover);
		}
		else {
			System.out.println("The Cheapest route from LHR to CPT is"+ cheapestDirect); 
		}
		System.out.println(stopoverCost);
		System.out.println(cheapestDirect.getCost());
		
				

	}

}
