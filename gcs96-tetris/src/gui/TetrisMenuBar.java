package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author Grant
 * @version Something
 */
public class TetrisMenuBar extends JMenuBar {

    /**
     * Generated UID version. 
     */
    private static final long serialVersionUID = 7861634915698354166L;
    
    public JMenuBar createMenuBar(final JFrame theFrame) {
        final JMenuBar menuBar = new JMenuBar();
        
        menuBar.add(buildFileMenu(theFrame));
        
        return menuBar;
    }
    
    private JMenu buildFileMenu(final JFrame theFrame) {
        final JMenu menu = new JMenu("File");
        
        menu.addSeparator();
        
        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        menu.add(exitItem);
        
        return menu;
    }
}
