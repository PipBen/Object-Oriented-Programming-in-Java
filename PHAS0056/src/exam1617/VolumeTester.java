package exam1617;

/**
 * Class implements RecordingTester to test whether a recording is longer than a given duration
 * @author pipbe
 *
 */
public class VolumeTester implements RecordingTester {
	
	
	double maxAmp;
	/**
	 * Input the maximum amplitude to test against
	 * @param maxAmp
	 */
	public VolumeTester(double maxAmp) {
		this.maxAmp=maxAmp;
	}
	
	/**
	 * If theamplitude of the recording is greater than the given maximum, return loud, if not return quiet
	 * @return String result loud or quiet depending on result of the test 
	 */
	public String test(Recording recording) {
		String result;
		double amplitude=recording.getAmplitudeDBFS();
		if (amplitude>maxAmp) {
			result="loud";
		}
		else {
			result="quiet";
		}
		return result;
	}

}
