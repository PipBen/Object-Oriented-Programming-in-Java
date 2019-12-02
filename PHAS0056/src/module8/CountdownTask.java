package module8;

public class CountdownTask implements Runnable{
	private int seconds ;
	
	public CountdownTask(int seconds) {
		this.seconds=seconds;
	}
	
	public void run() {
		//set time at start of loop
		long timeNow = System.currentTimeMillis();
		//initial time
		long timeA=timeNow;
		long timeB=timeNow;
		int count=0;
		while (count<=seconds) {
			//reset time for each loop
			timeB=System.currentTimeMillis();
			long difference = timeB-timeA;
			if (difference>=count*1000){
				System.out.println(seconds-count);	
				count=count+1;
			}
		}
		return;
	}			
	
	
	public static void main(String[] args) {
		CountdownTask five = new CountdownTask(10);
		Thread countdown = new Thread(five);
		countdown.start();
	}
}
