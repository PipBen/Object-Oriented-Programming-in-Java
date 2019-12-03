package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) throws Exception {
		//estimate pi using one thread
		long oneStartTime= System.currentTimeMillis();
		long nPoints= 10000000;
		MonteCarloPiCalculatorTask oneThread = new MonteCarloPiCalculatorTask(nPoints);
		double pi =oneThread.call();
		System.out.println("Esitmate of pi using a single thread: "+pi);
		long oneEndTime=System.currentTimeMillis();
		long oneDifference= oneEndTime-oneStartTime;//time to complete thread
		System.out.println("time taken to estimate pi using one thread: "+oneDifference+"ms");
		
		//estimate pi using four parallel threads
		long fourStartTime= System.currentTimeMillis();
		int nThreads=4;
		//create a new pool of threads
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		//future class represents the result of each parallel calculation
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		//iterate the pi calculator method on each thread for a quarter of the total number of points
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new
			MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;//sum the results of the parallel threads
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi4 = sum/nThreads;
		System.out.println("Esitmate of pi using a single thread: "+pi4);
		//find time taken to estimate pi using 4 threads
		long fourEndTime= System.currentTimeMillis();
		long fourDifference= fourEndTime-fourStartTime;
		System.out.println("time taken to estimate pi using 4 parallel threads: "+fourDifference+"ms");
		System.out.println("\nWe can see that the method using 4 parrallel threads to estimate pi takes approximately half the\n"
				+ "time that the method using one thread takes. Though this initially appears to be a significant time saving,\n"
				+ "it's noticable that the code required to use the four parallel threads is significantly more complicated than\n"
				+ "the method using only one thread. This complexity could likely lead to errors and bugs which are difficult to detect\n"
				+ "in a more complex project. For this reason it is arguable that the simplicity and readability of the method using\n"
				+ "only one thread outweighs the benefits of obtaining a result slightly faster using parallel threads, suggesting\n"
				+ "parallel threads should only be used where there is a clear functional benefit in doing so.");
	}
}
