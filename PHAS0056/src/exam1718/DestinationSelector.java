package exam1718;

import java.util.ArrayList;

/**
 * Class selects the flights in an array with a given destination
 * Implements FlightSelector
 * @author pipbe
 *
 */
public class DestinationSelector implements FlightSelector{
	String destination;
	
	
	/**
	 * Constructs FlightSelector implementation for flights with a given destination
	 * @param destination destination airport
	 */
	public DestinationSelector(String destination) {
		this.destination=destination;
	}
	
	/**
	 * Selects flights with a given destination
	 * @param flights an ArrayList of flights
	 * @return selectFlights flights that meet selection criteria
	 */
	public ArrayList<Flight> select(ArrayList<Flight> flights){
		ArrayList<Flight> selectFlights = new ArrayList<Flight>();
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if (flight.getDestinationAirport().getCode().equals(destination)) {
				selectFlights.add(flight);
			}
		}
		return selectFlights;
	}
}
