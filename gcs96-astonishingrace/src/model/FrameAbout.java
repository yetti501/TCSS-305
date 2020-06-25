package model;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Grant
 * @version Something
 */
public class FrameAbout extends JFrame {
    
    /** Generated UID version. */
    private static final long serialVersionUID = -1859688990028663347L;
    /**
     * 
     */
    private static final int BORDER_SIZE = 20;
    
    /**
     * 
     * @return aboutFrame
     */
    public JFrame createAboutMe() {
        final JFrame aboutFrame = new JFrame("About The Astonishing Race");
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel aboutPanel = new JPanel(new BorderLayout());
        
        aboutPanel.setBorder(BorderFactory.createEmptyBorder(
                             BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));

        final ImageIcon aboutPicture = new ImageIcon("./ic_main_icon.png");
        final Image aboutImage = aboutPicture.getImage();
        
        
        final JLabel aboutLabel = new JLabel();
        
        aboutLabel.setIcon(aboutImage);
        
        aboutPanel.add(aboutLabel);
        add(aboutPanel);
        
        
        
//        this.add(aboutFrame);
        this.pack();
        this.setVisible(true);
        
        return aboutFrame;
        
    }

}
