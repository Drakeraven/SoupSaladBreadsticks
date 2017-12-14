package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.FileHandler;
import model.Project;
import model.UserData;

/**
 * The main Project Panel. Displays all selectable projects, and an overview of the currently selected project.
 * @author Bryan Sands
 *
 */
public class ProjectMenuPanel extends JPanel implements ActionListener{

	/**Default serial number*/
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	
	FileHandler fileHandler;
	UserData userData;
	ArrayList<Project> pList;
	public ArrayList<Project> comparisonCart = new ArrayList<>();
	
	private JLabel titleLbl;
	private OverviewPanel dispPanel;
	private ComparePanel compPanel;
	private LearnMorePanel learnMorePanel;
	public ProjectMenuPanel(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
		userData = fileHandler.getUserData();
		compPanel = new ComparePanel(this);
		titleLbl = new JLabel("PROJECTS");
		populateProjects();
		setupGUI();
	}
	
	/**
	 * Initializes and configures UI elements on the panel.
	 * Pre-condition: Panel is void and without form
	 * Post-condition: Let there be light
	 */
	private void setupGUI() {
		// TODO Auto-generated method stub
		setSize(WIDTH, HEIGHT);
		this.setLayout(new BorderLayout());
		
		this.add(titleLbl, BorderLayout.NORTH);
		JScrollPane jsp = new JScrollPane();
		JPanel spPanel = new JPanel(new GridLayout(pList.size(), 1));
		spPanel.setBorder(new EmptyBorder(getInsets()));
		populateProjectGrid(spPanel);
		jsp.setViewportView(spPanel);
		jsp.setMaximumSize(new Dimension(200, 200));
		this.add(jsp, BorderLayout.CENTER);
		
		dispPanel = new OverviewPanel(this);
		add(dispPanel, BorderLayout.SOUTH);

	}
	
	/**
	 * Helper method for setupPanel. 
	 * Populates the panel that contains the project overview.
	 * @param spPanel
	 */
	private void populateProjectGrid(JPanel spPanel) {
		for(Project p : pList) {
			JPanel miniProjectPanel = new JPanel(new GridLayout(1, 2));
			JPanel borderPanel = new JPanel(new BorderLayout());
			JButton btnProj = new JButton(p.getProjectName());
			
			btnProj.addActionListener(this);
			
			miniProjectPanel.add(btnProj);
			borderPanel.add(miniProjectPanel, BorderLayout.CENTER);
			spPanel.add(borderPanel);
		}
	}

