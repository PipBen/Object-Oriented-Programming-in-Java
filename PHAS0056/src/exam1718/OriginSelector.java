package exam1718;

import java.util.ArrayList;

/**
 * Class selects the flights in an array with a given origin
 * Implements FlightSelector
 * @author pipbe
 *
 */
class OriginSelector implements FlightSelector {
	String origin;
	
	/**
	 * Constructs FlightSelector implementation for flights with a given destination
	 * @param origin airport code
	 */
	public OriginSelector(String origin) {
		this.origin=origin;
	}
	
	
	/**
	 * Selects flights with a given origin
	 * @param flights an ArrayList of flights
	 * @return selectFlights flights that meet selection criteria
	 */
	public ArrayList<Flight> select(ArrayList<Flight> flights){
		ArrayList<Flight> selectFlights = new ArrayList<Flight>();
		for(int n=0; n<flights.size();n++) {
			Flight flight = flights.get(n);
			if (flight.getOriginAirport().getCode().equals(origin)) {
				selectFlights.add(flight);
			}
		}
		return selectFlights;
	}
	
}
