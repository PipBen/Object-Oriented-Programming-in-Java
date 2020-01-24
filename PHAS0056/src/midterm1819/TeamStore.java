package midterm1819;

import java.util.ArrayList;

public class TeamStore {
	
	ArrayList<Team> teams= new ArrayList<Team>();
	ArrayList<Player> teamPlayers;
	ArrayList<String> teamNames= new ArrayList<String>();
	
	public TeamStore(PlayerStore playerStore) {
		ArrayList<Player> players = playerStore.getPlayers();
		for(int n=0;n<players.size();n++) {
			String teamName=players.get(n).getTeam();
			if(teamNames.contains(teamName)==false) {
				teamNames.add(teamName);
				teamPlayers = new ArrayList<Player>();
				for(int m=0;m<players.size();m++) {
					
					if(players.get(m).getTeam().equals(teamName)) {
						Player player= players.get(m);
						teamPlayers.add(player);
					}
				}
			
			Team team = new Team(teamPlayers);
			team.setTeamName(teamName);
			teams.add(team);	
			}
			
		
		}
		
	}
	
	public ArrayList<Team> getTeams(){
		return teams;
	}
	
	public ArrayList<String> getTeamNames(){
		return teamNames;
	}
	
	
//	if(player.getTeam().equals(teamName)){
//	teamPlayers.add(player);
//}
//else {
//	Team team = new Team(teamPlayers);
//	//System.out.println(team);
//	this.allTeams.add(team);
//	teamName=player.getTeam();
//	teamPlayers.clear();
//	teamPlayers.add(player);
//}
	
//	URL u = new URL(urlName);
//	InputStream is = u.openStream();
//	InputStreamReader isr = new InputStreamReader(is);
//	BufferedReader br = new BufferedReader(isr);
//	br.readLine();
//	br.readLine();
//	br.readLine();
//	String line=br.readLine();
//	Player firstPlayer= new Player(line);
//	String teamName=firstPlayer.getTeam();
//	ArrayList<Player> teamPlayers = new ArrayList<Player>();
//	this.teams= new ArrayList<Team>();
//	while (line!= null) {
//		Player player= new Player(line);
//		if(player.getTeam().equals(teamName)) {
//			teamPlayers.add(player);
//		}
//		else {
//			Team team= new Team(teamPlayers);
//			teams.add(team);
//			teamPlayers.clear();
//			teamPlayers.add(player);
//			teamName=player.getTeam();
//		}
//		line = br.readLine();
//	}

}
