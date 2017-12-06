package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.UserData;
import model.FileHandler;

/**
 * GUI Panel displaying the main home page of the DIYGuy App
 * @author Coder: Stephanie Day
 */
public class SplashPanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 7186465643558755364L;
	/** Constant for the size of the project/energy tracker buttons **/
	private static final Dimension BUTTON_SIZE = new Dimension(200,100);
	
	/** Constant for program window size **/
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private static JButton importButton;
	private static JButton exportButton;
	
	/** Instance of the class that handles import/exporting the program data. **/
	public static FileHandler programData;
	public static JFileChooser fileChooser;
	
	/**
	 * Constructor that creates the Splash Page window,
	 * and validates whether or not the program has an existing user.
	 * If not, prompts for new user data before displaying the Splash Page.
	 * Pre-condition: None.
	 * Post Condition: Initialized and visible Splash Panel.
	 */
	public SplashPanel() {
		
		setUpGui();
		fileChooser = new JFileChooser();

		try {
			programData = new FileHandler();
			
		} catch (FileNotFoundException ex) {
			programData = new FileHandler(newUserDialog());
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Where's the classes??");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Sets up Splash Page Frame 
	 *	Pre-Condition: None
	 *	Post-Condition: Splash Panel for GUI Frame. 
	 **/
	private void setUpGui() {
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		
		
		JPanel ButtonHolder = new JPanel(new GridLayout(1,2));
		((GridLayout)ButtonHolder.getLayout()).setHgap(20);
		//TODO Create actions for going to the projects and energy tracker windows
		JButton projectButton = new JButton("Projects");
		JButton EnergyButton = new JButton("Energy Tracker");
		projectButton.setPreferredSize(BUTTON_SIZE);
		EnergyButton.setPreferredSize(BUTTON_SIZE);
		ButtonHolder.add(projectButton);
		ButtonHolder.add(EnergyButton);
		constr.fill = GridBagConstraints.BOTH;
		constr.gridx = 0;
		constr.gridy = 0;
		constr.anchor = GridBagConstraints.PAGE_START;
		this.add(ButtonHolder);
	
	}
	
	/** Creates a separate panel for import export buttons
	 * to allow them to be displayed on multiple pages
	 * @return JPanel with the import/export buttons.
	 * Pre-Condition: None.
	 * Post-Condition: Panel containing functioning import/export buttons.
	 */
	public JPanel setupImportExportButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentY(BOTTOM_ALIGNMENT);
		importButton = new JButton("Import user");
		buttonPanel.add(importButton);
		exportButton = new JButton("Export User");
		buttonPanel.add(exportButton);
		
		setUpfileListeners();
		return buttonPanel;
	}
	
	/**
	 * If an existing user wasn't detected, this dialog
	 * displays first to gather information to generate a new user.
	 * pre-Condition: Did not find an existing ProgramData.diy
	 * Post-Condition: User Data to create new ProgramData.diy
	 * @return The New User Data for the program data file.
	 
	 */
	private UserData newUserDialog() {
		UserData newUserProgramData;
		JTextField enteredName = new JTextField(5);
		JTextField enteredEmail = new JTextField(5);
		
		JPanel fieldPanel = new JPanel(new GridLayout(8,1));
		fieldPanel.add(new JLabel("A New User!"));
		fieldPanel.add(new JLabel("Enter the info below to get started, or cancel to exit."));
		fieldPanel.add(new JLabel("Enter a name: "));
		fieldPanel.add(enteredName);
		fieldPanel.add(Box.createHorizontalStrut(15));
		fieldPanel.add(new JLabel("Enter an Email: "));
		fieldPanel.add(enteredEmail);
		fieldPanel.add(Box.createHorizontalStrut(15));
		String validEmail = null;
		
			int result = JOptionPane.showConfirmDialog(this, fieldPanel, 
					"Enter New User Information", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				validEmail = enteredEmail.getText();
			} else if (result == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
				
			} else if (result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			}
			
		 while (!validEmail.contains("@")) {
			JOptionPane.showMessageDialog(null, "Oops! Enter a valid email.");
			
			result = JOptionPane.showConfirmDialog(null, fieldPanel, 
					"Enter New User Information", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				validEmail = enteredEmail.getText();
			}
		}
		newUserProgramData = new UserData(enteredName.getText(), enteredEmail.getText());
		return newUserProgramData;
	}

	/**
	 * Class to set up the actions needed for the import/export buttons.
	 * Pre Condition: Inititalized import/export Jbuttons.
	 * Post-Condition: actions added to existing import/export Jbuttons.
	 */
	private void setUpfileListeners() {
		
		class fileListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
				if (theEvent.getSource() == importButton) {
					try {
						fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						final int selectedFile = fileChooser.showSaveDialog(null);
						if (selectedFile == JFileChooser.APPROVE_OPTION) {
							programData.importData(fileChooser.getSelectedFile());
						}
					} catch (ClassNotFoundException FileWahWah) {
		                JOptionPane.showMessageDialog(null,
		                        "What Happened to your .exe??", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
		                
					} catch (IOException fileWahWah) {
						JOptionPane.showMessageDialog(null,
		                        "Not a valid format. Be sure you've picked a .diy", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
					}
					
				} else if (theEvent.getSource() == exportButton) {
					try {
						fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						final int selectedFile = fileChooser.showSaveDialog(null);
						if (selectedFile == JFileChooser.APPROVE_OPTION) {
							programData.exportData(fileChooser.getSelectedFile());
						}
					} catch(IOException fileWahWah) {
		                JOptionPane.showMessageDialog(null,
		                        "Did you somehow select a bad directory?", 
		                        "Error!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				
			}
			
		}
		
		importButton.addActionListener(new fileListener());
		exportButton.addActionListener(new fileListener());
	}
	
	/**
	 * A Class to allow other classes to access the file's Program Data.
	 * Pre-Condition: Initialized FileHandler
	 * Post-Condition: returns reference to FileHandler.
	 * @return File Handler which contain's the program's User Data field.
	 */
	public FileHandler getFileHandler() {
		return programData;
	}
}
