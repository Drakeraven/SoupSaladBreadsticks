package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Project;

public class LearnMorePanel extends JPanel {

	/**
	 * @author Bryan
	 */
	private static final long serialVersionUID = 1L;
	JLabel projectLabel;
	JTextArea stepsArea;
	JTextArea materialsArea;
	JScrollPane stepScroll;
	JScrollPane matScroll;
	Project project;
	LearnMorePanel() {
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
	}
}
