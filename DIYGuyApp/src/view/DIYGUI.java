package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import actions.EnergyTrackerAction;
import actions.ProjectsAction;

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
    static final Dimension FRAME_SIZE = new Dimension(500, 500);
    
	
	/**
	 * Panel used to hold the main panel at all moments
	 */
    JPanel myPanel;
    
    /** Main Menu Panel - log in, import,export. */
	SplashPanel mainMenu;
	ProjectMenuPanel projectMenu;
	ComparePanel compare;
	LearnMorePanel learnMore;

	BillTrackerMenuPanel billTracker;
	BillEntryPanel billEntry;
	//FileHandler handler;
  
	/**
	 * Constructor for the DIY GUI frame.
	 */
	public DIYGUI() {
		super("DIY APP");
	}

	/**
	 * Sets up the GUI components.
	 */
	public void start() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//handler = new FileHandler();
		
		//when window is closing, it overwrites user data.
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					//FileHandler.createProgramData();
		            System.exit(0);
		        }
		});
		setSize(FRAME_SIZE);
		setLocationRelativeTo(null);
		setupGui();
		setMinimumSize(FRAME_SIZE);
		setMaximumSize(FRAME_SIZE);
		//pack();
		setVisible(true);
	}
	
	
	/**
	 * Sets up all panels 
	 */
	private void setupGui() {

		mainMenu = new SplashPanel();
		projectMenu = new ProjectMenuPanel() ;
		compare = new ComparePanel() ;
		learnMore = new LearnMorePanel() ;
		billTracker = new BillTrackerMenuPanel() ;
		billEntry = new BillEntryPanel() ;
		createToolBar();
		//first visible panel is set
		myPanel = mainMenu;
		this.add(myPanel, BorderLayout.CENTER);
		this.add(( (SplashPanel) myPanel).setupImportExportButtons(), BorderLayout.SOUTH);
		mainMenu.projectButton.addActionListener(new ProjectsAction(this));
		mainMenu.energyButton.addActionListener(new EnergyTrackerAction(this));
	}
	
	/**
	 * Creates tool bar for DIY App.
	 * @return a tool bar
	 */
	private JToolBar createToolBar() {
	    final JToolBar bar = new JToolBar();
	    JButton billbtn = new JButton(new EnergyTrackerAction(this));
	    JButton projbtn = new JButton(new ProjectsAction(this));
	    bar.add(projbtn);
	    bar.add(billbtn);
	    add(bar,BorderLayout.PAGE_START);
		return null;
		}

	//getters and setters - so buttons and other panels can access panels
	
	/**
	 * Changes the displayed panel of the GUI
	 * @param d the DUIGUY Frame
	 * @param panel The panel we want to display
	 */
	public static void changeMainPanel(DIYGUI d, JPanel panel) {
		JPanel old = d.getMyPanel();
		d.remove(old);
		d.setMyPanel(panel);
		d.add(d.getMyPanel(),BorderLayout.CENTER);
		d.getMyPanel().repaint();
		d.repaint();
	}


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
	 * @return the myPanel
	 */
	public final JPanel getMyPanel() {
		return myPanel;
	}


	/**
	 * @param myPanel the myPanel to set
	 */
	public final void setMyPanel(JPanel myPanel) {
		this.myPanel = myPanel;
	}


	/**
	 * @return the frameSize
	 */
	public static final Dimension getFrameSize() {
		return FRAME_SIZE;
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
   
	
	
}
