package module2;

public class ParticleMain {

	public static void main(String[] args) {
		FallingParticle FP=new FallingParticle(4.3,2.4);
		FP.SetH(5);
		FP.SetV(2);
		FP.drop(0.1);
		System.out.println(FP.GetT());
		System.out.println(FP.GetV());

	}

}
