package model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

public class FileHandler {
	
	private static JFileChooser fileChooser;
	public static UserData myUserData;

	public FileHandler() throws FileNotFoundException {

		fileChooser = new JFileChooser();
		myUserData = this.initData();
	}
	
	public FileHandler(UserData newUser) {
		fileChooser = new JFileChooser();
		myUserData = newUser;
	}
	
	public void exportData() throws FileNotFoundException, IOException {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int selectedFile = fileChooser.showOpenDialog(null);
		ObjectOutputStream encoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
			final File selectedPath = fileChooser.getSelectedFile();

				encoder = new ObjectOutputStream(new FileOutputStream(selectedPath + "\\UserData.diy"));
				encoder.writeObject(myUserData);
				encoder.close();
		}
		
	}
	
	public void importData() throws ClassNotFoundException, IOException {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		final int selectedFile = fileChooser.showSaveDialog(null);
		ObjectInputStream decoder = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
				final File selectedPath = fileChooser.getSelectedFile();
				decoder = new ObjectInputStream(new FileInputStream(selectedPath));
				
				myUserData = (UserData)decoder.readObject();
				decoder.close();
				System.out.println(myUserData.getUserEmail());
				System.out.println(myUserData.getUserName());
			
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
