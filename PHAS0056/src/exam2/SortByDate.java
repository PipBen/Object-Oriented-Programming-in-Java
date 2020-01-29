package exam2;

import java.util.Comparator;

/**Compares Readings by their date 
 * @author zcappbe
 *
 */
public class SortByDate implements Comparator<Reading> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Reading a, Reading b) {
		return a.getDate().compareTo(b.getDate());
	}

}
