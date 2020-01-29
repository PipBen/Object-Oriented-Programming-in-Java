package exam2;

import java.util.Collections;
import java.util.Comparator;

public class SortByMaxValue implements Comparator<Reading>{
	
	public int compare(Reading a, Reading b) {
		return Collections.max(a.getReadings()).compareTo(Collections.max(b.getReadings()));
	}

}
