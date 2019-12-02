package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {
	
	public PrimeNumberTask() {
		}
	
	public void run() {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int n=2;
		double m=n/2;
		int div=1;
		while(true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("total number of prime numbers found is "+primes.size());
				System.out.println("largest prime number found is "+primes.get(primes.size()-1));
				return;
			}
			int flag=0;
			for(div=2;div<=m;div++){      
				if(n%div==0){      
					//System.out.println(n+" is not prime number");
					flag=1;
					break;
				    } 
				}
			if(flag==0) {
				primes.add(n);
				//System.out.println(n+" is a prime number");
			}
			n++;
			m=n/2;
		}  
	}
	
	public static void main(String[] args) {
		PrimeNumberTask prime = new PrimeNumberTask();
		Thread primeThread =new Thread(prime);
		primeThread.start();
	}
}


