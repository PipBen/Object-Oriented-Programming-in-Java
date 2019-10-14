package module3;

public class FallingParticle {
	
	//introduce our variables
	double m;	//mass, kg
	double d;	//drag coefficient, kg/m
	static double t=0;	//time elapsed since particle was dropped, s, always starts at zero so static
	double z;	//vertical position of the particle, measured upwards from the base of the vessel, m
	double h;	//initial starting height of the particle, measured upwards from the base of the vessel, m
	double v;	//velocity of the particle, measured upwards, m/s
	final double g=9.81; //acceleration due to gravity, m/s^2, final since this value will never change
	
	//constructor for the FallingParticle object
	public FallingParticle (double m, double d) throws Exception {
		if (m<0 && d<0) {
			throw new Exception("negative mass and negative drag are unphysical");
		}
		if(m<0) {
			throw new Exception("negative mass is unphysical");
		}
		if(d<0) {
			throw new Exception("negative drag is unphysical");
		}
		this.m=m;
		this.d=d;
	}
	
	//method to set the initial value of height
	public void SetH(double h_val) {
		h=h_val;
		}
	
	//method to find the updated vertical position  of the particle at a later time t
	public double GetZ()throws Exception {
		if(z<0) {
			throw new Exception("negative height is unphysical");
		}
		return z;
	}
	
	//method to set the initial value for velocity
	public void SetV(double u_val) {
		v=u_val;
	}
	
	//method to return the updated vertical velocity at a time t
	public double GetV() {
		return v;
	}
	
	//method to return the time since the particle was released
	public double GetT()throws Exception {
		if(t<0) {
			throw new Exception("negative time is unphysical");
		}
		return t ;
				
	}
	
	//method to calculate the acceleration of the particle in its current state, and update its velocity and position
	public void doTimeStep(double deltaT) {
		double a = ((d*v*v)/m) - g;
		if(a>0.01 || a<-0.01) {
			v= v+a*deltaT;
			z= z+a*deltaT;
		}
		//in the case a=0 (terminal velocity)
		else {
			z=z+v*deltaT;
		}
	}
	//method to simulate the falling particle in steps of deltaT
	public void drop(double deltaT) throws Exception {
		if(deltaT<0) {
			throw new Exception("negative timestep is unphysical");
		} 
		z=h;
		while(z>0) {
			doTimeStep(deltaT);
			t=t+deltaT;
		}
		
	}
	

}
