package exam1718;

import java.util.ArrayList;
/**
 * Class selects the flights in an array with cost under a specific value
 * Implements FlightSelector
 * @author pipbe
 *
 */
public class CostLimitSelector implements FlightSelector{
	
	long costLimit;
	Flight cheapestFlight;
	/**
	 * Constructs a Flight selector for flights under a certain cost
	 * @param costLimit cost limit in pounds
	 */
	public CostLimitSelector(long costLimit) {
		this.costLimit=costLimit;
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
			if(flight.getCost()<costLimit) {
				selectFlights.add(flight);
			}
		}
		return selectFlights;
	}
	
	
	
	
	
}


