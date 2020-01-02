package exam1617;

/**
 * Class implements RecordingTester to classify the spectral density of a recording
 * @author pipbe
 *
 */
public class SpecDensTester implements RecordingTester {
	
	final double low=40;
	final double medium=100;
	final double high=1000;
	String result;
	
	/**
	 * Constructor for SpecDensTester
	 */
	public SpecDensTester() {}
	
	/**
	 * Calculate the spectral density of a sample at a given frequency 
	 * @param samples Array of amplitudes of a recording
	 * @param t duration of recording
	 * @param f frequency of sampling
	 * @return spectral density at given frequency for the recording
	 */
	private double spectralDensity(double [] samples, double t, double f) {
		int bigN = samples.length;
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
		sumCos += samples[n]* Math.cos(z*n);
		sumSin += samples[n]* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
		}
	
	/**
	 * Tests whether the spectral density of the recording is greatest at a 'high', medium or low frequency
	 * return result high, medium or low depending on at which frequency the spectral density is greatest
	 */
	public String test(Recording recording) {
		double[] samples=recording.getAmplitudes();
		double t=recording.getDuration();
		//double f= recording.getFrequency();
		double lowSpecDens=spectralDensity(samples,t,low);
		double mediumSpecDens = spectralDensity(samples,t,medium);
		double highSpecDens = spectralDensity(samples,t,high);
		//String result;
		if(highSpecDens>mediumSpecDens&highSpecDens>lowSpecDens) {
			result="high";
		}
		if(mediumSpecDens>highSpecDens&mediumSpecDens>lowSpecDens) {
			result="medium";
		}
		if(lowSpecDens>highSpecDens&lowSpecDens>mediumSpecDens) {
			result="low";
		}
		return result;
	}
}
