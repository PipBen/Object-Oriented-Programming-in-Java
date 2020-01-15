package midterm1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstituencyStore {
	
	ArrayList<Constituency> constituencies;
	double totalElectorate=0;
	HashMap<String,Constituency> onsConsHash;
	
	public ConstituencyStore(String constituencyURL) throws IOException{
		URL u = new URL(constituencyURL);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line=br.readLine();
		
		this.constituencies= new ArrayList<Constituency>();
		this.onsConsHash = new HashMap<String, Constituency>();
		
		while (line!= null) {
			Constituency constituency = new Constituency(line);
			constituencies.add(constituency);
			this.totalElectorate=this.totalElectorate +constituency.getElectorate();
			this.onsConsHash.put(constituency.getONS(), constituency);
			line= br.readLine();
		}
	}
	
	public double getTotalElectorate() {
		return totalElectorate;
	}

	public ArrayList<Constituency> getConstituencies() {
		return constituencies;
	}

	public void setConstituencies(ArrayList<Constituency> constituencies) {
		this.constituencies = constituencies;
	}
	
	public String toString() {
		return constituencies.toString();
	}
	
	public HashMap<String,Constituency> getONSConsHash() {
		return onsConsHash;
	}
	
	
	
	//WRONG
	public double getLostDeposits(CandidateStore candidateStore) {
		int lostDeposists=0;
		ArrayList<Candidate> candidates =candidateStore.getCandidates();
		for(int n=0; n<candidates.size();n++) {
			Candidate candidate = candidates.get(n);
			String candidateONS= candidate.getOns();
			Constituency constituency= onsConsHash.get(candidateONS);
			if(candidate.getVotes()<constituency);
		}
	}
	//WRONG

}
