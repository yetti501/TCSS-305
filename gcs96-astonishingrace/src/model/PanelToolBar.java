package model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

//import model.actions.TimerControllAction;
//import model.actions.ToggleAction;
//import model.actions.UserDefinedAction;

/**
 * 
 * @author Grant
 * @version Something 
 */
public class PanelToolBar extends JToolBar {

    /** This is a constant variable name for RETART_PNG variable. */
    public static final String  RESTART_PNG = "./images/ic_restart.png";
    
    /** This is a constant variable name for PLAY_PNG variable. */
    public static final String PLAY_PNG = "./images/ic_play.png";
    
    /** This is a constant variable name for MULTIPLIER_1_PNG variable. */
    public static final String MULTIPLIER_1_PNG = "./images/ic_one_times.png";
    
    /** This is a constant variable name for MULTIPLIER_4_PNG variable. */
    public static final String MULTIPLIER_4_PNG = "./images/ic_four_times.png";
    
    /** This is a constant variable name for REPEAT_PNG variable. */
    public static final String REPEAT_PNG = "./images/ic_repeat.png";
    
    /** This is a constant variable name for REPEAT_COLOR_PNG variable. */
    public static final String REPEAT_COLOR_PNG = "./images/ic_repeat_color.png";
    
    /** This is a constant variable name for CLEAR_PNG variable. */
    public static final String CLEAR_PNG = "./images/ic_clear.png";
    
    /** Generated UID Number. */
    private static final long serialVersionUID = -3737473090775407442L;
    
    
    
    
    /**
     * 
     * @param theActions something
     */
    public PanelToolBar(final List<Action> theActions) {
        super();
        for (final Action a : theActions) {
            final JButton butt = new JButton(a);
            butt.setHideActionText(true);
            add(butt);
            addSeparator();
        }
        
    }
    /**
     * 
     * @return barPanel
     */
    public JToolBar createToolBar() {
        final JToolBar toolBar = new JToolBar();

        final JMenuItem restartItem = convertImage(RESTART_PNG);
        final JMenuItem playPauseItem = convertImage(PLAY_PNG);
        final JMenuItem oneFourItem = convertImage(MULTIPLIER_1_PNG);
        final JMenuItem singleLoopItem = convertImage(REPEAT_PNG);
        final JMenuItem clearItem = convertImage(CLEAR_PNG);
        
//        myActions = new ArrayList<>();
                
        toolBar.add(restartItem);
        toolBar.add(playPauseItem);
        toolBar.add(oneFourItem);
        toolBar.add(singleLoopItem);
        toolBar.add(clearItem);
        
        return toolBar;
    }
    
    /**
     * 
     */
    private void buildActions() {
//        final ToggleAction temp = new ToggleAction(" ", " ", " ", " ");
        
//        myActions.add(new ToggleAction("Multiplier 1", "Multipler 4", 
//                                       MULTIPLIER_1_PNG, MULTIPLIER_4_PNG));
    }   
    
    /**
     * 
     * @param theFileName something
     * @return tempItem
     */
    private JMenuItem convertImage(final String theFileName) {
        
        ImageIcon tempImage = new ImageIcon(theFileName);
        final Image sTempImage = tempImage.getImage().getScaledInstance
                        (24, -1, java.awt.Image.SCALE_SMOOTH);
        tempImage = new ImageIcon(sTempImage);
        final JMenuItem tempItem = new JMenuItem(tempImage);
        
        return tempItem;
        
    }
    
}
