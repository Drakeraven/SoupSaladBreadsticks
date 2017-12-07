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

	public BillEntryPanel(FileHandler fileHand) { 	
		FileHandler handler = fileHand;
		setUpAddBill(); 	
	}	
	
	/*
	 * Method to set up the pop up "add bill information" panel 
	 * Pre: None
	 * Post: None 
	 */
	public JPanel setUpAddBill() { 
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
		
		
		//TODO: Check for valid input
		//TODO: Check for valid input
		//TODO: Check for valid input omg cassie don't forget	
		//TODO: Parse the string, check for valid inputs 
		 
		
		int result = JOptionPane.showConfirmDialog(this, addBill, 
				"Enter New Bill Information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			//TODO: Get information here
			newCost = validateDouble(billCost.getText());
			
			String[] dateParts = date.getText().split("/");
			dateParts = validateArray(dateParts);
			month = validateInt(dateParts[0]); 
			day = validateInt(dateParts[1]);
			year = validateInt(dateParts[2]);
			
			newBill = new Bill(billType.getText(), month, day, year, newCost); 
		} else if (result == JOptionPane.CANCEL_OPTION) {
			addBill = null; 
			
		} else if (result == JOptionPane.CLOSED_OPTION) {
			addBill = null; 
		}
		
		while (newCost == -1 || month == -1 || day == -1 || year == -1) { 
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
				//UserData.setBillList(newBill); use filehandler to grab data
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