	/**
	 * Precondition: user has clicked on a project they want to view
	 * Postcondition: the overview panel updates based on currently selected project information.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		String projectString = buttonPressed.getText();
		for(Project p : pList) {
			if(p.getProjectName().equals(projectString)) {
				dispPanel.setProject(p);
			}
		}
	}
	
	/**
	 * Precondition: Project list is empty.
	 * Postcondition: Project List is populated with projects. 
	 * Project text gathered by Cynthia. Thanks Cynthia!
	 */
	private void populateProjects() {
		pList = new ArrayList<>();
		//setting up instructions and materials for project 1)
		//materials
		String s1 = "Lower your energy bill by reducing your water heater temp!";
		ArrayList<String> pr1M = new ArrayList<>();
		pr1M.add("Thermometer for testing the water temperature");
		pr1M.add("Marker to mark the setting on your thermostat");
		//steps
		ArrayList<String> pr1S = new ArrayList<>();
		pr1S.add("Find the current temperature. Measure the beginning temperature of your hot water using a thermometer at the tap farthest from the water heater. Thermostat dials are often inaccurate");
		pr1S.add("Mark the setting, then turn down the thermostat.Mark the beginning temperature on your water heater thermostat with a marker, and then turn the thermostat down.");
		pr1S.add("Measure and adjust. Wait a couple of hours, and then measure the water temperature again at the farthest tap from the water heater. Several adjustments may be necessary before you get the temperature you desire.");
		pr1S.add(" Mark the new temperature.If you are satisfied with the temperature, mark the new temperature on the water heater thermostat with a marker, so that you can make adjustments in the future if necessary.");
		Project pro1 = new Project("Reduce Water Heater Temperature", pr1M, pr1S,s1, "Water", 1.0, 0);
		pList.add(pro1);
		//setting up instructions and materials for project 2)
		//materials
		String s2 = "Use climate control more effeciently by keeping hot/cold air out of your garage";
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
		pr2S.add("Seal air gaps. Before insulating, carefully air seal gaps in the floor between the garage and the conditioned space as well as the garage and the outdoors (rim/band joists, for example). Use caulk for gaps smaller then ¼ inch and foam for gaps ¼ inch to 3 inches.");
		pr2S.add("Fit insulation between joists. Ensure insulation extends to the outside edge of each joist bay and is in contact with blocking or rim/band joist and the subfloor above. ");
		pr2S.add("Adjust insulation for a snug fit. Ensure ends of insulation are butted snugly together and in full contact with the subfloor of the conditioned space above.");
		pr2S.add("Fasten the insulation in place. Use wire fasteners to support the insulation so that it is in full contact with the subfloor but not compressed.");
		Project pro2 = new Project("Insulate and Air Seal Floors", 
				pr2M, pr2S, s2, "Electricity", 4.5, 500.00);
		pList.add(pro2);
		//setting up instructions and materials for project 3)
		//materials
		String s3 = "Keep air from leaking outside by installing Storm Windows.";
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
		Project pro3 = new Project("Install Exterior Storm Windows", 
				pr3M, pr3S, s3, "Electricity", 2.5, 800.00);
		pList.add(pro3);
	}

	/**
	 * Precondition: User has indicated that they wish to start a project by clicking "start project" in relation to a project they are viewing
	 * Postcondition: Project name gets added to an ArrayList handled by UserData
	 * @param project
	 */
	public void addUserData(Project project) {
		userData.setProjectList(project.getProjectName());
	}
	
	/**
	 * Returns an ArrayList of currently worked on projects from UserData
	 * @return ArrayList of in-progress projects
	 */
	public ArrayList<String> getUserData () {
		return userData.getProjectList();
	}
	
	/**
	 * Pre-condition: A user has indicated that they want to compare a project by clicking "add to projects"
	 * Post-condition: The project is added to an ArrayList for comparison
	 * @param project the project to be added to the compare list
	 */
	public void addComparison(Project project) {
		comparisonCart.add(project);
	}
	
	/**
	 * Returns an ArrayList of all projects to be compared 
	 * @return ArrayList of 
	 */
	public ArrayList<Project> getComparisonCart() {
		return comparisonCart;
	}
	/**
	 * Returns the Compare panel - this is so that the GUI can return to that panel if the user wants to 
	 * @return ProjectMenuPanel's instance of ComparePanel
	 */
	public ComparePanel getComparePanel() {
		return compPanel;
	}
	/**
	 * Returns the LearnMore panel - this is so that the GUI can return to that panel if the user wants to 
	 * @return ProjectMenuPanel's instance of LearnMorePanel
	 */
	public LearnMorePanel getLearnMorePanel() {
		return learnMorePanel;
	}
	/**
	 * Precondition: user has decided they no longer want to work on a project and clicked "removed project"
	 * Postconditon: the name of the project is removed from the ArrayList in UserData
	 * @param project the project the user wishes to remove
	 */
	public void removeUserData(Project project) {
		// TODO Auto-generated method stub
		userData.removeProjectFromList(project.getProjectName());
	}
	/**
	 * Sets the instance of LearnMorePanel
	 * @param learnMorePanel the LearnMorePanel to be set
	 */
	public void setLearnMorePanel(LearnMorePanel learnMorePanel) {
		// TODO Auto-generated method stub
		this.learnMorePanel = learnMorePanel;
	}

}
