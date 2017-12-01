package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.UserData;
import model.XmlHandler;

/**
 * GUI Panel displaying the main home page of the DIYGuy App
 * @author Stephanie Day
 * @version 11/27/2017
 */
public class SplashPanel extends JPanel {

	private static final long serialVersionUID = 7186465643558755364L;
	private static final Dimension BUTTON_SIZE = new Dimension(200,100);
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static XmlHandler programData;

	public SplashPanel() {
		
		setUpGui();
		try {
			programData = new XmlHandler();
			
		} catch (FileNotFoundException ex) {
			programData = new XmlHandler(newUserDialog());
		}
	}
	
	private void setUpGui() {
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		
		
		JPanel ButtonHolder = new JPanel(new GridLayout(1,2));
		((GridLayout)ButtonHolder.getLayout()).setHgap(20);
		//TODO Create actions for going to the projects and energy tracker windows
		JButton projectButton = new JButton("Projects");
		JButton EnergyButton = new JButton("Energy Tracker");
		projectButton.setPreferredSize(BUTTON_SIZE);
		EnergyButton.setPreferredSize(BUTTON_SIZE);
		ButtonHolder.add(projectButton);
		ButtonHolder.add(EnergyButton);
		constr.fill = GridBagConstraints.BOTH;
		constr.gridx = 0;
		constr.gridy = 0;
		constr.anchor = GridBagConstraints.PAGE_START;
		this.add(ButtonHolder);
	
	}
	
	public JPanel setupImportExportButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentY(BOTTOM_ALIGNMENT);
		buttonPanel.add(new JButton("Import User"));
		buttonPanel.add(new JButton("Export User"));
		
		return buttonPanel;
	}
	
	private UserData newUserDialog() {
		UserData newUserProgramData;
		JTextField enteredName = new JTextField(5);
		JTextField enteredEmail = new JTextField(5);
		
		JPanel fieldPanel = new JPanel(new GridLayout(6,1));
		fieldPanel.add(new JLabel("Enter a name: "));
		fieldPanel.add(enteredName);
		fieldPanel.add(Box.createHorizontalStrut(15));
		fieldPanel.add(new JLabel("Enter an Email: "));
		fieldPanel.add(enteredEmail);
		fieldPanel.add(Box.createHorizontalStrut(15));
		String validEmail = null;
		
			int result = JOptionPane.showConfirmDialog(this, fieldPanel, 
					"Enter New User Information", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				validEmail = enteredEmail.getText();
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return null; //TODO may change how this is done.
			}
			//TODO Handle the bug that the program crashes if you exit the user information pane.
			
		 while (!validEmail.contains("@")) {
			JOptionPane.showMessageDialog(null, "Oops! Enter a valid email.");
			
			result = JOptionPane.showConfirmDialog(null, fieldPanel, 
					"Enter New User Information", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				validEmail = enteredEmail.getText();
			}
		}
		newUserProgramData = new UserData(enteredName.getText(), enteredEmail.getText());
		return newUserProgramData;
	}


}
