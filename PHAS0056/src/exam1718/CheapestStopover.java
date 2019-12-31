package exam1718;

import java.util.ArrayList;

public class CheapestStopover {
	ArrayList<Flight> cheapestStopover;
	double totalCost;
	double totalDuration;
	double combinedCost;
	
	CheapestStopover(ArrayList<Flight> originLHRArray, ArrayList<Flight> destinationCPTArray){
		this.cheapestStopover = new ArrayList<Flight>();
		//Flight cheapestInitialFLight;
		for(int n=0; n<originLHRArray.size();n++) {
			Flight originFlight = originLHRArray.get(n);
			double minCost=1000000;
			for(int i=0; i<destinationCPTArray.size();i++) {
				Flight destinationFlight = destinationCPTArray.get(i);
				if(originFlight.getDestCode().equals(destinationFlight.getOriginCode())) {
					this.combinedCost= originFlight.getCombinedCost(destinationFlight);
					this.totalDuration=originFlight.getCombinedDuration(destinationFlight);
					if(totalDuration<(24*60) & combinedCost<minCost) {
						totalCost=combinedCost;
						//stopoverFlightArray.add(e)
						//Flight cheapestInitialFlight=originFlight;
						//Flight cheapestDestinationFlight=destinationFlight;
						this.cheapestStopover.clear();
						this.cheapestStopover.add(originFlight);
						this.cheapestStopover.add(destinationFlight);
						
						
					}
					
				}
			}
			
		}
	}
	
	
	
	public String toString() {
		return cheapestStopover.toString();
	}



	public double getTotalCost() {
		return totalCost;
	}


	public double getTotalDuration() {
		return totalDuration;
	}

}
