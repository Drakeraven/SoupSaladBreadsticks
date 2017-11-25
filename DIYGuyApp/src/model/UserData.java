
package model;

import java.util.ArrayList;

/** 
 * A Class to hold a particular User's data.
 * @author Stephanie Day
 */
public class UserData {
	
	//TODO might not be an array of strings
	public static ArrayList<String> PROJECT_LIST; 
	
	public static ArrayList<Bill> BILL_LIST;
	
	private static String NAME;
	
	private static String PASSWORD;
	
	private static String EMAIL; 
	
	public UserData() {
		super();
		PROJECT_LIST = new ArrayList<String>();
		BILL_LIST = new ArrayList<Bill>();
		
		
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
	
	//TODO change for XML?
	@Override
	public String toString() {
		return NAME;
	}
	
	
}

//TODO get rid of later 
class Bill {
	
}
