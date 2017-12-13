package view;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import model.Project;

public class ComparePanel extends JPanel{

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
		System.out.println(projectPanel.toString());

		jsp = new JScrollPane(compareTable);
		add(jsp);
	}

	public void populateArrays() {

		columnNames = new String[]{"Project Name", "Price", "Remove from comparisons?"};
		projectData = new Object[projectPanel.getComparisonCart().size()][3];
		compareTable = new JTable();
		System.out.println(projectPanel.getComparisonCart().size());
		int count = 0;
		for(Project p : projectPanel.getComparisonCart()) {
			System.out.println(p.getProjectName());
			projectData[count][0] = p.getProjectName();
			projectData[count][1] = p.getTotalCost();
			projectData[count][2] = new DefaultCellEditor(new JCheckBox());
			count++;
			jsp.revalidate();
		}
		DefaultTableModel model = new DefaultTableModel(columnNames, projectPanel.getComparisonCart().size());
		model.setDataVector(projectData, columnNames);
		compareTable.setModel(model);
		jsp.setViewportView(compareTable);
		jsp.revalidate();
	}

}
