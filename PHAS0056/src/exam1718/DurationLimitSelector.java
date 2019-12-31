package exam1718;

import java.util.ArrayList;

public class DurationLimitSelector implements FlightSelector {
	long durationLimit;
	Flight quickestFlight;
	Flight cheapestFlight;
	public DurationLimitSelector(long durationLimit) {
		this.durationLimit=durationLimit;
	}
	
	public ArrayList<Flight> select(ArrayList<Flight> flights){
		ArrayList<Flight> selectFlights= new ArrayList<Flight>();
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if(flight.getDuration()<durationLimit) {
				selectFlights.add(flight);
			}
		}
		return selectFlights;
	}
	
	public Flight getQuickestFlight(ArrayList<Flight> flights) {
	
		double quickestTime=1000000000;
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if(flight.getDuration()<quickestTime) {
				quickestTime=flight.getDuration();
				quickestFlight= flight;
			}
		}
		return quickestFlight;
	}
	
	public Flight getCheapestFlight(ArrayList<Flight> flights) {
		
		double lowestCost=1000000000;
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if(flight.getCost()<lowestCost) {
				lowestCost=flight.getDuration();
				cheapestFlight= flight;
			}
		}
		return cheapestFlight;
	}
}
