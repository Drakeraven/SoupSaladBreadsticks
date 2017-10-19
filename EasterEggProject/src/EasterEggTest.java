
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing Class for the Easter Egg Project
 * @author Soup,Salad, and Breadsticks
 * @version 1.0
 */
public class EasterEggTest {

	private EasterEgg testEgg;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testEgg = new EasterEgg();
	}

	/**
	 * Test method for {@link EasterEgg#startingEgg()}.
	 */
	@Test
	public void testStartingEgg() {
		
		PrintStream OrigOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		String separator = System.getProperty("line.separator");
		testEgg.startingEgg();
		assertEquals("We Are Soup, Salad, and Breadsticks." + separator,
				os.toString());
		System.setOut(OrigOut);	
	}

	/**
	 * Test method for {@link EasterEgg#BryanEgg()}.
	 */
	@Test
	public void testBryanEgg() {
			PrintStream OrigOut = System.out;
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			
			String separator = System.getProperty("line.separator");
			testEgg.BryanEgg();
			assertEquals("This is Bryan. uh, why y'all leave me with the salad??" + separator,
					os.toString());
			
			System.setOut(OrigOut);	
	}

	/**
	 * Test method for {@link EasterEgg#StephanieEgg()}.
	 */
	@Test
	public void testStephanieEgg() {
		PrintStream OrigOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		String separator = System.getProperty("line.separator");
		testEgg.StephanieEgg();
		assertEquals("I'm Stephanie, I'll only eat the breadsticks." + separator,
				os.toString());
		
		System.setOut(OrigOut);	
	}

	/**
	 * Test method for {@link EasterEgg#CassieEgg()}.
	 */
	@Test
	public void testCassieEgg() {
		PrintStream OrigOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		String separator = System.getProperty("line.separator");
		testEgg.CassieEgg();
		assertEquals("This is Cassie! if you don't order extra breadsticks to take home, "
				+ "how are you even living?" + separator, os.toString());
		
		System.setOut(OrigOut);

	}

	/**
	 * Test method for {@link EasterEgg#CynthiaEgg()}.
	 */
	@Test
	public void testCynthiaEgg() {
		PrintStream OrigOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream prs = new PrintStream(os);
		System.setOut(prs);
		
		String separator = System.getProperty("line.separator");
		testEgg.CynthiaEgg();
		assertEquals("This is Cynthia...Ya'll can fight over your breadsticks. "
				 + "It's all about that soup though!" + separator, os.toString());
		
		System.setOut(OrigOut);
	}

}
