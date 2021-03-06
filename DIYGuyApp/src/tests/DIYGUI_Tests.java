/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.Bill;
import model.FileHandler;
import model.Project;
import model.UserData;
import view.BillEntryPanel;

/**
 * @author Cynthia Mora Olmedo
 *
 */
public class DIYGUI_Tests {
	Bill testBill;
	Bill testBill2;
	
	Project pro1;
	Project pro2;
	Project pro3;
	
	FileHandler handler;
	UserData data;

	/**
	 * Sets up testing projects, bills, and 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		data = new UserData("Cynthia Mora","cyncyn@soupsaladbreadsticks.org");
		handler = new FileHandler(data);
		testBill = new Bill("Electricity", 01, 01, 17, 64.55);
		testBill2 = new Bill("Water", 02, 02, 17, 30.05);
		//setting up instructions and materials for project 1)
		//materials
		ArrayList<String> pr1M = new ArrayList<>();
		pr1M.add("Thermometer for testing the water temperature");
		pr1M.add("Marker to mark the setting on your thermostat");
		//steps
		ArrayList<String> pr1S = new ArrayList<>();
		pr1S.add("Find the current temperature.Measure the beginning temperature of your hot water using a thermometer at the tap farthest from the water heater. Thermostat dials are often inaccurate");
		pr1S.add("Mark the setting, then turn down the thermostat.Mark the beginning temperature on your water heater thermostat with a marker, and then turn the thermostat down.");
		pr1S.add("Measure and adjust.Wait a couple of hours, and then measure the water temperature again at the farthest tap from the water heater. Several adjustments may be necessary before you get the temperature you desire.");
		pr1S.add(" Mark the new temperature.If you are satisfied with the temperature, mark the new temperature on the water heater thermostat with a marker, so that you can make adjustments in the future if necessary.");
		pr1S.add("Turn down or off when away.If you plan to be away from home for at least 3 days, turn the thermostat down to the lowest setting or completely turn off the water heater. To turn off an electric water heater, switch off the circuit breaker to it. For a gas water heater, make sure you know how to safely relight the pilot light before turning it off.");
		pro1 = new Project("Lower Water Heating Temperature", pr1M, pr1S,"desc", "Water", 2.0, 0);
		
		//setting up instructions and materials for project 2)
		//materials
		ArrayList<String> pr2M = new ArrayList<>();
		pr2M.add("Blanket insulation");
		pr2M.add("Wire fasteners");
		pr2M.add("Tape measure");
		pr2M.add("Sharp utility knife");
		pr2M.add("Caulk and foam sealant");
		pr2M.add("Caulk gun");
		pr2M.add("Stepladder");
		pr2M.add("Straightedge");
		pr2M.add("Respirator or dust mask");
		pr2M.add("Eye protection");
		pr2M.add("Protective clothing, including long-sleeved shirt, long pants, closed shoes, and gloves.");
		//steps
		ArrayList<String> pr2S = new ArrayList<>();
		pr2S.add("Double-check your insulation. Before opening the packages, verify that the insulation material is the correct width and R-value.");
		pr2S.add("Seal air gaps. Before insulating, carefully air seal gaps in the floor between the garage and the conditioned space as well as the garage and the outdoors (rim/band joists, for example). Use caulk for gaps smaller then ¼ inch and foam for gaps ¼ inch to 3 inches. In addition to improving energy efficiency, air sealing also helps keep exhaust fumes and other pollutants out of the conditioned space.");
		pr2S.add("Fit insulation between joists. Ensure insulation extends to the outside edge of each joist bay and is in contact with blocking or rim/band joist and the subfloor above. When using kraft-faced batts, install kraft facing against the conditioned side of the cavity. The kraft facing creates a vapor retarder that prevents trapped moisture from reducing the insulation's effectiveness.");
		pr2S.add(" Adjust insulation for a snug fit. Ensure ends of insulation are butted snugly together and in full contact with the subfloor of the conditioned space above.");
		pr2S.add("Fasten the insulation in place. Use wire fasteners to support the insulation so that it is in full contact with the subfloor but not compressed.");
		pro2 = new Project("Insulate and Air Seal Floors Over Unconditioned Garages", 
				pr2M, pr2S, "desc", "Electricity", 4.5, 500.00);

		//setting up instructions and materials for project 3)
		//materials
		ArrayList<String> pr3M = new ArrayList<>();
		pr3M.add("Storm window");
		pr3M.add("Tape measure");
		pr3M.add("Screwdriver");
		pr3M.add("Putty knife");
		pr3M.add("Caulk");
		pr3M.add("Caulking gun");
		//steps
		ArrayList<String> pr3S = new ArrayList<>();
		pr3S.add("Position the storm window into the opening to check for proper fit.");
		pr3S.add("Remove the storm window.");
		pr3S.add("Caulk the top and sides of the existing window opening. Do not caulk the bottom sill.");
		pr3S.add("Reposition the storm window into the opening.");
		pr3S.add("Adjust the expander on the bottom of the storm window.");
		pr3S.add("Square up the window unit, and then install the remaining installation screws.");
		pro3 = new Project("Install Exterior Storm Windows With Low-E Coating", 
				pr3M, pr3S, "desc", "Electricity", 2.5, 800.00);
				
	}
	
	
	/**
	 * Tests File Handler and implicitly tests UserData.
	 * @author Bryan Sands
	 */
	@Test
	public void testFileHandler() {
		String result = handler.getUserData().getUserName() + 
				" " + handler.getUserData().getUserEmail();
		assertEquals(result, "Cynthia Mora cyncyn@soupsaladbreadsticks.org");
		
	}
	
	
	/**
	 * Rule used to testing exception.
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	/**
	 * @author Cynthia Mora Olmedo
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testFileNotFoundExceptionImport() throws ClassNotFoundException, IOException{
		thrown.expect(FileNotFoundException.class);
		File fakeFile = new File("fakefile.diy");
		FileHandler h = new FileHandler(); 
	    h.importData(fakeFile);
	}
	
	/**
	 * @author Cynthia Mora Olmedo
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testFileNotFoundExceptionExport() throws ClassNotFoundException, IOException{
		thrown.expect(FileNotFoundException.class);
		File fakeFolder = new File("fakefolder");
		FileHandler h = new FileHandler(); 
	    h.exportData(fakeFolder);
	}
	/**
	 * Tests import and export with valid files names/ file paths. 
	 * @author Cynthia Mora Olmedo 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testImportExport() throws ClassNotFoundException, IOException{
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s);
		handler.exportData(file);
		handler.importData(new File(s + "\\UserData.diy"));
		assertEquals("Cynthia Mora", handler.getUserData().getUserName());
		
	}
	
	/**
	 * Tests the projectCompare function.
	 * @author Cassie Renz
	 */
	@Test
	public void testProjectCompare() {
		//Costs: Pro1 = 0, Pro2 = 500, Pro3 = 800
		assertEquals(1,Project.compareProjectPrice(pro3, pro2));
		assertEquals(-1,Project.compareProjectPrice(pro1, pro2));
		pro2.setTotalCost(0);
		assertEquals(0,Project.compareProjectPrice(pro1, pro2));
	}
	
