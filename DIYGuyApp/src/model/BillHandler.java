package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BillHandler {

	private static Bill newBill = null;  
	/*
	 * Takes in all the information needed to create a new bill
	 */
	private static PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(BillHandler.class);
	
	public static void addPropertyChangeListener(PropertyChangeListener l) { 
		propertyChangeSupport.addPropertyChangeListener(l);
	}
	
	public static void addBill(String d, int da, int m, int y, double c, UserData u) { 
		Bill oldBill = BillHandler.newBill;
		BillHandler.newBill = new Bill(d, da, m, y, c);
		u.setBillList(newBill);
		System.out.println("Adding new bill");
		System.out.println(u.getBillList().toString());
		propertyChangeSupport.firePropertyChange("bill", oldBill, BillHandler.newBill);
	}
	
	

}
