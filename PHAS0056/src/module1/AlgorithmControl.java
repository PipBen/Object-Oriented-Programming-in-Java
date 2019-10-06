package module1;

public class AlgorithmControl {
	
	//create a method to implement a for loop to print integers 1 to 8
	public void loop() {
	//create a for loop to print the numbers 1 to 8
			for (int n=1;n<9;n=n+1){
				System.out.println(n);
				}
	}
			
	//create a method to implement a while loop to print decreasing integers from 10 to -5
	public void decrement() {
		int n=10;
		while(n>-6) {
			System.out.println(n);
			n=n-1;
		}
		}
	
	// create a method to implement a for loop to print the numbers from 2.5 to 4.3 increasing in steps of 0.1
	public void increment() {
		for(double n=2.5;n<4.35;n=n+0.1) {
			//format to 1dp to avoid unnecessary decimal places
			System.out.println(String.format("%.1f", n));
		}
	}
	
	
	//create a method to create a timer that will last for 'maxTime' number of milliseconds
	public int timer(long maxTime, int loopSteps) {
		
		//set time at start of loop
		long timeNow = System.currentTimeMillis();
		//initial time
		long timeA=timeNow;
		//time to be updated each loop
		long timeB=timeNow;
		
		
		//initialise an integer to represent the total number of completed loops
		int n=0;
	
		//while loop compares the time at the start of the loop to current time
		while (timeB-timeA<maxTime) {
			//reset time for each loop
			timeB=System.currentTimeMillis();
			//add one completed loop
			n=n+1;
			//set up if statement to print the number of iterations of the loop every 'loopSteps' number of steps
			if (n % loopSteps ==0){
				System.out.println(n);	
			}
		}
	
	System.out.println("The total number of loops was " + n);	
	
	return n;
	
	}
	
		
		
		
public static void main(String[] args) {
	AlgorithmControl ac = new AlgorithmControl();
	//call loop, decrement and increment methods
	ac.loop();
	ac.decrement();
	ac.increment();
	//assign a variable to the total number of loops when the number of loops of the timer method is printed every 1000, and 50000 loops
	//the below can be commented out to show the loop, decrement and increment methods on the console.
	long end1= ac.timer(10000,1000);
	long end2 = ac.timer(10000,50000);
	System.out.println("when the timer method output the number of loops every 1000 loops, there were "+ end1 +" loops");
	System.out.println("when the timer method output the number of loops every 50,000 loops, there were "+end2+" loops");
	System.out.println("\nThe timer method loops almost twice as many times when the number of loops is printed every 50,000 loops as opposed to every"
			+ "\n"+ "1000 loops. This is because when the method has to print the number of loops more often, more time is spent on the 'if' statement, where the action"
			+ "\nof printing the current number of loops when the condition of the 'if' statement is satisfied takes time, so fewer full loops are able to take place.");
	//
	}

}


