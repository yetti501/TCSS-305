package model;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Grant
 * @version Something
 */
public class RaceControllerGUI extends JPanel {

    /**
     * A generated serial version UID for object Serialization. 
     */
    private static final long serialVersionUID = 8754115316673973909L;
    
    /**
     * The default width value.
     */
    private static final int WIDTH = 400;
    
    /**
     * The default height value. 
     */
    private static final int HEIGHT = 600;
    
    /**
     * The minimum size this component should be.
     */
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, HEIGHT);
    
/**
 * Makes the main frame where everything sits. 
 * @param theColor The color of the frame
 */
    public RaceControllerGUI(final Color theColor) {
        super();
        setBackground(theColor);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public Dimension getMinimumSize() {
        return MIN_SIZE;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return MIN_SIZE;
    }
    
}
