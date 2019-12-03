package module8;

public class CountdownTask implements Runnable{
	private int seconds ;//number of seconds to run the countdown for
	
	public CountdownTask(int seconds) {
		this.seconds=seconds;
	}
	//prints to the console a countdown clock from the specified number of seconds
	public void run() {
		//initial time
		long startTime = System.currentTimeMillis();
		//comparison time
		long compTime=startTime;
		int count=0;//number of elapsed seconds since the loop started
		while (count<=seconds) {
			//reset time for each loop
			compTime=System.currentTimeMillis();
			long difference = compTime-startTime;//time elapsed since start of loop
			if (difference>=count*1000){
				System.out.println(seconds-count);	
				count=count+1;
			}
		}
		return;
	}			

}
