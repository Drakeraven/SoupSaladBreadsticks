/*
 * Creator: Cassie Renz
 */

package model;

public class BillHandler {

	private static Bill newBill = null;  
	
	public static void addBill(String d, int da, int m, int y, double c, UserData u) { 
		BillHandler.newBill = new Bill(d, da, m, y, c);
		u.setBillList(newBill);
	}
	
	

}
