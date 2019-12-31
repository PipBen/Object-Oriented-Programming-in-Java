package exam1718;

import java.util.ArrayList;

public class DestinationSelector {
	String destination;
	
	public DestinationSelector(String destination) {
		this.destination=destination;
	}
	
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
