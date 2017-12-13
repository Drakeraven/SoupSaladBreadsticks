/*
 * TCSS 360
 */

package view;
import java.awt.EventQueue;

import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

/**
 * This program starts the DIY App
 * 
 * @author (collaboration) Stephanie​ ​Day,​ ​Bryan​ ​Sands,​ ​Cassie​ ​Renz,​ ​Cynthia​ ​Mora​ ​Olmedo 
 * @author (class) Cynthia Mora Olmedo
 */
public final class GuiMain {

    /**
     * A private constructor to inhibit external instantiation.
     */
    private GuiMain() {
        // do nothing
    }
    /*
    /**
     * Set the look and feel for the GUI program.
     */
    private static void setLookAndFeel() {
        /*
         * In the Referenced Libraries, all files needed to run Synthetica are stored there
         * 
         * Look and Feel credit to JyLoo Software
         * http://www.jyloo.com/synthetica/themes/
         * This program is not for commercial use.
         * 
         */

        try 
        {
          UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }
        
    } 

    /**
     * Main function that starts App
     * @param args command line arguments - ignored in this program
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLookAndFeel();
                new DIYGUI().start();

            }
        });
    }

}
