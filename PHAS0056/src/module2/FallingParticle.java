package module2;

public class FallingParticle {
	
	//introduce our variables
	double m;	//mass, kg
	double d;	//drag coefficient, kg/m
	double t;	//time elapsed since particle was dropped, s
	double z;	//vertical position of the particle, measured upwards from the base of the vessel, m
	double h;	//initial starting height of the particle, measured upwards from the base of the vessel, m
	double v;	//velocity of the particle, measured upwards, m/s
	final double g=-9.81; //acceleration due to gravity, m/s^2
	
	//constructor for the FallingParticle object
	public FallingParticle (double m, double d) {
		this.m=m;
		this.d=d;
	}
	
	//method to set the initial value of height
	public double SetH(double h) {
		return h;
		}
	
	//method to find the updated vertical position  of the particle at a later time t
	public double GetZ(double v,double t,double h) {
		double z=h+v*t+(1/2)*g*t*t;
		return z;
	}
	
	//method to set the intial value for velocity
	public double SetV(double v) {
		return v;
	}
	
	//method to return the updated vertical velocity at a time t
	public double GetV(double v, double t) {
		return v+g*t;
	}
	
	
	//public double GetT(double v,) {
//		return (FallingParticle.GetV(v)-v)/g;
		
	//}
	
	

}
