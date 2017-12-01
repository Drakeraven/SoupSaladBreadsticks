package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class XmlHandler {
	
	private static JFileChooser fileChooser;
	public static UserData myUserData;

	public XmlHandler() throws FileNotFoundException {

		fileChooser = new JFileChooser();
		myUserData = this.initData();
	}
	
	public XmlHandler(UserData newUser) {
		fileChooser = new JFileChooser();
		myUserData = newUser;
	}
	
	public void exportData() {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int selectedFile = fileChooser.showOpenDialog(null);
		XMLEncoder encoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
			//TODO May be a point of error for where the file is exported
			final File selectedPath = fileChooser.getCurrentDirectory();
			try {
				encoder = new XMLEncoder(new BufferedOutputStream(
						new FileOutputStream(selectedPath.getAbsolutePath() + "UserData.xml")));
				
			} catch(FileNotFoundException fileNotFound) {
                JOptionPane.showMessageDialog(null,
                        "Error creating or opening the selected file.", 
                        "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
			encoder.writeObject(myUserData);
			encoder.close();
		}
		
	}
	
	public void importData() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		final int selectedFile = fileChooser.showSaveDialog(null);
		XMLDecoder decoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
				final File selectedPath = fileChooser.getCurrentDirectory();
			try{
				decoder = new XMLDecoder(new BufferedInputStream(
						new FileInputStream(selectedPath.getAbsolutePath() + ".xml")));
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null,
                        "Error creating or opening the selected file.", 
                        "Error!", JOptionPane.ERROR_MESSAGE);
			}
			myUserData = (UserData)decoder.readObject();
			decoder.close();
		}
		
	}
	
	private UserData initData() throws FileNotFoundException {
		UserData myProgramData;
		
		XMLDecoder decoder = null;
		decoder = new XMLDecoder(new BufferedInputStream(
				new FileInputStream("ProgramData.xml")));		
	
		myProgramData = (UserData)decoder.readObject();
		decoder.close();
		return myProgramData;
		
	}
	
	public UserData getUserData() {
		return myUserData;
	}

}
