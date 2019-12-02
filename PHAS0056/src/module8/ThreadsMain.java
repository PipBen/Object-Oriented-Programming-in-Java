package module8;

public class ThreadsMain {

	public static void main(String[] args) throws InterruptedException {
		CountdownTask five = new CountdownTask(10);
		Thread countdown = new Thread(five);
		
		PrimeNumberTask prime = new PrimeNumberTask();
		Thread primeThread =new Thread(prime);
		
		primeThread.start();
		countdown.start();
		
		countdown.join();
		primeThread.interrupt();

	}

}
