package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args)throws Exception {
		long nPoints= 10000000;
		MonteCarloPiCalculatorTask oneThread = new MonteCarloPiCalculatorTask(nPoints);
		double pi =oneThread.call();
		System.out.println(pi);
		
		int nThreads=4;
		
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new
			MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi4 = sum/nThreads;
		System.out.println(pi4);
		}
}
