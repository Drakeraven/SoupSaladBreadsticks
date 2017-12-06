package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Project;

public class ProjectMenuPanel extends JPanel{

	/**Default serial number*/
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	
	private Project[] projects;
	private JLabel titleLbl;
	private JTable projectTbl;
	
	public ProjectMenuPanel() {
		titleLbl = new JLabel("PROJECTS");
		titleLbl.setSize(WIDTH/2, HEIGHT/20);
		populateProjects();
		setupGUI();

	}

	private void populateProjects() {
		// TODO I need an updated project class to do this
		
	}

	private void setupGUI() {
		// TODO Auto-generated method stub
		setSize(WIDTH, HEIGHT);
		
		
		this.add(titleLbl);
		String[] columnNames = {"",
				"",
				""};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		projectTbl = new JTable(data,columnNames);
		JScrollPane jsp = new JScrollPane(projectTbl);
		this.add(jsp);
		
	}
}
