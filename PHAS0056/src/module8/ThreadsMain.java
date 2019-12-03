package module8;

public class ThreadsMain {

	public static void main(String[] args) throws InterruptedException {
		//new instances of CountdownTask and PrimeNumberTask classes, and threads for each of them to run on
		CountdownTask five = new CountdownTask(10);
		Thread countdown = new Thread(five);
		
		PrimeNumberTask prime = new PrimeNumberTask();
		Thread primeThread =new Thread(prime);
		
		//both threads begin execution
		primeThread.start();
		countdown.start();
		//wait for countdown thread to die
		countdown.join();
		//interrupts the prime number thread when the countdown thread has completed
		primeThread.interrupt();
	}
}
