package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Project;

public class ProjectMenuPanel extends JPanel implements ActionListener{

	/**Default serial number*/
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 200;
	
	
	ArrayList<Project> pList;
	private JLabel titleLbl;
	private OverviewPanel dispPanel;
	public ProjectMenuPanel() {
		titleLbl = new JLabel("PROJECTS??");
		populateProjects();
		setupGUI();

	}

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
		
		dispPanel = new OverviewPanel();
		add(dispPanel, BorderLayout.SOUTH);

	}
	
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
		System.out.println(projectString);
	}
	
	private void populateProjects() {
		pList = new ArrayList<>();
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
		Project pro1 = new Project("Lower Water Heating Temperature", pr1M, pr1S, "Water", 2.0, 0);
		pList.add(pro1);
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
		Project pro2 = new Project("Insulate and Air Seal Floors Over Unconditioned Garages", 
				pr2M, pr2S, "Electricity", 4.5, 500.00);
		pList.add(pro2);
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
		Project pro3 = new Project("Install Exterior Storm Windows With Low-E Coating", 
				pr3M, pr3S, "Electricity", 2.5, 800.00);
		pList.add(pro3);
	}


}
