package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
public class SolarPanel extends JPanel implements ActionListener {
	private Ellipse2D sun;
	private final int delay = 50; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate
	

	
	//private Polygon shape; // shape to be displayed

	SolarPanel(int width, int height,double rotationTime){
		setPreferredSize(new Dimension(width,height));
		sun = new Ellipse2D.Double(0,0,20,20);
		//sun = new Polygon2D.Double(xpts,ypts,100);
		//delta = 2*Math.PI*delay/(rotationTime*1000);
		delta = 2*Math.PI*delay/(rotationTime*100);
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	
	
//	/**New position of planet
//	 * 
//	 * @param poly
//	 * @param angle
//	 * @return
//	 */
//	private static Ellipse2D planetOrbit(Ellipse2D poly, double angle) {
//		   Ellipse2D newPoly = new Ellipse2D.Double(100,100,0,0);
////		   for (int i = 0; i < poly.npoints; i++) {
////		   double x = poly.xpoints[i]*Math.cos(angle)+
////		   poly.ypoints[i]*Math.sin(angle);
////		   double y = poly.ypoints[i]*Math.cos(angle)-
////		   poly.xpoints[i]*Math.sin(angle);
//		   //newPoly.addPoint((int) x, (int) y);
//		   
//		   return newPoly;
//		   }
	
	protected void paintComponent(Graphics g) {
		  Graphics2D g2d= (Graphics2D) g;
		  super.paintComponent(g);
		  super.paintComponent(g2d);
		  int height = getHeight();
		  int width = getWidth();
		  // Fill in background
		  g.setColor(Color.BLACK);
		  g.fillRect(0, 0, width, height);
		  // Now move origin to centre of panel
		  g.translate(width/2, height/2);
		  // Rotate and draw shape
		  g2d.setColor(Color.YELLOW);
		  g2d.fill(sun);
		  //Polygon rotatedShape = planetOrbit(sun, angle);
		  //g.fillPolygon(rotatedShape);
	  }
	
	public void actionPerformed(ActionEvent event) {
		   angle += delta;
		   repaint();
		   }
	
	/** Start the animation */
	   public void start() {animationTimer.start();}
	   /** Stop the animation */
	   public void stop() {animationTimer.stop();}
	
}