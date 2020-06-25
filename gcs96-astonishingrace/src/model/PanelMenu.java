package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Grant
 * @version Something
 */
public class PanelMenu extends JPanel {

    /** This is a constant variable name for RETART_PNG variable. */
    public static final String  RESTART_PNG = "./images/ic_restart.png";
    
    /** This is a constant variable name for RESTART_STR variable. */
    public static final String RESTART_STR = "Restart";
    
    /** This is a constant variable name for PLAY_PNG variable. */
    public static final String PLAY_PNG = "./images/ic_play.png";
    
    /** This is a constant variable name for PLAY_STR variable. */
    public static final String PLAY_STR = "Play/Pause";
    
    /** This is a constant variable name for MULTIPLIER_1_PNG variable. */
    public static final String MULTIPLIER_1_PNG = "./images/ic_one_times.png";
    
    /** This is a constant variable name for MULTIPLIER_1_STR variable. */
    public static final String MULTIPLIER_1_STR = "Times one";
    
    /** This is a constant variable name for MULTIPLIER_4_PNG variable. */
    public static final String MULTIPLIER_4_PNG = "./images/ic_four_times.png";
    
    /** This is a constant variable name for Multiplier_4_STR variable. */
    public static final String MULTIPLIER_4_STR = "Times four";
    
    /** This is a constant variable name for REPEAT_PNG variable. */
    public static final String REPEAT_PNG = "./images/ic_repeat.png";
    
    /** This is a constant variable name for REPEAT_STR variable. */
    public static final String REPEAT_STR = "Repeat";
    
    /** This is a constant variable name for REPEAT_COLOR_PNG variable. */
    public static final String REPEAT_COLOR_PNG = "./images/ic_repeat_color.png";
    
    /** This is a constant variable name for REPEAT_COLOR_STR variable. */
    public static final String REPEAT_COLOR_STR = "Repeat Color";
    
    /** This is a constant variable name for CLEAR_PNG variable. */
    public static final String CLEAR_PNG = "./images/ic_clear.png";
    
    /** This is a constant variable name for CLEAR_STR variable. */
    public static final String CLEAR_STR = "Clear";
    
    /** The default border size. */
    private static final int BORDER_SIZE = 20;
    
    /** The generated UID Version. */
    private static final long serialVersionUID = 6608873714043276414L;
    
    /** This is the observable race.  */
    private ObservableRace myLoadRace;
    
/**
 * 
 * @param theFrame Something 
 * @return menuBar
 */
    public JMenuBar createMenu(final JFrame theFrame) {
        final JMenuBar menuBar = new JMenuBar();
        
        menuBar.add(buildFileMenu(theFrame));
        menuBar.add(buildControlMenu());
        menuBar.add(buildHelpMenu());
        
        return menuBar;
    }
    
    /**
     * Creates the file menu on the menu bar. 
     * @param theFrame something
     * @return fileMenu
     */
    private JMenu buildFileMenu(final JFrame theFrame) {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        final JMenuItem loadRaceItem = new JMenuItem("Load Race...");

        fileMenu.add(loadRaceItem);
        loadRaceItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final JFileChooser fileChooser = new JFileChooser("./race_files");
                final int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = fileChooser.getSelectedFile();
//                    System.out.println(selectedFile.getAbsolutePath());
                    myLoadRace = new ObservableRace();
                    try {
                        myLoadRace.loadRace(selectedFile);
                    } catch (final IOException e) {
                        final JFrame errorFrame = new JFrame();
                        JOptionPane.showMessageDialog(errorFrame, "Sum tin wong", "ERROR", 
                                                      JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        
        fileMenu.addSeparator();
        
        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        fileMenu.add(exitItem);
        
        return fileMenu;
    }
    
    /**
     * This method builds the control menu. 
     * @return controlMenu
     */
    private JMenu buildControlMenu() {
        final JMenu controlMenu = new JMenu("Controls");
        controlMenu.setMnemonic(KeyEvent.VK_C);
        
        final JMenuItem restartItem = convertImage(RESTART_PNG, RESTART_STR);
        final JMenuItem playPauseItem = convertImage(PLAY_PNG, PLAY_STR);
        final JMenuItem oneFourItem = convertImage(MULTIPLIER_1_PNG, MULTIPLIER_1_STR);
        final JMenuItem singleLoopItem = convertImage(REPEAT_PNG, REPEAT_STR);
        final JMenuItem clearItem = convertImage(CLEAR_PNG, CLEAR_STR);
        
        controlMenu.add(restartItem);
        controlMenu.add(playPauseItem);
        controlMenu.add(oneFourItem);
        controlMenu.add(singleLoopItem);
        controlMenu.add(clearItem);
        
        return controlMenu;
    }
    
    /**
     * 
     * @param theFileName something
     * @param theString something
     * @return tempItem
     */
    private JMenuItem convertImage(final String theFileName, final String theString) {
        
        ImageIcon tempImage = new ImageIcon(theFileName);
        final Image sTempImage = tempImage.getImage().getScaledInstance
                        (12, -1, java.awt.Image.SCALE_SMOOTH);
        tempImage = new ImageIcon(sTempImage);
        final JMenuItem tempItem = new JMenuItem(theString, tempImage);
        
        return tempItem;
        
    }
    
    /**
     * This method builds the help menu.
     * @return helpMenu
     */
    private JMenu buildHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        
        final JMenuItem raceInfoItem = new JMenuItem("Race Info...");
        final JMenuItem aboutItem = new JMenuItem("About...");

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final FrameAbout aboutFrame = new FrameAbout();
                aboutFrame.createAboutMe();
            }
        });
        
        
        
        
        helpMenu.add(raceInfoItem);
        helpMenu.add(aboutItem);
        
        return helpMenu;
    }
    
}
