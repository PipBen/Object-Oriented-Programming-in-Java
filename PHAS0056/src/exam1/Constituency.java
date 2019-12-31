package exam1;

import java.util.ArrayList;

//constructor class for electorate data
public class Constituency {
	public final String consid;
	public final String cons;
	public final String county;
	public final int elect;
	
	private ArrayList<MPData> candList = new ArrayList<MPData>();
	
	public Constituency(String consid, String cons, String county, int elect) {
		this.consid=consid;
		this.cons=cons;
		this.county=county;
		this.elect=elect;
	}

	public String toString() {
		
		String data= consid +","+ cons+","+county+","+elect+"\n";
		return data;
	}

}
