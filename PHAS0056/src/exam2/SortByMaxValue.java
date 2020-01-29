package exam2;

import java.util.Collections;
import java.util.Comparator;

/**Compares Readings by their maximum value
 * @author zcappbe
 *
 */
public class SortByMaxValue implements Comparator<Reading>{
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Reading a, Reading b) {
		return Collections.max(a.getReadings()).compareTo(Collections.max(b.getReadings()));
	}

}
