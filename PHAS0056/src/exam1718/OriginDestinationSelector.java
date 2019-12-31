package exam1718;

import java.util.ArrayList;

public class OriginDestinationSelector implements FlightSelector{
	String origin;
	String destination;
	public OriginDestinationSelector(String origin, String destination) {
		this.origin=origin;
		this.destination=destination;
	}
	
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
