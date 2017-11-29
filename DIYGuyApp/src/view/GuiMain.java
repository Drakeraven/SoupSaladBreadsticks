/*
 * TCSS 360
 */

package view;
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

    /**
     * Set the look and feel for the GUI program.
     */
    private static void setLookAndFeel() {
        
        try { 
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        
        } catch (final UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException");
        } catch (final ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (final InstantiationException e) {
            System.out.println("InstantiationException");
        } catch (final IllegalAccessException e) {
            System.out.println("IllegalAccessException");
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
