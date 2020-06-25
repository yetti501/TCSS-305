package view;

import gui.TetrisGUI;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TertisMain {

    /**
     * Private empty constructor to avoid accidental instantiation. 
     */
//    private TetrisMain() { }
    
    public static void main(final String[] theArgs) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TetrisGUI.createAndShowGUI();
            }
        });
        
    }
}
