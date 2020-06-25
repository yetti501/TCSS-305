package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * 
 * @author Grant
 * @version Something
 */
public class ToggleAction extends AbstractAction {

    /**  */
    private static final long serialVersionUID = -8984058429874084589L;

    /**  */
    protected boolean myFlag;
    
    /**  */
    private final String myFirstName;
    
    /**  */
    private final String mySecondName;
    
    /**  */
    private final ImageIcon myFirstIcon;
    
    /**  */
    private final ImageIcon mySecondIcon;
    
    /**
     * 
     * @param theFirstName something
     * @param theSecondName something
     * @param theFirstIcon something
     * @param theSecondIcon something
     */
    public ToggleAction(final String theFirstName,
                        final String theSecondName, 
                        final ImageIcon theFirstIcon,
                        final ImageIcon theSecondIcon) {
        myFirstName = theFirstName;
        mySecondName = theSecondName;
        myFirstIcon = theFirstIcon;
        mySecondIcon = theSecondIcon;
        myFlag = false;
        setIcon(myFirstIcon);
                        
    }
    
    @Override
    public void actionPerformed(final ActionEvent theArg0) {
        // TODO Auto-generated method stub
        myFlag = !myFlag;
        if (myFlag) {
            setIcon(mySecondIcon);
            putValue(Action.NAME, myFirstName);
        } else {
            setIcon(myFirstIcon);
            putValue(Action.NAME, myFirstName);
        }
    }
    
    /**
     * 
     * @param theIcon something
     */
    private void setIcon(final ImageIcon theIcon) {
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage = 
              icon.getImage().getScaledInstance(24,  -1,  java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        
        final Image smallImage = 
              icon.getImage().getScaledInstance(12, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon smallIcon = new ImageIcon(smallImage);
        putValue(Action.SMALL_ICON, smallIcon);
    }

}
