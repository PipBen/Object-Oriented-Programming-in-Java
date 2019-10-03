package module1;

public class AlgorithmControl {
	
	//create a method to implement a for loop to print integers 1 to 8
	public static void loop() {
	//create a for loop to print the numbers 1 to 8
			for (int n=1;n<9;n=n+1){
				System.out.println(n);
				}
	}
			
	//create a method to implement a while loop to print decreasing integers from 10 to -5
	public static void decrement() {
		int n=10;
		while(n>-6) {
			System.out.println(n);
			n=n-1;
		}
		}
	
	// create a method to implement a for loop to print the numbers from 2.5 to 4.3 increasing in steps of 0.1
	public static void increment() {
		for(double n=2.5;n<4.35;n=n+0.1) {
			//format to 1dp to avoid unnecessary decimal places
			System.out.println(String.format("%.1f", n));
		}
	}
	
	//create a method to create a timer that will last for 5 seconds
	public static int timer(long maxTime, int loopSteps) {
		//set time at start of loop
		long timeNow = System.currentTimeMillis();
		long timeA=timeNow;
		long timeB=timeNow;
		
		
		
		//int totalLoops = timer(long maxTime, int loopSteps);
		
		//initialise an integer to represent the total number of completed loops
		int n=0;
	
		
		while (timeB-timeA<maxTime) {
			//reset time for each loop
			timeB=System.currentTimeMillis();
			//add one completed loop
			n=n+1;
			//set up if statement to print the number of iterations of the loop every 100 loops
			if (n % loopSteps ==0){
				System.out.println(n);	
			}
		}
	return n;
	System.out.println("The total number of loops for this timer was", n );
	}
	
		
		
		
		

		
		
	
	

	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		ac.loop();
		ac.decrement();
		ac.increment();
		//System.out.println(System.currentTimeMillis());
		//long timeNow = System.currentTimeMillis();
		//int n = 500;
		//long iremainder=timeNow % n;
		//System.out.println(iremainder);
		ac.timer(10000,1000);
	}

}


