package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * A class to handle the exporting/importing of program data
 * @author Coder: Stephanie Day
 */
public class FileHandler implements Serializable {
	
	private static final long serialVersionUID = 473118590700911358L;
	public UserData myUserData;
	
	/**
	 * This Constructor is used for initializing the FIle Handler with existing program data.
	 * @throws ClassNotFoundException When UserData class is missing??
	 * @throws IOException When Failure to find program data file occurs. 
	 */
	public FileHandler() throws ClassNotFoundException, IOException {
		initData();
	}
	
	/**
	 * This Constructor is used to initialize with a new User.
	 * @param newUser new User Data.
	 */
	public FileHandler(UserData newUser) {
		myUserData = newUser;
		try {
			createProgramData();
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't create Program Data!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method used to create a new file for program data.
	 * Pre-Condition: User Data initialized with some values.
	 * Post-Condition: ProgramData.diy
	 * @throws FileNotFoundException File Write issue.
	 * @throws IOException File Write Issue.
	 */
	public void createProgramData() throws FileNotFoundException, IOException {
		FileOutputStream fileOut = new FileOutputStream("ProgramData.diy");
		ObjectOutputStream encoderp = new ObjectOutputStream(fileOut);
		encoderp.writeObject(myUserData);
		encoderp.close();
		fileOut.close();
		
	}
	
	/**
	 * Method called by user to export their user data to specified path/
	 * Pre-condition: Valid directory path.
	 * @param selectedPath File detailing directory path to place UserData.diy
	 * @throws FileNotFoundException File Write Issue.
	 * @throws IOException FIle Write Issue.
	 */
	public void exportData(File selectedPath) throws FileNotFoundException, IOException {
		ObjectOutputStream encodere = null;
		FileOutputStream fileOut = new FileOutputStream(selectedPath + "\\UserData.diy");
		encodere = new ObjectOutputStream(fileOut);
		encodere.writeObject(myUserData);
		encodere.close();
		fileOut.close();
	}
	
	/**
	 * Method called by user to import User Data from a selected File
	 * Pre-Condition: Valid .diy file to read from
	 * Post-Condition: File read into program data for use.
	 * @param selectedPath File selected to input User Data
	 * @throws ClassNotFoundException If User Data class is missing
	 * @throws IOException File Read Issue.
	 */
	public void importData(File selectedPath) throws ClassNotFoundException, IOException {
		ObjectInputStream decoderim = null;
		FileInputStream fileIn = new FileInputStream(selectedPath);
		decoderim = new ObjectInputStream(fileIn);
		myUserData = (UserData)decoderim.readObject();
		decoderim.close();
		fileIn.close();
	}
	
	/**
	 * Class Used for reading if there is an exisitng Program Data File
	 * Pre-Condition: None
	 * Post-Condition: Read in program data for use, or flag that there is no user.
	 * @throws IOException File Read Issue
	 * @throws ClassNotFoundException User Data is missing.
	 * @throws FileNotFoundException No Program Data file currently exists
	 */
	private void initData() throws IOException, ClassNotFoundException, FileNotFoundException {
		FileInputStream fileIn = new FileInputStream("ProgramData.diy");
		ObjectInputStream decoderi = new ObjectInputStream(fileIn);
		myUserData = (UserData)decoderi.readObject();
		decoderi.close();
		fileIn.close();
	}
	
	/**
	 * Class to retrieve the instance of the program's user data.
	 * Pre-Condition: Non-null user data
	 * post- Condition: returns User Data.
	 * @return
	 */
	public UserData getUserData() {
		return myUserData;
	}

}
