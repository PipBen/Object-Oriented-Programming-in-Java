package exam1718;

import java.util.ArrayList;

/**
 * Interface to create a subset of flights from a larger array
 * @author pipbe
 *
 */
public interface FlightSelector {
	/**
	 * selects flights according to the implementation 
	 * @param flights array of flights to create subset of
	 * @return subset of flights
	 */
	public ArrayList<Flight> select(ArrayList<Flight> flights);
}
