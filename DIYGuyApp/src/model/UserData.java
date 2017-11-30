
package model;

import java.util.ArrayList;

/** 
 * A Class to hold a particular User's data.
 * @author Stephanie Day
 * @version 11/25/2017
 */
public class UserData {
	
	//TODO might not be an array of strings
	public static ArrayList<String> PROJECT_LIST; 
	
	public static ArrayList<Bill> BILL_LIST;
	
	private static String userName;
	
	private static String userEmail; 
	
	public UserData(String name, String email) {
		super();
		userName = name;
		userEmail = email;
		PROJECT_LIST = new ArrayList<String>();
		BILL_LIST = new ArrayList<Bill>();
		
		
	}
	
	public String getName() {
		return userName;
	}
	
	public String getEmail() {
		return userEmail;
	}
	
	//TODO this is bad practice stephanie :((
	public ArrayList<Bill> getBills() {
		return BILL_LIST;

	}
	
	public ArrayList<String> getProjectStatus() {
		return PROJECT_LIST;
		
	}

	public void addBill(Bill theBill) {
		BILL_LIST.add(theBill);
	}
	
	public void addProject(String projectName) {
		PROJECT_LIST.add(projectName);
	}	
}

