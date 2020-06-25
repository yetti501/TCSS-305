package model;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * 
 * @author Grant
 * @version Something
 */
public class PanelSlider extends JPanel {
    
    /** This is a constant number TEN = 10. */
    public static final int TEN = 10;
    
    /**
     * Creates the slider panel.
     * @return mySlider
     */
    public JPanel createSlider() {
        final JSlider slider = new JSlider();

        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(TEN);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
                
        final JLabel timeLabel = new JLabel("00:00:000");
        
        final JPanel sliderPanel  = new JPanel(new  BorderLayout());
        
        sliderPanel.add(slider, BorderLayout.CENTER);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sliderPanel.add(timeLabel, BorderLayout.EAST);
                
        return sliderPanel;
        
    }
}
