package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Project;

public class ComparePanel extends JPanel implements ActionListener{

	/**
	 * @author Bryan Sands
	 * A panel to view the costs of multiple projects side-by-side in a table.
	 */
	private static final long serialVersionUID = 1L;
	private ProjectMenuPanel projectPanel;
	JScrollPane jsp;
	Object[][] projectData;
	String[] columnNames;
	
	JTable compareTable;
	ComparePanel(ProjectMenuPanel projectPanel) {
		this.projectPanel = projectPanel;
		setupGUI();
	}

	/**	
	 * Initializes and configures UI elements on the panel.
	 * Pre-condition: Panel is void and without form
	 * Post-condition: Let there be light
	 */
	
	private void setupGUI() {
		setLayout(new BorderLayout());
		jsp = new JScrollPane(compareTable);
		add(jsp, BorderLayout.CENTER);
		
		JButton learnMoreBtn = new JButton("Return to Learn More");
		learnMoreBtn.addActionListener(this);
		add(learnMoreBtn, BorderLayout.SOUTH);
	}

	/**
	 * Preconditon: A user has opened the ComparePanel
	 * Postconditon: The arrays which populate the JTable on ComparePanel will be filled with project information
	 */
	public void populateArrays() {

		columnNames = new String[]{"Project Name", "Price"};
		projectData = new Object[projectPanel.getComparisonCart().size()][2];
		compareTable = new JTable();
		int count = 0;
		for(Project p : projectPanel.getComparisonCart()) {
			projectData[count][0] = p.getProjectName();
			projectData[count][1] = p.getTotalCost();
			count++;
			jsp.revalidate();
		}
		DefaultTableModel model = new DefaultTableModel(columnNames, projectPanel.getComparisonCart().size());
		model.setDataVector(projectData, columnNames);
		compareTable.setModel(model);
		jsp.setViewportView(compareTable);
		jsp.revalidate();
	}
	

	/**
	 * Preconditon: The user has decided they want to go back to the LearnMorePanel and has clicked "Return to Learn More"
	 * PostConditon: The main panel is set as the LearnMorePanel 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DIYGUI frame = (DIYGUI) SwingUtilities.getRoot(this);
		DIYGUI.changeMainPanel(frame, projectPanel.getLearnMorePanel());
	}

}
