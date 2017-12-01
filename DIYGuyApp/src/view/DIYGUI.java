package view;

import java.awt.BorderLayout;
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
    private static final Dimension FRAME_SIZE = new Dimension(500, 500);
    
	
	/** Main Menu Panel - log in, import,export. */
	SplashPanel mainMenu;
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
		
		
		setupGui();
		setVisible(true);
	}
	
	/**
	 * Sets up all panels 
	 */
	private void setupGui() {
		mainMenu = new SplashPanel();
		this.add(mainMenu, BorderLayout.CENTER);
		this.add(mainMenu.setupImportExportButtons(), BorderLayout.SOUTH);

	}
	
	/**
     * @return a fully-stocked tool bar.
     */
    /*private JToolBar createToolBar() {
        final JToolBar bar = new JToolBar();
		return null;
    } */
}
