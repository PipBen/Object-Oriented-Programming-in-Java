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
	
	public static void timer() {
		long timeNow = System.currentTimeMillis();
		int n=1;
		long iremainder=timeNow % n;
		
		while (timeNow<5001) {
			
			n=n+1;
		}
		
		
		
	
	}
	
		
		
		
		

		
		
	
	

	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		ac.loop();
		ac.decrement();
		ac.increment();
		System.out.println(System.currentTimeMillis());
		long timeNow = System.currentTimeMillis();
		int n = 500;
		long iremainder=timeNow % n;
		System.out.println(iremainder);
	}

}


