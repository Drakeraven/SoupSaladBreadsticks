
/*
 * Creator: Cassie Renz 
 * Coder: Cassie Renz
 */

package view;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Bill;
import model.FileHandler;
import model.UserData;

/*
 * Main class for Bill GUI
 */
public class BillTrackerMenuPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8232879434427235700L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;

	public BillTrackerMenuPanel(FileHandler fileCh) { 	
		FileHandler handler = fileCh;
		buildGUI(); 	
	}
	
	/*
	 * Initial set up for the main Bill GUI page
	 * Pre: None 
	 * Post: None
	 */
	public void buildGUI() { 
		//ArrayList<Bill> billList = UserData.getBillList();
 		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		//GridBagConstraints constraint = new GridBagConstraints();
		
		//JPanel billInformation = new JPanel(new GridLayout(2,2));
		//JTable overallTable = new JTable();
		JButton overallTable = new JButton("Table Placeholder");
		this.add(overallTable, BorderLayout.CENTER);
		this.add(setUpAddBillButton(), BorderLayout.SOUTH);
		
		/*JPanel checkBoxes = new JPanel(new GridLayout(2,1));
		JCheckBox elec = new JCheckBox("Electricity");
		JCheckBox water = new JCheckBox("Water");
		checkBoxes.add(elec);
		checkBoxes.add(water);
		this.add(checkBoxes, BorderLayout.EAST);
		*/
		
		//TODO: Implement table lmao
		
		/*
		 * Header needed above the table
		 * Possible model needed to define the table 
		 * Haven't actually implemented table
		 */
		
		
		
	}
	
	/*
	 * Method to set up the GUI elements for adding a bill to the current User
	 * Pre: None
	 * Post: None
	 */
	public JPanel setUpAddBillButton() {
		JPanel billComponent = new JPanel(); 
		billComponent.setAlignmentY(BOTTOM_ALIGNMENT);
		
		JButton addBill = new JButton("Add Bill");
		billComponent.add(addBill);
		
		return billComponent; 
		
	}
	
}
