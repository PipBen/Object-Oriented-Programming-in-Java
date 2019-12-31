package exam1718;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Scanner;

public class Flight {
	String flightCode;
	String originCode;
	Airport originAirport;
	Airport destinationAirport;
	String destCode;
	String depDate;
	String depTime;
	String arrivalDate;
	String arrivalTime;
	double cost;
	double duration;
	//AirportDataStore airports = new AirportDataStor

	
	
	public Flight(String line, AirportDataStore airports) {
		Scanner s= new Scanner(line);
		s.useDelimiter(", ");
		this.flightCode= s.next();
		this.originCode=s.next();
		this.destCode=s.next();
		this.depDate=s.next();
		this.depTime=s.next();
		this.arrivalDate=s.next();
		this.arrivalTime=s.next();
		this.cost=s.nextDouble();
		s.close();
		for (int n=0; n<airports.getSize();n++) {
			Airport airport= airports.getIndex(n);
			if (airport.getCode().equals(originCode)) {
				this.originAirport=airport;
			}
			if(airport.getCode().equals(destCode)) {
				this.destinationAirport=airport;
			}
		}
		this.duration=getDuration();
//		this.originFullName= codeFullNameHash.get(originCode);
//		this.destinationFullName= codeFullNameHash.get(destCode);
		
	}
	
	public String getFlightCode() {
		return flightCode;
	}
	public String getOriginCode() {
		return originCode;
	}
	public String getDestCode() {
		return destCode;
	}
	public String getDepDate() {
		return depDate;
	}
	public String getDepTime() {
		return depTime;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public double getCost() {
		return cost;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	

	
	public long getDuration(){
		LocalDateTime lt1 = LocalDateTime.parse(depDate+"T"+depTime);
		String timeZone1 =originAirport.getTimeZone();
		ZoneId z1 = ZoneId.of(timeZone1);
		ZonedDateTime zt1 = ZonedDateTime.of(lt1, z1);
		LocalDateTime lt2 = LocalDateTime.parse(arrivalDate+"T"+arrivalTime);
		String timeZone2 =destinationAirport.getTimeZone();
		ZoneId z2 = ZoneId.of(timeZone2);
		ZonedDateTime zt2 = ZonedDateTime.of(lt2, z2);
		long duration = zt1.until(zt2, ChronoUnit.MINUTES);
		return duration;
	}
	
	
	
	public double getCombinedCost(Flight b) {
		double combinedCost=cost+b.getCost();
		return combinedCost;
	}
	
	public double getCombinedDuration( Flight b) {
		double combinedDuration= duration+b.getDuration();
		return combinedDuration;
	}
	
	
	
	
	public String toString() {
		String flight  =flightCode+", "+originAirport.getFullName()+", "+destinationAirport.getFullName()+", Departure:"
				+depDate+":"+depTime+", Arrival:"+arrivalDate+":"+arrivalTime+", Duration: "
				+Long.toString(getDuration())+" minutes"+ ", Cost: £"+ Double.toString(cost)+"\n";
		return flight;
	}

	


}
