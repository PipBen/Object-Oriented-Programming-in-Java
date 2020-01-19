package midterm1920;

import java.util.Comparator;

public class SortByVotes implements Comparator<Candidate>{
	
	@Override
	public int compare(Candidate a, Candidate b) {
		return Double.valueOf(a.getVotes()).compareTo(Double.valueOf(b.getVotes()));
	}

}
