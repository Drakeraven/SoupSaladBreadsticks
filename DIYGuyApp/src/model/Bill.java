/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * Bill Object containing relevant Bill information.
 * @author Cynthia Mora Olmedo
 *
 */
public final class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675614786195270363L;
	private int test;

	/**
	 * Default constructor.
	 */
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	

}
