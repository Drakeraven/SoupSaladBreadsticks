package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class FileHandler implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 473118590700911358L;
	private static JFileChooser fileChooser;
	public UserData myUserData;

	public FileHandler() throws ClassNotFoundException, IOException {

		fileChooser = new JFileChooser();
		initData();
	}
	
	public FileHandler(UserData newUser) {
		fileChooser = new JFileChooser();
		myUserData = newUser;
		System.out.println("Entered User: " + myUserData.getUserName());
		System.out.println("Entered User: " + myUserData.getUserEmail());
		try {
			createProgramData();
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't create Program Data!");
			e.printStackTrace();
		}
	}
	
	private void createProgramData() throws FileNotFoundException, IOException {
		FileOutputStream fileOut = new FileOutputStream("data\\ProgramData.diy");
		ObjectOutputStream encoderp = new ObjectOutputStream(fileOut);
		System.out.println("createProgramData: " + myUserData.getUserName());
		System.out.println("createProgramData: "+ myUserData.getUserEmail());
		encoderp.writeObject(myUserData);
		encoderp.close();
		fileOut.close();
		
	}

	public void exportData() throws FileNotFoundException, IOException {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		final int selectedFile = fileChooser.showOpenDialog(null);
		ObjectOutputStream encodere = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
			final File selectedPath = fileChooser.getSelectedFile();
				FileOutputStream fileOut = new FileOutputStream(selectedPath + "\\UserData.diy");
				encodere = new ObjectOutputStream(fileOut);
				System.out.println("Writing Data: " + myUserData.getUserName());
				System.out.println("Writing Data: " + myUserData.getUserEmail());
				encodere.writeObject(myUserData);
				encodere.close();
				fileOut.close();
		}
		
	}
	
	public void importData() throws ClassNotFoundException, IOException {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		final int selectedFile = fileChooser.showSaveDialog(null);
		ObjectInputStream decoderim = null;
		
		if (selectedFile == JFileChooser.APPROVE_OPTION) {
				final File selectedPath = fileChooser.getSelectedFile();
				FileInputStream fileIn = new FileInputStream(selectedPath);
				decoderim = new ObjectInputStream(fileIn);
				myUserData = (UserData)decoderim.readObject();
				decoderim.close();
				fileIn.close();
				System.out.println("importing Data: " + myUserData.getUserEmail());
				System.out.println("importing Data: " + myUserData.getUserName());
			
		}
		
	}
	
	private void initData() throws IOException, ClassNotFoundException, FileNotFoundException {
		
		FileInputStream fileIn = new FileInputStream("data\\ProgramData.diy");
		ObjectInputStream decoderi = new ObjectInputStream(fileIn);
		myUserData = (UserData)decoderi.readObject();
		decoderi.close();
		fileIn.close();
		System.out.println("initializing Data: " + myUserData.getUserName());
		System.out.println("Initializing Data: " + myUserData.getUserEmail());

	}
	
	public UserData getUserData() {
		return myUserData;
	}

}
