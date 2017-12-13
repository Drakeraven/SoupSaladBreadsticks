
/*
 * Creator: Cassie Renz 
 * Coder: Cassie Renz
 */

package view;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Bill;
import model.BillHandler;
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
	DefaultTableModel model = new DefaultTableModel(new Object[]{"Bill Type", "Month", "Day", "Year", "Bill Cost"}, 0);
	private JTable overallTable = new JTable(model);
	private JScrollPane scrollPanel; 
	private UserData myUser;
	private ArrayList<Bill> billList;
	private Object[][] data;

	/*
	 * Constructor for BillTracker class
	 */
	public BillTrackerMenuPanel(FileHandler fileCh) { 	
		handler = fileCh;
		buildGUI(); 	
	}
	
	/*
	 * Initial set up for the main Bill GUI page
	 * Pre: Assumes an already set up fileHandler, and UserData 
	 * Post: Displays information to the screen regarding user bills 
	 */
	public void buildGUI() { 
		myUser = handler.myUserData;
		billList = myUser.getBillList();
		
 		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		
		data = get2DArray(billList);
		int i; 
		for (i = 0; i<data.length; i++) { 
			model.addRow(new Object[]{data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]});
		}
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
		for (int i = 0; i < size ; i++) { 
			list[i][0] = billList.get(i).getBillType();
			list[i][1] = billList.get(i).getBillDay();
			list[i][2] = billList.get(i).getBillMonth();
			list[i][3] = billList.get(i).getBillYear();
			list[i][4] = billList.get(i).getBillCost();
		}	
		return list;
	}

	/*
	 * Method to set up the GUI elements for adding a bill to the current User
	 * Pre: Assumes an already set up panel, fileHandler, and UserData 
	 * Post: Calls to set up the add bill panel if the user wants to add a bill
	 */
	public JPanel setUpAddBillButton() {
		JPanel billComponent = new JPanel(); 
		billComponent.setAlignmentY(BOTTOM_ALIGNMENT);
		
		JButton addBill = new JButton("Add Bill");
		billComponent.add(addBill);
		addBill.firePropertyChange("bill", false, true);
		
		addBill.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(final java.awt.event.ActionEvent evt) {
	            setUpAddBill(); 
	        }
	    });
			
		return billComponent; 
		
	}
	
	/*
	 * Method to set up the pop up "add bill information" panel 
	 * Pre: Assumes an already set up panel, fileHandler, and UserData 
	 * Post: Displays a GUI for a table of bills and option to add bills 
	 */
	public void setUpAddBill() { 
		UserData myUser = handler.getUserData();
		double newCost = 0;
		String newText;
		int month = 0;
		int day = 0;
		int year = 0;
		JPanel enterBillPanel = new JPanel(new GridLayout(7,1));
		
		enterBillPanel.add(new JLabel("Enter bill type: "));
		enterBillPanel.add(Box.createHorizontalStrut(15));
		JTextField billType = new JTextField(5); 
		enterBillPanel.add(billType);
		enterBillPanel.add(Box.createHorizontalStrut(15));
		enterBillPanel.add(new JLabel("Enter bill total: "));
		enterBillPanel.add(Box.createHorizontalStrut(15));
		JTextField billCost = new JTextField(); 
		enterBillPanel.add(billCost);
		enterBillPanel.add(Box.createHorizontalStrut(15));
		enterBillPanel.add(new JLabel("Enter bill date (mm/dd/yyyy): "));
		enterBillPanel.add(Box.createHorizontalStrut(15));
		JTextField date = new JTextField(); 
		enterBillPanel.add(date);		 
		
		int result = JOptionPane.showConfirmDialog(this, enterBillPanel, 
				"Enter New Bill Information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			newCost = BillEntryPanel.validateDouble(billCost.getText());
			
			String[] dateParts = date.getText().split("/");
			dateParts = BillEntryPanel.validateArray(dateParts);
			month = BillEntryPanel.validateInt(dateParts[0]); 
			day = BillEntryPanel.validateInt(dateParts[1]);
			year = BillEntryPanel.validateInt(dateParts[2]);
		} else { 
			return; 
		}
		
		while (newCost == -1 || month <= 0 || month > 12 || day <= 0 || day > 31|| year <= 0) { 
			if (newCost == -1){ 
				newText = "Please enter a valid cost";
			} else { 
				newText = "Please enter a valid date";
			}
			result = JOptionPane.showConfirmDialog(this, enterBillPanel, 
					newText, JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				newCost = BillEntryPanel.validateDouble(billCost.getText());
				
				String[] dateParts = date.getText().split("/");
				dateParts = BillEntryPanel.validateArray(dateParts);
				month = BillEntryPanel.validateInt(dateParts[0]); 
				day = BillEntryPanel.validateInt(dateParts[1]);
				year = BillEntryPanel.validateInt(dateParts[2]);
			} else { 
				return; 
			}
		}
		BillHandler.addBill(billType.getText(), day, month, year, newCost, myUser);

		//Add property change, so that when the data is update then the table on the panel is also updated 
		enterBillPanel.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				if ("bill".equals(evt.getPropertyName())) {
					data = get2DArray(billList);
					model.setRowCount(0);
					int i;
					for (i = 0; i<data.length; i++) { 
						model.addRow(new Object[]{data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]});
					}
				}
				model.fireTableDataChanged();
				overallTable = new JTable(model);
				scrollPanel.setViewportView(overallTable);
				revalidate();	
			}
		});
		
		enterBillPanel.firePropertyChange("bill", false, true);
		this.add(enterBillPanel); 
	}

}
