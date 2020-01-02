package exam1718;

import java.util.ArrayList;
/**
 * Class selects the flights in an array with a given origin and destination
 * Implements FlightSelector
 * @author pipbe
 *
 */
public class OriginDestinationSelector implements FlightSelector{
	String origin;
	String destination;
	/**
	 * Constructs FlightSelector implementation for flights with a given origin and destination
	 * @param origin airport code
	 * @param destination airport code
	 */
	public OriginDestinationSelector(String origin, String destination) {
		this.origin=origin;
		this.destination=destination;
	}
	
	/**
	 * Selects flights with a given origin and destination
	 * @param flights an ArrayList of flights
	 * @return selectFlights  arraylist of flights that meet selection criteria
	 */
	public ArrayList<Flight> select(ArrayList<Flight> flights){
		ArrayList<Flight> selectFlights = new ArrayList<Flight>();
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if (flight.getOriginAirport().getCode().equals(origin) & flight.getDestinationAirport().getCode().equals(destination)) {
				selectFlights.add(flight);
			}
		}
		return selectFlights;
	}
	

}
