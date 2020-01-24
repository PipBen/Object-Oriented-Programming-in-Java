package midterm1819;

import java.util.ArrayList;

public class Team {
	
	String teamName;
	ArrayList<Player> playersList;
	Player greatestLiabilityPlayer;
	Player worstButterFingers;
	
	public Team(ArrayList<Player> players) {
		this.teamName= players.get(0).getTeam();
		this.playersList=players;
	}

	
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TEAM=" + teamName + ":\nNumber of players with more than ten touches: "+getMoreThanTen().size()+ 
				", Greatest Liability: " +getGreatestLiabilityName()+", Worst Butter Fingers: "+ getButterFingersName()+"\n\n";
	}


	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	/**
	 * @return the playersList
	 */
	public ArrayList<Player> getPlayersList() {
		return playersList;
	}


	/**
	 * @param playersList the playersList to set
	 */
	public void setPlayersList(ArrayList<Player> playersList) {
		this.playersList = playersList;
	}
	
	
	public ArrayList<Player> getMoreThanTen() {
		ArrayList<Player> moreThanTen = new ArrayList<Player>();
		for(int n=0; n<playersList.size();n++) {
			Player player= playersList.get(n);
			if(player.getAtt()+player.getTgt()>10) {
				moreThanTen.add(player);
			}
		}
		return moreThanTen;
	}
	
	public String getGreatestLiabilityName() {
		double greatestLiability=0;
		for(int n=0; n<playersList.size();n++) {
			Player player= playersList.get(n);
			double liability=(player.getRuyds()+player.getReyds())/(player.getAtt()+player.getTgt());
			if (liability>greatestLiability) {
				greatestLiabilityPlayer=player;
				greatestLiability=liability;
			}
		}
		return greatestLiabilityPlayer.getName();
	}
	
	public String getButterFingersName() {
		double maxButtFin=0;
		ArrayList<Player> players =getMoreThanTen();
		for(int n=0; n<players.size();n++) {
			Player player= players.get(n);
			double buttFin= ((player.getTgt()-player.getRec())+player.getFmb())/(player.getTgt()+player.getAtt());
			if (buttFin>maxButtFin) {
				worstButterFingers=player;
				maxButtFin=buttFin;
			}
		}
		return worstButterFingers.getName();
	}
	


}
