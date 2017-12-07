package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Project;

public class OverviewPanel extends JPanel{
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
	}

	public void setProject(Project p) { 
		project = p;
		
		//todo: update lables/text fields
	}
}
