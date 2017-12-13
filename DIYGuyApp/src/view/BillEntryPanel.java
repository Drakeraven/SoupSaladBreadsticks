/*
 * Coder: Cassie Renz
 */

package view;

public class BillEntryPanel {
	
	/*
	 * Method for validating int inputs
	 * Pre: Takes in a string s 
	 * Post: Returns a valid integer, -1 if invalid input
	 */
	public static int validateInt(String s) { 
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
	public static double validateDouble(String s) { 
		double valDouble; 
		
		try{
		    valDouble = Double.parseDouble(s);
		}catch (NumberFormatException ex) {
		    valDouble = -1; 
		}
		
		if (valDouble < 0)  { 
			valDouble = -1; 
		}
	
		return valDouble;
	}
	
	/*
	 * Method for validating proper date format
	 * Pre: Takes in a String array 
	 * Post: returns an array with an index of 3, initialized to 0 if the date is incorrect
	 */
	public static String[] validateArray(String[] parts) {
		int size = parts.length;
		if(size != 3){ 
			parts = new String[3];
		}
		
		return parts;
	}

}
