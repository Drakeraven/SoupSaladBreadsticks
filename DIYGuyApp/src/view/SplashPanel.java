package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.UserData;

/**
 * GUI Panel displaying the main home page of the DIYGuy App
 * @author Stephanie Day
 * @version 11/27/2017
 */
public class SplashPanel extends JPanel {

	private static final long serialVersionUID = 7186465643558755364L;
	private static JFileChooser fileChooser;
	private static final Dimension BUTTON_SIZE = new Dimension(200,100);
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static UserData myUserData;

	public SplashPanel() {

		fileChooser = new JFileChooser();
		setUpGui();
			
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
		this.add(ButtonHolder);
		
		JButton exportButton = new JButton("Import/Export");
		constr.fill = GridBagConstraints.HORIZONTAL;

		constr.anchor = GridBagConstraints.PAGE_END; //bottom of space
		constr.insets = new Insets(10,0,10,0);  //top padding
		constr.gridx = 0;       //aligned with button 2
		constr.gridwidth = 2;   //2 columns wide
		constr.gridy = 1;
		this.add(exportButton, constr);
	}
	
	private void exportData() {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int selectedFile = fileChooser.showOpenDialog(this);
		XMLEncoder encoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
			//TODO May be a point of error for where the file is exported
			final File selectedPath = fileChooser.getCurrentDirectory();
			try {
				encoder = new XMLEncoder(new BufferedOutputStream(
						new FileOutputStream(selectedPath.getAbsolutePath() + "UserData.xml")));
				
			} catch(FileNotFoundException fileNotFound) {
                JOptionPane.showMessageDialog(this,
                        "Error creating or opening the selected file.", 
                        "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
			encoder.writeObject(myUserData);
			encoder.close();
		}
		
	}
	
	private void importData() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		final int selectedFile = fileChooser.showSaveDialog(this);
		XMLDecoder decoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
				final File selectedPath = fileChooser.getCurrentDirectory();
			try{
				decoder = new XMLDecoder(new BufferedInputStream(
						new FileInputStream(selectedPath.getAbsolutePath() + ".xml")));
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(this,
                        "Error creating or opening the selected file.", 
                        "Error!", JOptionPane.ERROR_MESSAGE);
			}
			myUserData = (UserData)decoder.readObject(); 
		}
		
	}


}
