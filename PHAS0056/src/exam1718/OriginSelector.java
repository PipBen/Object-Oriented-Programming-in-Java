package exam1718;

import java.util.ArrayList;

public class OriginSelector implements FlightSelector {
	String origin;
	
	
	public OriginSelector(String origin) {
		this.origin=origin;
	}
	
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
