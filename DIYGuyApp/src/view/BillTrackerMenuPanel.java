
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	public static  FileHandler handler;
	public static String[] columnNames = {"Bill Type", "Month", "Day", "Year", "Bill Cost"};
	private static JButton addBill; 
	private JTable overallTable;
	private JScrollPane scrollPanel; 
	private UserData myUser;
	private ArrayList<Bill> billList;

	public BillTrackerMenuPanel(FileHandler fileCh) { 	
		handler = fileCh;
		buildGUI(); 	
	}
	
	/*
	 * Initial set up for the main Bill GUI page
	 * Pre: None 
	 * Post: None
	 */
	public void buildGUI() { 
		myUser = handler.myUserData;
		billList = myUser.getBillList();
		
 		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		
		Object[][] data = get2DArray(billList);
		
		Object[][] data2 = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		System.out.println("You are Here"); 
		overallTable = new JTable(data, columnNames);
		scrollPanel = new JScrollPane(overallTable);

		this.add(scrollPanel, BorderLayout.CENTER);
		this.add(setUpAddBillButton(), BorderLayout.SOUTH);
		
		this.setVisible(true);
		revalidate();
	}
	
	/*
	 * Method to get a 2d array from an array of objects
	 * Pre: Takes in an ArrayList of type Bill
	 * Post: Returns a 2d array of bill information
	 */
	private Object[][] get2DArray(ArrayList<Bill> billList) {
		int size = billList.size();
		Object[][] list = new Object[size][5];
		System.out.println("You are here");
		for (int i = 0; i < size-1 ; i++) { 
			list[i][0] = billList.get(0).getBillType();
			System.out.println(billList.get(0));
			System.out.println(billList.get(0).getBillType());
			list[i][1] = billList.get(1).getBillDay();
			list[i][2] = billList.get(2).getBillMonth();
			list[i][3] = billList.get(3).getBillYear();
			list[i][4] = billList.get(4).getBillCost();
		}	
		return list;
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
		
		//setUpBillListener(); 
		addBill.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(final java.awt.event.ActionEvent evt) {
	            BillEntryPanel billEntry = new BillEntryPanel(handler, scrollPanel);
	            Object[][] data = get2DArray(billList);
	            overallTable = new JTable(data, columnNames);
	            scrollPanel.setViewportView(overallTable);
	        }
	    });
		return billComponent; 
		
	}
	
	

}
