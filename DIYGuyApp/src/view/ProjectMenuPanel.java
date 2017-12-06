package view;

import java.awt.BorderLayout;

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
		this.setLayout(new BorderLayout());
		
		this.add(titleLbl);
		JScrollPane jsp = new JScrollPane();
		this.add(jsp, BorderLayout.NORTH);
		
	}
}
