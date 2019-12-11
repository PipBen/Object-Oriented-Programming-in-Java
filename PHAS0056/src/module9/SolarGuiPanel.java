package module9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import mod9test.AnimationPanel;

public class SolarGuiPanel extends JPanel implements ActionListener {
	 
	private SolarPanel animPanel; // panel containing animation
	 private JButton startButton;
	 private JButton stopButton;
	 private JButton exitButton;
	 /** Create JPanel containing animation panel and buttons. */
	 public SolarGuiPanel() {
		 super();
		 setPreferredSize(new Dimension(1000,1000));
		 setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		 animPanel = new SolarPanel(1000,1050,1000);
		 startButton = new JButton("Start");
		 stopButton = new JButton("Stop");
		 exitButton = new JButton("Exit");
		 startButton.addActionListener(this);
		 stopButton.addActionListener(this);
		 exitButton.addActionListener(this);
		 JPanel buttonPanel = new JPanel();
		 buttonPanel.setLayout(new BoxLayout(
		 buttonPanel,BoxLayout.X_AXIS));
		 buttonPanel.add(startButton);
		 buttonPanel.add(stopButton);
		 buttonPanel.add(exitButton);
		 add(animPanel);
		 add(buttonPanel);
	 }
	 /** Respond to button clicks */
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource()==startButton) start();
		 else if (e.getSource()==stopButton) stop();
		 else if (e.getSource()==exitButton) System.exit(0);
	 }
	 /** Start animation */
	 public void start() {animPanel.start();}
	 /** Stop animation */
	 public void stop() {animPanel.stop();}
}

