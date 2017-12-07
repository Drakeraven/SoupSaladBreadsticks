/*
 * Coder: Cassie Renz
 */

package view;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Bill;
import model.FileHandler;
import model.UserData;

public class BillEntryPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static FileHandler handler;

	public BillEntryPanel(FileHandler fileHand) { 	
		handler = fileHand;
		setUpAddBill(); 	
	}	
	
	/*
	 * Method to set up the pop up "add bill information" panel 
	 * Pre: None
	 * Post: None 
	 */
	public JPanel setUpAddBill() { 
		UserData myUser = handler.getUserData();
		Bill newBill;
		double newCost = 0;
		String newText;
		int month = 0;
		int day = 0;
		int year = 0;
		JPanel addBill = new JPanel(new GridLayout(7,1));
		
		
		addBill.add(new JLabel("Enter bill type: "));
		addBill.add(Box.createHorizontalStrut(15));
		JTextField billType = new JTextField(5); 
		addBill.add(billType);
		addBill.add(Box.createHorizontalStrut(15));
		addBill.add(new JLabel("Enter bill total: "));
		addBill.add(Box.createHorizontalStrut(15));
		JTextField billCost = new JTextField(); 
		addBill.add(billCost);
		addBill.add(Box.createHorizontalStrut(15));
		addBill.add(new JLabel("Enter bill date (mm/dd/yyyy): "));
		addBill.add(Box.createHorizontalStrut(15));
		JTextField date = new JTextField(); 
		addBill.add(date);		 
		
		int result = JOptionPane.showConfirmDialog(this, addBill, 
				"Enter New Bill Information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			System.out.println("you've made it to the bill entry");
			//TODO: Get information here
			newCost = validateDouble(billCost.getText());
			
			String[] dateParts = date.getText().split("/");
			dateParts = validateArray(dateParts);
			month = validateInt(dateParts[0]); 
			day = validateInt(dateParts[1]);
			year = validateInt(dateParts[2]);
			
			newBill = new Bill(billType.getText(), month, day, year, newCost);
			myUser.setBillList(newBill);
			
		}
		
		while (newCost == -1 || month == -1 || day == -1 || year == -1) { 
			System.out.println("you've made it to the error code");
			if (newCost == -1){ 
				newText = "Please enter a valid cost";
			} else { 
				newText = "Please enter a valid date";
			}
			result = JOptionPane.showConfirmDialog(this, addBill, 
					newText, JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				//TODO: Get information here
				newCost = validateDouble(billCost.getText());
				
				String[] dateParts = date.getText().split("/");
				dateParts = validateArray(dateParts);
				month = validateInt(dateParts[0]); 
				day = validateInt(dateParts[1]);
				year = validateInt(dateParts[2]);
				
				newBill = new Bill(billType.getText(), month, day, year, newCost); 
				myUser.setBillList(newBill);
				
			}
		}
		
		//newBill = new Bill(billType.getText(), day, month, year, newCost);
		
		return addBill; 
	}
	
	/*
	 * Method for validating int inputs
	 * Pre: Takes in a string s 
	 * Post: Returns a valid integer, -1 if invalid input
	 */
	private int validateInt(String s) { 
		int valInt; 
		
		try{
		    valInt = Integer.parseInt(s);
		}catch (NumberFormatException ex) {
		    valInt = -1; 
		}
		
		if (valInt < 0)  { 
			valInt = -1; 
		}
	
		return valInt;
	}
	
	/*
	 * Method for validating double inputs
	 * Pre: Takes in a string s 
	 * Post: Returns a valid double, -1 if invalid input
	 */
	private double validateDouble(String s) { 
		double valDouble; 
		
		try{
		    valDouble = Integer.parseInt(s);
		}catch (NumberFormatException ex) {
		    valDouble = -1; 
		}
		
		if (valDouble < 0)  { 
			valDouble = -1; 
		}
	
		return valDouble;
	}
	
	private String[] validateArray(String[] parts) {
		int size = parts.length;
		if(size != 3){ 
			parts = new String[3];
		}
		
		return parts;
	}

}
