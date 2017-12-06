
package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.Bill;

/** 
 * A Class to hold a particular User's data.
 * @author Coder: Stephanie Day
 */
public class UserData implements Serializable {
	
	private static final long serialVersionUID = -3542558265070011448L;

	/** List of names of projects the user has begun. */
	public ArrayList<String> projectList; 
	
	/** List of bills the User has entered.*/
	public ArrayList<Bill> billList;
	
	/** User's name */
	public String userName;
	
	/** User's email address */
	public String userEmail; 
	
	/**
	 * Creates the User Data with initial name/email
	 * Pre-Condition: valid email and name
	 * Post-Condition: initialized program User Data
	 * @param name User's name
	 * @param email User's valid email
	 */
	public UserData(String name, String email) {
		super();
		userName = name;
		userEmail = email;
		projectList = new ArrayList<String>();
		billList = new ArrayList<Bill>();
		
	}
	
	/**
	 * Returns the user name
	 * Pre-condition: None
	 * Post Condition: user's name given.
	 * @return User's name.
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Returns the user's email address.
	 * Pre condition: none
	 * post_condition: user's email given.
	 * @return User's email address.
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * Returns a reference to User's entered bills
	 * Pre-condition: none
	 * post_condition: list of User's entered bills
	 * @return List of user's entered Bills.
	 */
	public ArrayList<Bill> getBillList() {
		return billList;

	}
	
	/**
	 * Returns a reference to User's entered Project names.
	 * pre-condition: none
	 * post-condition: list of user's project names.
	 * @return list of user's project names.
	 */
	public ArrayList<String> getProjectList() {
		return projectList;
		
	}
	
	/**
	 * Adds an entered bill to the list of bills.
	 * Pre-condition: filled out bill object
	 * post-condition: bill placed in array
	 * @param theBill Bill entered by user.
	 */
	public void setBillList(Bill theBill) {
		billList.add(theBill);
	}
	
	/**
	 * Adds a project name to the list of project names
	 * Pre-condition: Project name wished to start
	 * post-condition: project name added to list of projects.
	 * @param projectName name of Project.
	 */
	public void setProjectList(String projectName) {
		projectList.add(projectName);
	}	
}

