package exam1718;

import java.util.ArrayList;

public class CostLimitSelector implements FlightSelector{
	
	long costLimit;
	Flight cheapestFlight;
	public CostLimitSelector(long costLimit) {
		this.costLimit=costLimit;
	}
	
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


