package midterm1920;

import java.util.Scanner;

/** Generates data point representing a candidate
 * @author zcappbe
 *
 */
public class Candidate {
	
	String ons;
	int pano;
	String consName;
	String surname;
	String firstName;
	String party;
	String partyID;
	double votes;
	
	/** Takes a bufferedreader line and unpacks data into candidate object
	 * @param line
	 */
	public Candidate(String line){
		Scanner s= new Scanner(line);
		s.useDelimiter(",");
		this.ons=s.next();
		this.pano=s.nextInt();
		this.consName=s.next();
		this.surname=s.next();
		this.firstName=s.next();
		this.party=s.next();
		this.partyID=s.next();
		this.votes=s.nextDouble();
		s.close();
	}

	/**
	 * @return the ons
	 */
	public String getOns() {
		return ons;
	}

	/**
	 * @return the pano
	 */
	public int getPano() {
		return pano;
	}

	/**
	 * @return the consName
	 */
	public String getConsName() {
		return consName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}

	/**
	 * @return the partyID
	 */
	public String getPartyID() {
		return partyID;
	}

	/**
	 * @return the votes
	 */
	public double getVotes() {
		return votes;
	}

	/**
	 * @param ons the ons to set
	 */
	public void setOns(String ons) {
		this.ons = ons;
	}

	/**
	 * @param pano the pano to set
	 */
	public void setPano(int pano) {
		this.pano = pano;
	}

	/**
	 * @param consName the consName to set
	 */
	public void setConsName(String consName) {
		this.consName = consName;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}

	/**
	 * @param partyID the partyID to set
	 */
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(double votes) {
		this.votes = votes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return surname + ", " + firstName + ", party=" + party +", votes: " + votes + "]\n";
	}
		
	

}
