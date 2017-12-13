package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import model.Project;

public class ComparePanel extends JPanel implements ActionListener{

	/**
	 * @author Bryan
	 * A panel for comparing (yes I need to write better documentation)
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

	private void setupGUI() {
		setLayout(new BorderLayout());
		jsp = new JScrollPane(compareTable);
		add(jsp, BorderLayout.CENTER);
		
		JButton learnMoreBtn = new JButton("Return to Learn More");
		learnMoreBtn.addActionListener(this);
		add(learnMoreBtn, BorderLayout.SOUTH);
	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		DIYGUI frame = (DIYGUI) SwingUtilities.getRoot(this);
		DIYGUI.changeMainPanel(frame, projectPanel.getLearnMorePanel());
	}

}
