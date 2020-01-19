package midterm1920;

import java.util.Comparator;

public class SortByTurnout implements Comparator<Constituency>{
	
	@Override
	public int compare(Constituency a, Constituency b) {
		return Double.valueOf(a.getTurnout()).compareTo(Double.valueOf(b.getTurnout()));
	}
}
