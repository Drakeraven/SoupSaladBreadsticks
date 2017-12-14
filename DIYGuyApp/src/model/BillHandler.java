/*Facilitates Creating Bills and adding them to User Data.
 * Creator: Cassie Renz
 */

package model;

public class BillHandler {

	private static Bill newBill = null;  
	
	/**
	 * Creates a bill object to add to UserData
	 * @param d Bill type
	 * @param da day
	 * @param m month
	 * @param y year
	 * @param c cost
	 * @param u UserData
	 */
	public static void addBill(String d, int da, int m, int y, double c, UserData u) { 
		BillHandler.newBill = new Bill(d, da, m, y, c);
		u.setBillList(newBill);
	}
	
	

}
