package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public MPData(String line) {
		
		Scanner s= new Scanner(line);
		//comma delimiter for csv
		s.useDelimiter(","); 
		this.pano=s.next();
		this.cons=s.next();
		this.sur=s.next();
		this.first=s.next();
		this.party=s.next();
		this.pid=s.next(); 
		this.votes=s.next();
		s.close();
	}
	
	public static BufferedReader brFromFile(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	
	}
	
	public static void readCandidateData(ArrayList<MPData> constituencies,BufferedReader br) throws IOException {
		String line = br.readLine();
		while (line != null) {
			MPData candidate = new MPData(line);
			constituencies.add(candidate);
		}
	}
	
	public String toString() {
		String data= first +" "+sur+", "+party+" candidate for "+cons+", Votes: "+votes+"\n";
		return data;
	}

	public String getOns() {
		return ons;
	}

	public void setOns(String ons) {
		this.ons = ons;
	}

	public String getPano() {
		return pano;
	}

	public void setPano(String pano) {
		this.pano = pano;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	public String getSur() {
		return sur;
	}

	public void setSur(String sur) {
		this.sur = sur;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}
	
}
