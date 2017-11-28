package view;

import java.awt.BorderLayout;
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
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static UserData myUserData;

	public SplashPanel(UserData theUserData) {
		
		myUserData = theUserData;
		fileChooser = new JFileChooser();
		
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		JPanel ButtonHolder = new JPanel();
		
		//TODO Create actions for going to the projects and energy tracker windows
		ButtonHolder.add(new JButton("Projects"));
		ButtonHolder.add(new JButton("Energy Tracker"));
		this.add(ButtonHolder, BorderLayout.CENTER);
		
		JPanel ExportHolder = new JPanel();
		ExportHolder.setLayout(new BorderLayout());
		//TODO Set up the Inport/Export system 
		ExportHolder.add(new JButton("Inport/Export"), BorderLayout.SOUTH);
		
		this.add(ExportHolder, BorderLayout.EAST);

		
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
