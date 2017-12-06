/**
 * 
 */
package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import view.DIYGUI;

/**
 * @author Cynthia Mora Olmedo
 *
 */
@SuppressWarnings("serial")
public final class EnergyTrackerAction extends AbstractAction{
	DIYGUI diy;
	/**
	 * @param diygui 
	 * 
	 */
	public EnergyTrackerAction(DIYGUI diygui) {
		super("Energy Tracker");
		diy = diygui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DIYGUI.changeMainPanel(diy, diy.getBillTracker());
	}

}
