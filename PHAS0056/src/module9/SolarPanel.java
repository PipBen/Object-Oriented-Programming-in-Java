package module9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
public class SolarPanel extends JPanel implements ActionListener {
	private Polygon sun;

	private final int delay = 50;
	private Timer animationTimer;

	SolarPanel(int width, int height, double rotationTime) {
		  setPreferredSize(new Dimension(width,height));
	}
	
	protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  int height = getHeight();
		  int width = getWidth();
		  // Fill in background
		  g.setColor(Color.BLUE);
		  g.fillRect(0, 0, width, height);
		  // Now move origin to centre of panel
		  g.translate(width/2, height/2);
		  // Rotate and draw shape
		  g.setColor(Color.WHITE);
		  Polygon rotatedShape = rotatePolygon(shape, angle);
		  g.fillPolygon(rotatedShape);
	  }
		  
}