package exam1718;

import java.util.ArrayList;


/**
 * Class selects the flights in an array under a given duration
 * Implements FlightSelector
 * @author pipbe
 *
 */
public class DurationLimitSelector implements FlightSelector {
	long durationLimit;
	Flight quickestFlight;
	Flight cheapestFlight;
	
	/**
	 * Constructs a Flight selector for flights under a certain duration
	 * @param durationLimit maximum duration in minutes
	 */
	public DurationLimitSelector(long durationLimit) {
		this.durationLimit=durationLimit;
	}
	
	
	/**
	 * Selects flights under the cost limit
	 * @param flights an ArrayList of flights
	 * @return selectFlights flights that meet selection criteria
	 */
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
	
	/**
	 * Finds the flight in an array of flights with the shortest duration
	 * @param flights array of flights 
	 * @return quickestFlight flight in array with smallest duration
	 */
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
	
	
	/**
	 * Finds the flight in an array of flights with the lowest cost
	 * @param flights array of flights 
	 * @return quickestFlight flight in array with the lowest cost
	 */
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
