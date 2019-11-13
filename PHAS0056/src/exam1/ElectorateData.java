package exam1;

//constructor class for electorate data
public class ElectorateData {
	String consid;
	String cons;
	String county;
	String elect;
	
	public ElectorateData(String consid, String cons, String county, String elect) {
		this.consid=consid;
		this.cons=cons;
		this.county=county;
		this.elect=elect;
	}

	public String toString() {
		
		String data= consid +","+ cons+","+county+","+elect;
		return data;
	}

}