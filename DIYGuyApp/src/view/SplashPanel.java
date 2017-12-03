package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.UserData;
import model.FileHandler;

/**
 * GUI Panel displaying the main home page of the DIYGuy App
 * @author Stephanie Day
 * @version 11/27/2017
 */
public class SplashPanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 7186465643558755364L;
	private static final Dimension BUTTON_SIZE = new Dimension(200,100);
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private static JButton importButton;
	private static JButton exportButton;
	
	public static FileHandler programData;

	public SplashPanel() {
		
		setUpGui();

		try {
			programData = new FileHandler();
			
		} catch (FileNotFoundException ex) {
			programData = new FileHandler(newUserDialog());
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Where's the classes??");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		importButton = new JButton("Import user");
		buttonPanel.add(importButton);
		exportButton = new JButton("Export User");
		buttonPanel.add(exportButton);
		
		setUpXmlListeners();
		return buttonPanel;
	}
	
	private UserData newUserDialog() {
		UserData newUserProgramData;
		JTextField enteredName = new JTextField(5);
		JTextField enteredEmail = new JTextField(5);
		
		JPanel fieldPanel = new JPanel(new GridLayout(8,1));
		fieldPanel.add(new JLabel("A New User!"));
		fieldPanel.add(new JLabel("Enter the info below to get started, or cancel to exit."));
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
				System.exit(0);
				
			} else if (result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}
			
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

	private void setUpXmlListeners() {
		
		class xmlListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
				if (theEvent.getSource() == importButton) {
					try {programData.importData();
					
					} catch (ClassNotFoundException FileWahWah) {
		                JOptionPane.showMessageDialog(null,
		                        "What Happened to your .exe??", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
		                
					} catch (IOException fileWahWah) {
						JOptionPane.showMessageDialog(null,
		                        "Not a valid format. Be sure you've picked a .diy", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
					}
					
				} else if (theEvent.getSource() == exportButton) {
					try {
						programData.exportData();
					} catch(IOException fileWahWah) {
		                JOptionPane.showMessageDialog(null,
		                        "Did you somehow select a bad directory?", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				
			}
			
		}
		
		importButton.addActionListener(new xmlListener());
		exportButton.addActionListener(new xmlListener());
	}
}
