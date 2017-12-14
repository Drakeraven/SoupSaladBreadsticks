/**
 * 
 */
package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import view.DIYGUI;

/**
 * Action allows to change the panel to the Project Previews.
 * @author Cynthia Mora Olmedo
 *
 */
public final class ProjectsAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111009312971731357L;
	DIYGUI diy;
	/**
	 * @param jPanel 
	 * 
	 */
	public ProjectsAction( DIYGUI diygui) {
		super("Projects");

		diy = diygui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DIYGUI.changeMainPanel(diy, (JPanel) diy.getProjectMenu());
	}

}
