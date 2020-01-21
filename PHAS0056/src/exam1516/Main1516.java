package exam1516;

public class Main1516 {

	public static void main(String[] args) throws Exception {
		
		SignalStore signalStore= new SignalStore ("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt");
		DetectorStore detectors = new DetectorStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt",signalStore);
		System.out.println(detectors);
		
		//ThresholdArrivalTime oneVolt= new ThresholdArrivalTime(1);
		DetectorThresholdStore detectorThresholds = new DetectorThresholdStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt",signalStore);
		System.out.println(detectorThresholds);
	}

}
