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
	
	ProjectMenuPanel projectMenu;
	ComparePanel compare;
	LearnMorePanel learnMore;
	BillTrackerMenuPanel billTracker;
	BillEntryPanel billEntry;
	
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
		
		//projectMenu = new ProjectMenuPanel() ;
		
		//compare = new ComparePanel() ;
		
		//learnMore = new LearnMorePanel() ;
		
		//billTracker = new BillTrackerMenuPanel() ;
		
		//billEntry = new BillEntryPanel ;

	}

	/*private JToolBar createToolBar() {
    final JToolBar bar = new JToolBar();
	return null;
} */
	//getters and setters - so buttons and other panels can access panels
	
	/**
	 * @return the diyToolbar
	 */
	public final JToolBar getDiyToolbar() {
		return diyToolbar;
	}


	/**
	 * @param diyToolbar the diyToolbar to set
	 */
	public final void setDiyToolbar(JToolBar diyToolbar) {
		this.diyToolbar = diyToolbar;
	}


	/**
	 * @return the mainMenu
	 */
	public final SplashPanel getMainMenu() {
		return mainMenu;
	}


	/**
	 * @param mainMenu the mainMenu to set
	 */
	public final void setMainMenu(SplashPanel mainMenu) {
		this.mainMenu = mainMenu;
	}


	/**
	 * @return the projectMenu
	 */
	public final ProjectMenuPanel getProjectMenu() {
		return projectMenu;
	}


	/**
	 * @param projectMenu the projectMenu to set
	 */
	public final void setProjectMenu(ProjectMenuPanel projectMenu) {
		this.projectMenu = projectMenu;
	}


	/**
	 * @return the compare
	 */
	public final ComparePanel getCompare() {
		return compare;
	}


	/**
	 * @param compare the compare to set
	 */
	public final void setCompare(ComparePanel compare) {
		this.compare = compare;
	}


	/**
	 * @return the learnMore
	 */
	public final LearnMorePanel getLearnMore() {
		return learnMore;
	}


	/**
	 * @param learnMore the learnMore to set
	 */
	public final void setLearnMore(LearnMorePanel learnMore) {
		this.learnMore = learnMore;
	}


	/**
	 * @return the billTracker
	 */
	public final BillTrackerMenuPanel getBillTracker() {
		return billTracker;
	}


	/**
	 * @param billTracker the billTracker to set
	 */
	public final void setBillTracker(BillTrackerMenuPanel billTracker) {
		this.billTracker = billTracker;
	}


	/**
	 * @return the billEntry
	 */
	public final BillEntryPanel getBillEntry() {
		return billEntry;
	}


	/**
	 * @param billEntry the billEntry to set
	 */
	public final void setBillEntry(BillEntryPanel billEntry) {
		this.billEntry = billEntry;
	}


	/**
	 * @return the frameSize
	 */
	public static final Dimension getFrameSize() {
		return FRAME_SIZE;
	}
	
	/**
     * @return a fully-stocked tool bar.
     */
    
	
	
}
