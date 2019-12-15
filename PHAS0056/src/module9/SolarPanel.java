package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * JPanel containing a central disc representing the sun
 * with further discs representing planets orbiting the
 * sun disc with realistic planet sizes, distances from the sun
 * and orbital speeds. 
 */
public class SolarPanel extends JPanel implements ActionListener {
	
	private Ellipse2D sun;
	private Ellipse2D earth;
	private Ellipse2D mercury;
	private Ellipse2D venus;
	private Ellipse2D mars;
	private Ellipse2D comet;
	
	private final int delay = 50; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double earthAngle = 0.0; // current angle of each planet on screen
	private double mercuryAngle =0.0;
	private double venusAngle = 0.0;
	private double marsAngle= 0.0;
	private double cometAngle= 0.0;
	private Timer animationTimer; // timer controlling frame rate
	int noYears=0; //number of times earth has orbitted the sun
	double compareAngle=earthAngle;
	String years =new String("Earth Years: 0");

	/**Panel containing sun and multiple planets in a line
	 * that will orbit at different speeds relative to the earth
	 * @param width width of panel
	 * @param height height of panel
	 * @param orbitTime time for complete orbit [seconds]
	 */
	SolarPanel(int width, int height,double orbitTime){
		setPreferredSize(new Dimension(width,height));
		//create yellow disk to represent sun in the centre
		sun = new Ellipse2D.Double(-50,-50,100,100);
		//set distance of Earth from Sun and diameter of Earth, each other planet has correct distance and diameter 
		//relative to Earth according to data from NASA
		double earthDist=300;
		double earthDiam=30;
		mercury= new Ellipse2D.Double(0.387*earthDist,0.387*earthDist,0.383*earthDiam,0.383*earthDiam);
		venus = new Ellipse2D.Double(0.723*earthDist,0.723*earthDist,0.949*earthDiam,0.949*earthDiam);
		earth = new Ellipse2D.Double(earthDist,earthDist,earthDiam,earthDiam);
		mars = new Ellipse2D.Double(1.52*earthDist,1.52*earthDist,0.532*earthDiam,0.532*earthDiam);
		comet = new Ellipse2D.Double(2*earthDist,0.5*earthDist,0.2*earthDiam,0.2*earthDiam);
	
		delta = 2*Math.PI*delay/(orbitTime*1000);
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	
	
	/**New position of planet in orbit
	 * 
	 * @param planet
	 * @param angle
	 * @return newPlanet
	 */
	private static Ellipse2D planetOrbit(Ellipse2D planet, double angle) {
		//width and height of planet reamins the same
		double height =planet.getHeight();
		double width= planet.getWidth();
		//change coordinates of planet
		double x = planet.getX()*Math.cos(angle);
		double y = planet.getY()*Math.sin(angle);
		Ellipse2D newPlanet = new Ellipse2D.Double(x,y,width,height);	   
		return newPlanet;
	}
	/**paint each planet at the appropriate angle*/
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Rotate and draw sun
		Graphics2D sunG= (Graphics2D) g;
		sunG.setColor(Color.YELLOW);
		sunG.fill(sun);
		//new Graphics2D object for each planet to set colour and orbit speed
		Graphics2D earthG= (Graphics2D) g;
		earthG.setColor(Color.BLUE);
		Ellipse2D earthOrbit = planetOrbit(earth, earthAngle);
		earthG.fill(earthOrbit);
		
		//set colour and size of text
		Font f = new Font("Arial",Font.BOLD,50);
		g.setColor(Color.WHITE);
		g.setFont(f);
		//update the string representing the number of Earth years elapsed
		if ((2*Math.PI-compareAngle)<0) {
			compareAngle=0;
			noYears++;
			years =new String("Earth Years: "+noYears);
			
		}
		g.drawString(years,-width/2,height/3);
	 
		Graphics2D mercuryG = (Graphics2D) g;
		mercuryG.setColor(Color.WHITE);
		Ellipse2D mercuryOrbit = planetOrbit(mercury, mercuryAngle);
		mercuryG.fill(mercuryOrbit);
		  
		Graphics2D venusG = (Graphics2D) g;
		venusG.setColor(Color.ORANGE);
		Ellipse2D venusOrbit = planetOrbit(venus, venusAngle);
		mercuryG.fill(venusOrbit);
		  
		Graphics2D marsG = (Graphics2D) g;
		marsG.setColor(Color.RED);
		Ellipse2D marsOrbit = planetOrbit(mars, marsAngle);
		marsG.fill(marsOrbit);
		  
		Graphics2D cometG = (Graphics2D) g;
		cometG.setColor(Color.GRAY);
		Ellipse2D cometOrbit = planetOrbit(comet, cometAngle);
		marsG.fill(cometOrbit);
	  }
	
	/**repaints each planet at its new angle*/
	public void actionPerformed(ActionEvent event) {
		
		mercuryAngle += 1.59*delta;
		venusAngle += 1.18*delta;
		earthAngle += delta;
		compareAngle+=delta;
		marsAngle += 0.808*delta;
		cometAngle +=3*delta;
		  
		repaint();
	}
	
	/** Start the animation */
	   public void start() {animationTimer.start();}
	   /** Stop the animation */
	   public void stop() {animationTimer.stop();}
	
}