package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Project;

public class OverviewPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4411770912151769813L;

	Project project;
	
	JLabel nameLbl;
	JTextArea descTA;
	
	OverviewPanel() {
		setupPanel();
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(descTA.getText().length() != 0) {
			JOptionPane.showMessageDialog(this, "this would be a learn more panel for\n" + project.getProjectName());
		}
	}
}
