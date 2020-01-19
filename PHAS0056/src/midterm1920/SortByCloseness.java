package midterm1920;

import java.util.Comparator;

public class SortByCloseness implements Comparator<Constituency>{
	
	
	@Override
	public int compare(Constituency a, Constituency b) {
		return Double.valueOf(a.getCloseness()).compareTo(Double.valueOf(b.getCloseness()));
	}
}