	/**
	 * Tests the billCompare function.
	 * @author Stephanie Day
	 */
	@Test
	public void testCompareBillCost() {
		//Costs: testBill= 64.55 testBill2 = 30.05
		assertEquals(1,Bill.compareBillCost(testBill, testBill2));
		assertEquals(-1,Bill.compareBillCost(testBill2, testBill));
		testBill.setBillCost(testBill2.getBillCost());
		assertEquals(0,Bill.compareBillCost(testBill2, testBill));
	}
	
	/**
	 * Tests the validateInt static function from BillEntryPanel.
	 * @author Cynthia Mora Olmedo
	 */
	@Test
	public void testValidateInt() {
		assertEquals(1234,BillEntryPanel.validateInt("1234"));
		assertEquals(-1,BillEntryPanel.validateInt("s"));
	}
	
	/**
	 * Tests the validateDouble static function from BillEntryPanel.
	 * @author Cynthia Mora Olmedo
	 */
	@Test
	public void testValidateDouble() {
		assertEquals(1234.1234,BillEntryPanel.validateDouble("1234.1234"),0.000001);
		assertEquals(-1,BillEntryPanel.validateDouble("d"),0.000001);
	}
	
	/**
	 * Tests the validateArray static function from BillEntryPanel.
	 * @author Cynthia Mora Olmedo
	 */
	@Test
	public void testValidateArray() {
		String[] a = {"11","22","33"};
		assertArrayEquals(a,BillEntryPanel.validateArray(a));
		String[] b = {"1","3"} ;
		String[] c = new String[3];
		assertArrayEquals(c,BillEntryPanel.validateArray(b));
	}

}
