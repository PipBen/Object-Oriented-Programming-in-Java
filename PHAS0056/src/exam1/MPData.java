package exam1;

//constructor class for data for each candidate
public class MPData {
	String ons;
	String pano;
	String cons;
	String sur;
	String first; 
	String party; 
	String pid; 
	String votes;
	
	public MPData(String ons, String pano, String cons, String sur, String first, String party, String pid, String votes) {
		this.ons=ons;
		this.pano=pano;
		this.cons=cons;
		this.sur=sur;
		this.first=first;
		this.party=party;
		this.pid=pid;
		this.votes=votes;
				
	}
	
	public String toString() {
		
		String data= ons +","+ pano+","+cons+","+sur+","+first+","+party+","+ pid+","+ votes;
	
		return data;
	}
	
}
