package model;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Grant
 * @version Something
 */
public class ControlPanel extends JPanel {
    
    /** This is the generated Serial Version UID. */
    private static final long serialVersionUID = 242412506268186828L;

    /** The default border size. */
    private static final  int BORDER_SIZE = 20;
    
    /**  */
    private final RaceControls myRace;
    
    /**
     * 
     */
    public ControlPanel() {
        super(new BorderLayout());
//        setBorder(BorderFactory.createEmptyBorder(
//                                BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        
        myRace = new ObservableRace();
        ((Observable) myRace).addObserver(new Observer() {
            @Override
            public void update(final Observable theObvservable, final Object theArguement) {
                System.out.println(theArguement);
            }
        });
        setUpComponents();
    }
    
    /**
     * Adds all the different panel components to the background. 
     */
    private void setUpComponents() {
        final JPanel background = new JPanel(new BorderLayout());

        background.setBorder(BorderFactory.createEmptyBorder(
                             BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        
        final PanelSlider slider = new PanelSlider();
        final PanelTab tab = new PanelTab();
        
        background.add(slider.createSlider(), BorderLayout.NORTH);
        background.add(tab.createTab(), BorderLayout.SOUTH);
        
//        final PanelToolBar toolBar = new PanelToolBar();
        
        
//        add(toolBar.createToolBar(), BorderLayout.SOUTH);
        
        add(background, BorderLayout.CENTER);
    }
    
    /**
     * 
     */
    public static void createAndShowGUI() {
//        Creates the main panel that holds everything.
        final JFrame frame = new JFrame("The Astonishing Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        Give the frame the correct icon image in the menu bar.
        ImageIcon mainIcon = new ImageIcon("./images/ic_main_icon.png");
        final Image sMainImage = mainIcon.getImage().getScaledInstance
                        (1000, -1,  java.awt.Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(sMainImage);
        frame.setIconImage(mainIcon.getImage());
        
//        Leave space for something here. 
       
        
//       Creates and sets up the content pane. 
        final ControlPanel controlPanel = new ControlPanel();
//        frame.setContentPane(controlPanel);
        controlPanel.setOpaque(true);
        frame.add(controlPanel, BorderLayout.CENTER);
        

//        need to figure out how to call menu for reasons
        final PanelMenu menuBar = new PanelMenu();
        frame.setJMenuBar(menuBar.createMenu(frame));
        
//        final PanelToolBar toolBar = new PanelToolBar();
//        frame.add(toolBar.createToolBar(), BorderLayout.SOUTH);

//        create a time panel to listen to and 
        
        frame.pack();
        frame.setVisible(true);
    }
}
