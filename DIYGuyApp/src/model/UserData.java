
package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.Bill;

/** 
 * A Class to hold a particular User's data.
 * @author Stephanie Day
 * @version 11/25/2017
 */
public class UserData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3542558265070011448L;

	//TODO might not be an array of strings
	public ArrayList<String> projectList; 
	
	public ArrayList<Bill> billList;
	
	public String userName;
	
	public String userEmail; 
	
	public UserData() {
		
	}
	
	public UserData(String name, String email) {
		super();
		userName = name;
		userEmail = email;
		projectList = new ArrayList<String>();
		billList = new ArrayList<Bill>();
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public ArrayList<Bill> getBillList() {
		return billList;

	}
	
	public ArrayList<String> getProjectList() {
		return projectList;
		
	}

	public void setBillList(Bill theBill) {
		billList.add(theBill);
	}
	
	public void setProjectList(String projectName) {
		projectList.add(projectName);
	}	
}

