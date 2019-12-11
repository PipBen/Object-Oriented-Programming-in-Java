package module9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//import mod9test.AnimationGuiPanel;

public class SolarSystem {

	public static void main(String[] args) {
		/** Create and display JFrame containing animation GUI panel */
		 
			 SwingUtilities.invokeLater(new Runnable() {
				 public void run() {
					JFrame frame = new JFrame("Solar System");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(1000,1050);
					//frame.setVisible(true);
					JPanel panel = new SolarGuiPanel();
					frame.add(panel);
					frame.setVisible(true);
				 }
			 });
		 }

	}


