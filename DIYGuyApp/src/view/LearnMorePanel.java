package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.Project;

public class LearnMorePanel extends JPanel implements ActionListener {

	/**
	 * @author Bryan
	 */
	private static final long serialVersionUID = 1L;
	ProjectMenuPanel projectPanel;
	JLabel projectLabel;
	JTextArea stepsArea;
	JTextArea materialsArea;
	JButton addBtn;
	JButton startButton;
	JScrollPane stepScroll;
	JScrollPane matScroll;
	Project project;
	LearnMorePanel(ProjectMenuPanel projectPanel) {
		this.projectPanel = projectPanel;
		setupPanel();
	}

	/**
	 * Initializes and configures UI elements on the panel.
	 * Pre-condition: Panel is void and without form
	 * Post-condition: Let there be light
	 */
	private void setupPanel() {
		setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		projectLabel = new JLabel();
		projectLabel.setFont(new Font("Arial", 0, 16));
		JLabel plbl = new JLabel("Project Name");
		plbl.setForeground(Color.gray);
		titlePanel.add(plbl);
		titlePanel.add(projectLabel);
		
		setupTextPanel(titlePanel);
		
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
		
		startButton = new JButton("Start Project");
		buttonPanel.add(startButton);
		
		addBtn = new JButton("Add To Compare");
		buttonPanel.add(addBtn);
		
		JButton compareBtn = new JButton("Go To Comparisons");
		buttonPanel.add(compareBtn);
		
		JButton menuButton = new JButton("Return to Project List");
		buttonPanel.add(menuButton);
		
		startButton.addActionListener(this);
		addBtn.addActionListener(this);
		compareBtn.addActionListener(this);
		menuButton.addActionListener(this);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Helper method for SetupPanel. 
	 * Pre-condition: The panel that contains the TextBoxes is not set up.
	 * Post-condition: The panel that contains the TextBoxes is configured and contains 2 textboxes for viewing project details.
	 * @param titlePanel
	 */
	private void setupTextPanel(JPanel titlePanel) {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2,1));

		//setup them subpanels
		setupStepsPanel(textPanel);
		setupMatsPanel(textPanel);
		
		this.add(titlePanel, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
	}

	/**
	 * Helper method for SetupPanel
	 * Pre-conditon: The panel that contains the Project Steps text box is not set up.
	 * Post-condition: The panel that contains the Project Steps text box is set up and contains a textbox for viewing project steps.
	 * @param textPanel
	 */
	private void setupStepsPanel(JPanel textPanel) {
		JPanel stepsPanel = new JPanel(new BorderLayout());
		stepsPanel.add(new JLabel("Steps: "), BorderLayout.NORTH);
		stepsArea = new JTextArea();
		stepsArea.setEditable(false);
		stepsArea.setFocusable(false);
		stepScroll = new JScrollPane(stepsArea);
		stepsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		stepsArea.setLineWrap(true);
		stepsArea.setWrapStyleWord(true);
		stepScroll.getVerticalScrollBar().setValue(0);
		stepsPanel.add(stepScroll);
		textPanel.add(stepsPanel, BorderLayout.CENTER);
	}
	
	/**
	 * helper method for SetupPanel
	 * Pre-conditon: The panel that contains the Project Materials text box is not set up.
	 * Post-condition: The panel that contains the Project Materials text box is set up and contains a textbox for viewing project materials.
	 * @param textPanel
	 */
	private void setupMatsPanel(JPanel textPanel) {
		JPanel matsPanel = new JPanel(new BorderLayout());
		matsPanel.add(new JLabel("Materials: "), BorderLayout.NORTH);
		materialsArea = new JTextArea();
		materialsArea.setEditable(false);
		materialsArea.setFocusable(false);
		matScroll = new JScrollPane(materialsArea);
		materialsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		materialsArea.setLineWrap(true);
		materialsArea.setWrapStyleWord(true);

		matsPanel.add(matScroll, BorderLayout.CENTER);
		matScroll.getVerticalScrollBar().setValue(0);
		textPanel.add(matsPanel);
	}

	public void setProject(Project project) {
		// TODO Auto-generated method stub
		this.project = project;
		updateLabels();
	}

	/**
	 * Updates UI elements on the panel based on the currently selected project.
	 * Pre-condition: User sends in a project to be viewed
	 * Post-condition: UI Elements are modified to diplay project information.
	 */
	private void updateLabels() {
		projectLabel.setText(project.getProjectName());
		ArrayList<String> stepList = project.getSteps();
		
		stepsArea.setText("");
		materialsArea.setText("");
		int count = 0;
		if(!stepsArea.getText().contains(stepList.get(0))) {

			for(String step : stepList) {
				count++;
				stepsArea.append(count + ". " + step + "\n\n");
			}
		}

		count = 0;
		ArrayList<String> materialList = project.getMaterials();
		if(!materialsArea.getText().contains(materialList.get(1))) {
			for(String material : materialList) {
				count++;
				materialsArea.append(count + ". " + material + "\n\n");
			}
		}
		
		stepScroll.getVerticalScrollBar().setValue(0);
		matScroll.getVerticalScrollBar().setValue(0);
		
		if(projectPanel.getComparisonCart().contains(project)) {
			addBtn.setText("Remove From Compare");
		} else {
			addBtn.setText("Add To Compare");
		}
		
		if(projectPanel.getUserData().contains(project.getProjectName())) {
			//System.out.println("true");
			startButton.setText("Project in progress. Stop project?");
		} else {
			//System.out.println("false");
			startButton.setText("Start Project");
		}
		for(String s : projectPanel.getUserData()) {
			//System.out.println(s);
		}
		revalidate();
		repaint();
	}
	
	/**
	 * Handles the various buttons on the panel.
	 * Pre-condition: button was pressed by user to either add a project to the comparison list, add a project to the list of projects they're working on, or to see the comparison list
	 * Post-condition: panel repsonds accordingly based on button pressed. 
	 * @param e The button that was pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		DIYGUI frame = (DIYGUI)SwingUtilities.getRoot(this);
		if(btnPressed.getText().equals("Add To Compare")) {
			if(!projectPanel.getComparisonCart().contains(project)) {
				projectPanel.addComparison(project);
				btnPressed.setText("Remove From Compare");
			}
		} else if(btnPressed.getText().equals("Remove From Compare")) {
			if(projectPanel.getComparisonCart().contains(project)) {
				projectPanel.getComparisonCart().remove(project);
				btnPressed.setText("Add To Compare");
			}
		} else if(btnPressed.getText().equals("Go To Comparisons")) {
			projectPanel.getComparePanel().populateArrays();
			DIYGUI.changeMainPanel(frame, projectPanel.getComparePanel());	
		} else if(btnPressed.getText().equals("Start Project")) {
			if(!projectPanel.getUserData().contains(project.getProjectName())) {
				projectPanel.addUserData(project);
				btnPressed.setText("Project in progress. Stop project?");
			} 
		} else if(btnPressed.getText().equals("Project in progress. Stop project?")) {
			if(projectPanel.getUserData().contains(project.getProjectName())) {
				projectPanel.removeUserData(project);
				btnPressed.setText("Start Project");
			} 
		} else if(btnPressed.getText().equals("Return to Project List")) {
			DIYGUI.changeMainPanel(frame, projectPanel);
		}
	}
}
