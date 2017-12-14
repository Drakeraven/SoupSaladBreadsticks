/**
 * 
 */
package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import view.DIYGUI;

/**
 * Action allows for switching to Energy Tracker stuff 
 * @author Cynthia Mora Olmedo
 *
 */
@SuppressWarnings("serial")
public final class EnergyTrackerAction extends AbstractAction{
	/**
	 * @param diygui GUI Frame
	 * 
	 */
	DIYGUI diy;

	public EnergyTrackerAction(DIYGUI diygui) {
		super("Energy Tracker");
		diy = diygui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DIYGUI.changeMainPanel(diy, diy.getBillTracker());
	}

}
