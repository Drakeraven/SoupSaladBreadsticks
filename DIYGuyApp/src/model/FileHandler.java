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
	public UserData myUserData;

	public FileHandler() throws ClassNotFoundException, IOException {
		initData();
	}
	
	public FileHandler(UserData newUser) {
		myUserData = newUser;
		try {
			createProgramData();
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't create Program Data!");
			e.printStackTrace();
		}
	}
	
	public void createProgramData() throws FileNotFoundException, IOException {
		FileOutputStream fileOut = new FileOutputStream("ProgramData.diy");
		ObjectOutputStream encoderp = new ObjectOutputStream(fileOut);
		encoderp.writeObject(myUserData);
		encoderp.close();
		fileOut.close();
		
	}

	public void exportData(File selectedPath) throws FileNotFoundException, IOException {
		ObjectOutputStream encodere = null;
		FileOutputStream fileOut = new FileOutputStream(selectedPath + "\\UserData.diy");
		encodere = new ObjectOutputStream(fileOut);
		encodere.writeObject(myUserData);
		encodere.close();
		fileOut.close();
	}
	
	public void importData(File selectedPath) throws ClassNotFoundException, IOException {
		ObjectInputStream decoderim = null;
		FileInputStream fileIn = new FileInputStream(selectedPath);
		decoderim = new ObjectInputStream(fileIn);
		myUserData = (UserData)decoderim.readObject();
		decoderim.close();
		fileIn.close();
		System.out.println(myUserData.getUserEmail());
	}
	
	private void initData() throws IOException, ClassNotFoundException, FileNotFoundException {
		FileInputStream fileIn = new FileInputStream("ProgramData.diy");
		ObjectInputStream decoderi = new ObjectInputStream(fileIn);
		myUserData = (UserData)decoderi.readObject();
		decoderi.close();
		fileIn.close();
	}
	
	public UserData getUserData() {
		return myUserData;
	}

}
