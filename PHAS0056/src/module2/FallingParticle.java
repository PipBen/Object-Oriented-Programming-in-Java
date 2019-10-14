package module2;

public class FallingParticle {
	
	//introduce our variables
	double m;	//mass, kg
	double d;	//drag coefficient, kg/m
	static double t=0;	//time elapsed since particle was dropped, s
	double z;	//vertical position of the particle, measured upwards from the base of the vessel, m
	double h;	//initial starting height of the particle, measured upwards from the base of the vessel, m
	double v;	//velocity of the particle, measured upwards, m/s
	final double g=9.81; //acceleration due to gravity, m/s^2
	
	//constructor for the FallingParticle object
	public FallingParticle (double m, double d) {
		this.m=m;
		this.d=d;
	}
	
	//method to set the initial value of height
	public void SetH(double h_val) {
		h=h_val;
		}
	
	//method to find the updated vertical position  of the particle at a later time t
	public double GetZ() {
		//double z=h+v*t+(1/2)*g*t*t;
		return z;
	}
	
	//method to set the intial value for velocity
	public void SetV(double u_val) {
		v=u_val;
	}
	
	//method to return the updated vertical velocity at a time t
	public double GetV() {
		return v;
	}
	
	//method to return the time since the particle was released
	public double GetT() {
		return t ;
				//=(-v+Math.sqrt(v*v+2*g*(h-z)))/g;
	}
	
	//method to calculate the acceleration of the particle in its current state, and update its velocity and position
	public void doTimeStep(double deltaT) {
		double a = ((d*v*v)/m) - g;
		v= v+a*deltaT;
		z= z+a*deltaT;
		//return a;
		//return new_v,new_z;
	}
	
	public void drop(double deltaT) {
		z=h;
		while(z>0) {
			doTimeStep(deltaT);
			t=t+deltaT;
		}
		
	}
	

}
