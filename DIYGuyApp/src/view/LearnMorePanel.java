package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
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
	JScrollPane stepScroll;
	JScrollPane matScroll;
	Project project;
	LearnMorePanel(ProjectMenuPanel projectPanel) {
		this.projectPanel = projectPanel;
		setupGUI();
	}

	private void setupGUI() {
		setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		projectLabel = new JLabel();
		projectLabel.setFont(new Font("Papyrus", 0, 20));
		JLabel plbl = new JLabel("Project Name");
		plbl.setForeground(Color.GREEN);
		titlePanel.add(plbl);
		titlePanel.add(projectLabel);
		
		setupTextPanel(titlePanel);
		
		addBtn = new JButton("Add To Compare");
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		buttonPanel.add(addBtn);
		
		JButton compareBtn = new JButton("Go To Comparisons");
		buttonPanel.add(compareBtn);
		
		addBtn.addActionListener(this);
		compareBtn.addActionListener(this);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}

	private void setupTextPanel(JPanel titlePanel) {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2,1));

		//setup them subpanels
		setupStepsPanel(textPanel);
		setupMatsPanel(textPanel);
		
		this.add(titlePanel, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
	}


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
		stepsPanel.add(stepScroll);
		textPanel.add(stepsPanel, BorderLayout.CENTER);
	}
	
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
		matScroll.getVerticalScrollBar().setValue(0);
		matsPanel.add(matScroll, BorderLayout.CENTER);
		textPanel.add(matsPanel);
	}

	public void setProject(Project project) {
		// TODO Auto-generated method stub
		this.project = project;
		updateLabels();
	}

	private void updateLabels() {
		projectLabel.setText(project.getProjectName());
		ArrayList<String> stepList = project.getSteps();

		int count = 0;
		for(String step : stepList) {
			count++;
			stepsArea.append(count + ". " + step + "\n\n");
		}
		count = 0;
		ArrayList<String> materialList = project.getMaterials();
		for(String material : materialList) {
			count++;
			materialsArea.append(count + ". " + material + "\n\n");
		}
		
		stepScroll.getVerticalScrollBar().setAutoscrolls(true);
		matScroll.getVerticalScrollBar().setValue(0);
		
		if(ProjectMenuPanel.getComparisonCart().contains(project)) {
			addBtn.setText("Remove From Compare");
		} else {
			addBtn.setText("Add To Compare");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		DIYGUI frame = (DIYGUI)SwingUtilities.getRoot(this);
		if(btnPressed.getText().equals("Add To Compare")) {
			if(!ProjectMenuPanel.getComparisonCart().contains(project)) {
				ProjectMenuPanel.addComparison(project);
				btnPressed.setText("Remove From Compare");
			}
			for (Project p : ProjectMenuPanel.getComparisonCart()) {
				System.out.println(p.getProjectName() + "\n");
			}
		} else if(btnPressed.getText().equals("Remove From Compare")) {
			if(ProjectMenuPanel.getComparisonCart().contains(project)) {
				ProjectMenuPanel.getComparisonCart().remove(project);
				btnPressed.setText("Add To Compare");
			}
		} else if(btnPressed.getText().equals("Go To Comparisons")) {
			System.out.println(projectPanel.toString());
			projectPanel.getComparePanel().populateArrays();
			DIYGUI.changeMainPanel(frame, projectPanel.getComparePanel());	
		}
	}
}
