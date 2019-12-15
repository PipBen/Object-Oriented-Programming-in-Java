package module9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Solar system panel with start, stop and exit buttons.
 */
public class SolarSystem {

	public static void main(String[] args) {
		/** Create and display JFrame containing solar animation GUI panel */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Solar System");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000,1050);
				JPanel panel = new SolarGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
				 }
			 });
		 }

	}


