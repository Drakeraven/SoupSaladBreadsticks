package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 * This is a container for all GUI components
 * @author Cynthia Mora Olmedo
 *
 */
public class DIYGUI extends JFrame {
	
	/**
	 * Default serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**Toolbar for access to all menus of GUI.*/
	JToolBar diyToolbar;
	
	/** A size for the JFrame. */
    private static final Dimension FRAME_SIZE = new Dimension(400, 300);
    
	
	/** Main Menu Panel - log in, import,export. */
	//MainMenuPanel mainMenu;
	//ProjectMenuPanel projectMenu;
	//ComparePanel compare;
	//LearnMorePanel learnMore;
	//BillTrackerMenuPanel billTracker;
	//BillEntryPanel billEntry;
	
	/**
	 * Constructor for the DIY GUI frame.
	 */
	public DIYGUI() {
		super("DIY APP");
	}

	
	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_SIZE);
		setLocationRelativeTo(null);
		
		setVisible(true);
		setupGui();
	}
	
	/**
	 * Sets up all panels 
	 */
	private void setupGui() {
		
	}
	
	/**
     * @return a fully-stocked tool bar.
     */
    /*private JToolBar createToolBar() {
        final JToolBar bar = new JToolBar();
		return null;
    } */
}
