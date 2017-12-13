package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.Project;

/**
 * 
 * @author Bryan
 *
 */
public class OverviewPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4411770912151769813L;
	
	Project project;
	ProjectMenuPanel projectPanel;
	JLabel nameLbl;
	JTextArea descTA;
	
	/**
	 * Default Constructor. Initializes variables and configures the panel.
	 * @param projectMenuPanel 
	 */
	OverviewPanel(ProjectMenuPanel projectMenuPanel) {
		projectPanel = projectMenuPanel;
		setupPanel();
	}
	
	/**
	 * Initializes and configures UI elements on the panel.
	 * Pre-condition: Panel is void and without form
	 * Post-condition: Let there be light
	 */
	private void setupPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		nameLbl = new JLabel();
		JPanel pnlNorth = new JPanel(new GridLayout(1, 2));
		pnlNorth.add(new JLabel("Project Overview:"));
		pnlNorth.add(nameLbl);
		add(pnlNorth, BorderLayout.NORTH);
		descTA = new JTextArea();
		add(descTA, BorderLayout.CENTER);
		JButton learnButton = new JButton("Learn More");
		learnButton.addActionListener(this);
		add(learnButton, BorderLayout.SOUTH);
	}

	public void setProject(Project p) { 
		project = p;
		
		updateLabels();
		//todo: update lables/text fields
	}

	/**
	 * Updates UI elements on the panel based on the currently selected project.
	 * Pre-condition: User sends in a project to be viewed
	 * Post-condition: UI Elements are modified to diplay project information.
	 */
	private void updateLabels() {
		// TODO Auto-generated method stub
		nameLbl.setText(project.getProjectName());

		descTA.setText("Description: " + project.getDescription());
		descTA.append("\n");
		
		descTA.append("Price: $" + project.getTotalCost());
		descTA.append("\nTime: " + project.getEstimatedTime() + " hour");
		if(project.getEstimatedTime() > 1) {
			descTA.append("s");
		}
		
		repaint();
	}

	/**
	 * Pre-condition: User presses a button to go to the Learn More panel for their selected project
	 * Post-condition: Learn More panel is displayed, updated with currently selected project information.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(descTA.getText().length() != 0) {
			DIYGUI frame = (DIYGUI)SwingUtilities.getRoot(this);
			projectPanel.getLearnMorePanel().setProject(project);
			DIYGUI.changeMainPanel(frame, projectPanel.getLearnMorePanel());
		}
	}
}
