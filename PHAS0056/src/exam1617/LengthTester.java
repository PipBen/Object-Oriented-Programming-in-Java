package exam1617;

/**
 * Implements RecordingTester to test if a recording is longer than a given length
 * @author pipbe
 *
 */
public class LengthTester implements RecordingTester{
	
	double length;
	/**
	 * Test whether recording is greater than given length in seconds
	 * @param length
	 */
	public LengthTester(double length) {
		this.length=length;
	}
	
	/**
	 * Test given recording for its length, return long if greater than given length, short otherwise
	 * @return String long or shor
	 */
	public String test(Recording recording) {
		String result;
		double duration=recording.getDuration();
		if (duration>length) {
			result="long";
		}
		else {
			result="short";
		}
		return result;
	}
}
