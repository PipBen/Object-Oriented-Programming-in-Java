package midterm1819;

import java.util.Scanner;

public class Player {
	
	String name;
	String team;
	String pos;
	double games;
	double att;
	double ruyds;
	double rutd;
	double tgt;
	double rec;
	double reyds;
	double retd;
	double fmb;
	
	
	public Player(String line) {
		Scanner s = new Scanner(line).useDelimiter("\t");
		this.name=s.next();
		this.team=s.next();
		this.pos=s.next();
		this.games=s.nextDouble();
		this.att=s.nextDouble();
		this.ruyds=s.nextDouble();
		this.rutd=s.nextDouble();
		this.tgt=s.nextDouble();
		this.rec=s.nextDouble();
		this.reyds=s.nextDouble();
		this.retd=s.nextDouble();
		this.fmb=s.nextDouble();
		s.close();
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}


	/**
	 * @return the pos
	 */
	public String getPos() {
		return pos;
	}


	/**
	 * @return the games
	 */
	public double getGames() {
		return games;
	}


	/**
	 * @return the att
	 */
	public double getAtt() {
		return att;
	}


	/**
	 * @return the ruyds
	 */
	public double getRuyds() {
		return ruyds;
	}


	/**
	 * @return the rutd
	 */
	public double getRutd() {
		return rutd;
	}


	/**
	 * @return the tgt
	 */
	public double getTgt() {
		return tgt;
	}


	/**
	 * @return the rec
	 */
	public double getRec() {
		return rec;
	}


	/**
	 * @return the reyds
	 */
	public double getReyds() {
		return reyds;
	}


	/**
	 * @return the retd
	 */
	public double getRetd() {
		return retd;
	}


	/**
	 * @return the fmb
	 */
	public double getFmb() {
		return fmb;
	}

	public double getAPYds() {
		return ruyds+reyds;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", team=" + team + ", pos=" + pos + ", games=" + games + ", att=" + att
				+ ", ruyds=" + ruyds + ", rutd=" + rutd + ", tgt=" + tgt + ", rec=" + rec + ", reyds=" + reyds
				+ ", retd=" + retd + ", fmb=" + fmb + "]";
	}

}
