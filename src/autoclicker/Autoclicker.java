package autoclicker;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Autoclicker {
	private final JFrame jframe;
	private final JTextField numberOfClicks;
	private final JButton beginClicking;

	public Autoclicker() {
		this.jframe = new JFrame();
		this.numberOfClicks = new JTextField();
		this.beginClicking = new JButton("Click Away!");
		beginClicking.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int numClick = Integer.parseInt(numberOfClicks.getText());
				try {
					Bot.clickALot(numClick);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		Container content = this.jframe.getContentPane();
		content.add(this.numberOfClicks, BorderLayout.PAGE_START);
		content.add(this.beginClicking, BorderLayout.PAGE_END);
	}
	
	private void createAndShowGui() {
		// The following three lines will be included in basically every GUI
		// you see. If you don't include EXIT_ON_CLOSE, your application won't
		// close properly!
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public static void main(String[] args){
		Autoclicker a = new Autoclicker();
		a.createAndShowGui();
	}
}
