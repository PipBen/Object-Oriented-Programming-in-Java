package exam2;

import java.util.Comparator;

public class SortByDate implements Comparator<Reading> {
	
	public int compare(Reading a, Reading b) {
		return a.getDate().compareTo(b.getDate());
	}

}
