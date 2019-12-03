package module8;

import java.util.ArrayList;
//
public class PrimeNumberTask implements Runnable {
	
	public PrimeNumberTask() {
		}
	//finds prime numbers until the thread is interrupted 
	public void run() {
		ArrayList<Integer> primes = new ArrayList<Integer>();//arraylist to add our prime numbers to
		int n=2; //start at 2 as our method would return 0 and 1 as prime numbers
		double m=n/2;//only need consider numbers less than or equal to half the value being considered
		int div=1;//find remainder when n is divided by div
		while(true) {
			//test whether the thread has been interrupted
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("total number of prime numbers found is "+primes.size());
				System.out.println("largest prime number found is "+primes.get(primes.size()-1));
				return;
			}
			int flag=0;//indicator variable for non-prime n
			for(div=2;div<=m;div++){      
				if(n%div==0){      
					flag=1;
					break;
				    } 
				}
			if(flag==0) {
				primes.add(n);//add n to primes is not indicated as non-prime
			}
			n++;
			m=n/2;
		}  
	}
}


