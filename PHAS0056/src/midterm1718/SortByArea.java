package midterm1718;

import java.util.Comparator;

public class SortByArea implements Comparator<Month> {
	
	public int compare(Month a, Month b) {
		return a.getArea().compareTo(b.getArea());
	}

}
