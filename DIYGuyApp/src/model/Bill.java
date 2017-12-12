package model;

import java.io.Serializable;

/**
 * Bill Object containing relevant Bill information.
 * @author Cynthia Mora Olmedo, Editor: Stephanie Day
 *
 */
public final class Bill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2412987123081026860L;

	String billType;
	int billDay;
	int billMonth;
	int billYear;
	double billCost;

	/**
	 * Bill constructor
	 */
	public Bill(String type, int day, int month, int year, double cost) {
		billType = type;
		billDay = day;
		billMonth = month;
		billYear = year;
	}
	
	/**
	 * Compares Bill costs, 0 means they are equal;
	 * positive  means first bill has high cost, negative
	 * means second bill has higher cost.
	 * @param a first bill
	 * @param b second bill
	 * @return integer indicating which bill has higher cost
	 */
	public static int compareBillCost(Bill a, Bill b) {
		int val = java.lang.Double.compare(a.getBillCost(),b.getBillCost());
		int rtn;
		if (val == 0) {
			rtn = 0;
		} else if (val > 0) {
			rtn = 1;
		} else {
			rtn = -1;
		}
		return rtn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bill Receipt:\nBill Type: " + getBillType() + "\tBill Date: " + getBillDate() 
			+ "\nBill Cost: " + getBillCost();
	}

	//Getters/Setters

	/**
	 * @return the billType
	 */
	public final String getBillType() {
		return billType;
	}

	/**
	 * @param billType the billType to set
	 */
	public final void setBillType(String billType) {
		this.billType = billType;
	}

	/**
	 * @return the billDay
	 */
	public final int getBillDay() {
		return billDay;
	}

	/**
	 * @param billDay the billDay to set
	 */
	public final void setBillDay(int billDay) {
		this.billDay = billDay;
	}

	/**
	 * @return the billMonth
	 */
	public final int getBillMonth() {
		return billMonth;
	}

	/**
	 * @param billMonth the billMonth to set
	 */
	public final void setBillMonth(int billMonth) {
		this.billMonth = billMonth;
	}

	/**
	 * @return the billYear
	 */
	public final int getBillYear() {
		return billYear;
	}

	/**
	 * @param billYear the billYear to set
	 */
	public final void setBillYear(int billYear) {
		this.billYear = billYear;
	}
	
	/**
	 * @return bill date in mm\dd\yyyy format.
	 */
	public final String getBillDate() {
		return billMonth + "\\" + billDay + "\\" + billYear;
	}

	/**
	 * @return the billCost
	 */
	public final double getBillCost() {
		return billCost;
	}

	/**
	 * @param billCost the billCost to set
	 */
	public final void setBillCost(double billCost) {
		this.billCost = billCost;
	}


}
