package exam1617;

/**Interface to classify a recording according to a specific test
 * 
 * @author pipbe
 *
 */
public interface RecordingTester {
	
	/**
	 * tests the recording
	 * @param recording
	 * @return String the result of the test
	 */
	public	String test(Recording recording);
}
