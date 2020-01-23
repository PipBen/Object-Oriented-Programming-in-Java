package midterm1819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class PlayerStore {
	
	ArrayList<Player> players;
	double totalPlayers;
	
	/**Unpacks player data from url into lines from which objects can be created
	 * @param urlName
	 * @throws IOException
	 */
	public PlayerStore(String urlName) throws IOException{
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		br.readLine();
		br.readLine();
		String line=br.readLine();
		this.players= new ArrayList<Player>();
		while (line!= null) {
			Player player= new Player(line);
			players.add(player);
		}
		totalPlayers=players.size();
	}

	
	
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @return the totalPlayers
	 */
	public double getTotalPlayers() {
		return totalPlayers;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @param totalPlayers the totalPlayers to set
	 */
	public void setTotalPlayers(double totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

}
