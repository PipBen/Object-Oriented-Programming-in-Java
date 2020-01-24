package midterm1819;

public class MidTermExam {

	public static void main(String[] args) throws Exception{
		PlayerStore playerStore = new PlayerStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt");
		TeamStore teamStore = new TeamStore(playerStore);
		System.out.println("Total number of players: "+playerStore.getTotalPlayers());
		System.out.println("Player with most Rush Yards: "+ playerStore.getMostRuydsPlayer());
		System.out.println("Player with most Rush Yards: "+ playerStore.getMostAPYdsPlayer());
		
		System.out.println(teamStore.getTeams());
	}

}
