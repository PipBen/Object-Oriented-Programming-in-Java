package midterm1819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class PlayerStore {
	
	ArrayList<Player> players; //arraylist of Player objects
	double totalPlayers; //total number of players
	Player mostRuydsPlayer; //player with most rush yards
	Player mostAPYdsPlayer; //player with most all purpose yards

	
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
			line=br.readLine();
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
		return players.size();
	}
	

	
	
	/**Get player with most rush yards
	 * @return
	 */
	public Player getMostRuydsPlayer() {
		double mostRuyds=0;
		for(int n=0; n<players.size();n++) {
			Player player = players.get(n);
			double ruyds=player.getRuyds();
			if(ruyds>mostRuyds) {
				mostRuydsPlayer=player;
				mostRuyds=player.getRuyds();
			}
		}
		return mostRuydsPlayer;
	}
	
	
	/** Get the player with most all purpose yards
	 * @return
	 */
	public Player getMostAPYdsPlayer() {
		double mostAPYds=0;
		for(int n=0; n<players.size();n++) {
			Player player = players.get(n);
			double ruyds=player.getAPYds();
			if(ruyds>mostAPYds) {
				mostAPYdsPlayer=player;
				mostAPYds=player.getRuyds();
			}
		}
		return mostAPYdsPlayer;
	}


	
	
	

}
