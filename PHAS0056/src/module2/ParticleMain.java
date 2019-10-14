package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//create a new instance of the FallingParticle object
		FallingParticle FP=new FallingParticle(4.3,2.4);
		
		//reset height and initial veclocity each time
		FP.SetH(5);
		FP.SetV(0);
		FP.drop(0.5);
		System.out.println("When the time interval is 0.5s,the time taken for the particle to hit "
				+ "\nthe bottom of the container is "+FP.GetT()+"s at velocity "+ FP.GetV()+"m/s");

		FP.SetH(5);
		FP.SetV(0);
		FP.drop(0.1);
		System.out.println("\nWhen the time interval is 0.1s,the time taken for the particle to hit "
				+ "\nthe bottom of the container is "+FP.GetT()+"s at velocity "+ FP.GetV()+"m/s");
		
		FP.SetH(5);
		FP.SetV(0);
		FP.drop(0.01);
		System.out.println("\nWhen the time interval is 0.01s,the time taken for the particle to hit "
				+ "\nthe bottom of the container is "+FP.GetT()+"s at velocity "+ FP.GetV()+"m/s");
		
		FP.SetH(5);
		FP.SetV(0);
		FP.drop(0.001);
		System.out.println("\nWhen the time interval is 0.001s,the time taken for the particle to hit "
				+ "\nthe bottom of the container is "+FP.GetT()+"s at velocity "+ FP.GetV()+"m/s");
		
		FP.SetH(5);
		FP.SetV(0);
		FP.drop(0.0001);
		System.out.println("\nWhen the time interval is 0.0001s,the time taken for the particle to hit "
				+ "\nthe bottom of the container is "+FP.GetT()+"s at velocity "+ FP.GetV()+"m/s");
	
		System.out.println("\nAs the time interval between each step decreases, we can see that the total"
				+ " \ntime taken increases, while the final velocity converges on a value. We can see that"
				+ " \nhaving a smaller time interval increases the precission of our result. The increasing time "
				+ "\nvalue is likely due to the innaccuracy of our method, which requires that v is increased "
				+ "\nmore often when the value for deltaT is small.");
	}
	
	

}
