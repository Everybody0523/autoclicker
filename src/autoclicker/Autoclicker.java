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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

public class Autoclicker {
	private final JFrame jframe;
	private JPanel inputPanel;
	private JTextField delayTime;
	private JTextField numClicks;
	private JButton btnNewButton;
	private JList list;
	private JLabel lblNumberOfClicks;
	private JLabel lblDelay;
	private JButton btnRunScript;
	
	/**
	 * Instantiate an AutoClicker, creating the necessary Swing objects within it.
	 */
	public Autoclicker() {
		//Build the frame and panel where all the inputs are.
		this.jframe = new JFrame("Autoclicker");
		this.inputPanel = new JPanel();
		Container content = this.jframe.getContentPane();
		content.add(this.inputPanel);
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWidths = new int[]{90, 90, 0, 0};
		gbl_inputPanel.rowHeights = new int[]{37, 0, 0, 0, 0};
		gbl_inputPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_inputPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		inputPanel.setLayout(gbl_inputPanel);
		
		//Set up the JTextField where the amount of clicks to be performed will be executed is to be declared
		//by the user
		this.numClicks = new JTextField();
		GridBagConstraints gbc_numClicks = new GridBagConstraints();
		gbc_numClicks.insets = new Insets(0, 0, 5, 5);
		gbc_numClicks.gridx = 0;
		gbc_numClicks.gridy = 0;
		this.inputPanel.add(this.numClicks, gbc_numClicks);
		this.numClicks.setColumns(10);
		
		//Set up the JTextField where the delay between each click is to be declared by the user.
		this.delayTime = new JTextField();
		GridBagConstraints gbc_delayTime = new GridBagConstraints();
		gbc_delayTime.anchor = GridBagConstraints.EAST;
		gbc_delayTime.insets = new Insets(0, 0, 5, 5);
		gbc_delayTime.gridx = 1;
		gbc_delayTime.gridy = 0;
		this.inputPanel.add(this.delayTime, gbc_delayTime);
		this.delayTime.setColumns(10);
		
		//Set up the list of scripts.
		this.list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 4;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 0;
		this.inputPanel.add(this.list, gbc_list);
		
		//A label that reads "Number of Clicks"
		this.lblNumberOfClicks = new JLabel("Number of Clicks");
		GridBagConstraints gbc_lblNumberOfClicks = new GridBagConstraints();
		gbc_lblNumberOfClicks.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfClicks.gridx = 0;
		gbc_lblNumberOfClicks.gridy = 1;
		this.inputPanel.add(lblNumberOfClicks, gbc_lblNumberOfClicks);
		
		//A label that reads "Delay (ms)"
		this.lblDelay = new JLabel("Delay (ms)");
		GridBagConstraints gbc_lblDelay = new GridBagConstraints();
		gbc_lblDelay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDelay.gridx = 1;
		gbc_lblDelay.gridy = 1;
		this.inputPanel.add(this.lblDelay, gbc_lblDelay);
		
		//Create the button that begins the automated clicking.
		this.btnNewButton = new JButton("Start Clicking");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		this.btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int numberOfClicks = Integer.parseInt(numClicks.getText());
				int del = Integer.parseInt(delayTime.getText());
				try {
					Bot.clickALot(numberOfClicks, del);
				} catch (AWTException e1) {
					e1.printStackTrace();
					System.out.println("... I have no idea what went wrong");
				}
				
			}
		});
		this.inputPanel.add(this.btnNewButton, gbc_btnNewButton);
		
		//Create the button that runs the selected script.
		btnRunScript = new JButton("Run Script");
		GridBagConstraints gbc_btnRunScript = new GridBagConstraints();
		gbc_btnRunScript.insets = new Insets(0, 0, 0, 5);
		gbc_btnRunScript.gridx = 1;
		gbc_btnRunScript.gridy = 3;
		inputPanel.add(btnRunScript, gbc_btnRunScript);
		
				
	}
	
	private void createAndShowGui() {
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public static void main(String[] args){
		Autoclicker a = new Autoclicker();
		a.createAndShowGui();
	}
}
