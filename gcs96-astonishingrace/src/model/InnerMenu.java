package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.File;
import java.io.IOException;
/**
 * 
 * @author Grant
 * @version Something
 */
public class InnerMenu extends JPanel {

    /** This is a constant number TEN = 10. */
    public static final int TEN = 10;
    
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
        
    /** A generate serial version UID for object Serialization. */
    private static final long serialVersionUID = 8555278345779055446L;
    
    /** The default border size. */
    private static final  int BORDER_SIZE = 20;
    
    /** The number of rows in the text area. */
    private static final int TEXT_AREA_ROWS = 10;
    
    /** The number of columns in the text area. */
    private static final int TEXT_AREA_COLS = 50;
    /** A variable for calling a method from another class. */
    private LoadRacer myLoadRace;
    
    /** The variable where the output goes. */
    private final JTextArea myTextArea;
    
    /** 
     * This method sets up the main background. 
     * */
    public InnerMenu() {
        super(new BorderLayout());
        myTextArea = new JTextArea();
        setUpComponents();
    }

    /**
     * Adds all the different panel components to the background. 
     */
    private void setUpComponents() {
        final JPanel background = new JPanel(new BorderLayout());
        background.add(createSlider(), BorderLayout.NORTH);
        background.add(createTabPanel(), BorderLayout.SOUTH);
        background.setBorder(BorderFactory.createEmptyBorder(
                            BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        add(background);
        
        add(createToolBar(), BorderLayout.SOUTH);
        
//        add(myBarArea);
//        final JPanel innerPanel = new JPanel(new GridLayout(0, 1));
//        innerPanel.add(myTextArea);
//        
//        myTextArea.setEditable(false);
//        final JScrollPane scrollPane = new JScrollPane(myTextArea, 
//                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//                        
//        add(scrollPane);
//
//        final JScrollPane scrollPane = new JScrollPane(myTextArea);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        innerPanel.add(scrollPane);
//        
//        add(innerPanel, BorderLayout.CENTER);

    }
    
    /**
     * Creates the tab panel. 
     * @return tabPanel
     */
    private JPanel createTabPanel() {        
        final JTabbedPane daTabPane = new JTabbedPane();
        final JPanel tab1 = new JPanel(new BorderLayout());
        final JPanel tab2 = new JPanel(new BorderLayout());
        
//        final JTextArea area1 = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
//        area1.setEditable(false);
//        tab1.add(area1);
//        final JTextArea area2 = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
//        area2.setEditable(false);
//        tab2.add(area2);
        
        tab1.add(new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS));
        tab2.add(new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS));

        
        
        final  JPanel tabPanel = new JPanel(new BorderLayout());

        final JScrollPane scrollPane = new JScrollPane(myTextArea, 
                                     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tab1.add(scrollPane);
                
        daTabPane.add("Data Output Stream", tab1);
        daTabPane.add("Race Participants", tab2);
                
        tabPanel.add(daTabPane);
        
        //tabPanel.setPreferredSize(new Dimension(TEXT_AREA_ROWS, TEXT_AREA_COLS));

        daTabPane.setEnabledAt(0, false);
        daTabPane.setEnabledAt(1, false);
        return tabPanel; 
    }
//    /**
//     * 
//     * @param theText
//     * @return panel Something
//     */
//    private JComponent makeTextPanel(final String theText) {
//        final JPanel panel = new JPanel(false);
//        final JLabel filler = new JLabel(theText);
//        filler.setHorizontalAlignment(JLabel.CENTER);
//        panel.setLayout(new BorderLayout());
//        panel.add(filler);
//        return panel;
//    }
    
    /**
     * Creates the slider panel.
     * @return mySlider
     */
    private JPanel createSlider() {
        final JSlider slider = new JSlider();

        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(TEN);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(false);
        
        slider.setEnabled(false);
        
        final JLabel timeLabel = new JLabel("00:00:000");
        
        final JPanel sliderPanel  = new JPanel(new  BorderLayout());
        
        sliderPanel.add(slider, BorderLayout.CENTER);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sliderPanel.add(timeLabel, BorderLayout.EAST);
        
        sliderPanel.setEnabled(false);
        
        return sliderPanel;
        
    }
    
    /**
     * Creates the tool bar panel. 
     * @return Something
     */
    private JToolBar createToolBar() {
        final JToolBar toolBar = new JToolBar();
        
        ImageIcon restartIcon = new ImageIcon(RESTART_PNG);
        final Image restartImage = restartIcon.getImage().getScaledInstance
                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
        restartIcon = new ImageIcon(restartImage);
        final JButton restartButton = new JButton(restartIcon);
        toolBar.add(restartButton);
        
        ImageIcon playIcon = new ImageIcon(PLAY_PNG);
        final Image playImage = playIcon.getImage().getScaledInstance
                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
        playIcon = new ImageIcon(playImage);
        final JButton playButton = new JButton(playIcon);
        toolBar.add(playButton);
        
        ImageIcon multiplier1Icon = new ImageIcon(MULTIPLIER_1_PNG);
        final Image multiplier1Image = multiplier1Icon.getImage().getScaledInstance
                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
        multiplier1Icon = new ImageIcon(multiplier1Image);
        final JButton multiplier1Button = new JButton(multiplier1Icon);
        toolBar.add(multiplier1Button);
        
        /*
         * Multiplie 4 time toolbar. 
         */
//        ImageIcon multiplier4Icon = new ImageIcon(MULTIPLIER_4_PNG);
//        final Image multiplier4Image = multiplier4Icon.getImage().getScaledInstance
//                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
//        multiplier4Icon = new ImageIcon(multiplier4Image);
//        final JButton multiplier4Button = new JButton(multiplier4Icon);
//        toolBar.add(multiplier4Button);
        
        
//        multiplier1Button.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent theEvent) {
//                boolean hasBeenSet = false;
//                if (theEvent.getSource() == multiplier1Button) {
//                    if (!hasBeenSet) {
//                        toolBar.add(multiplier1Button);
//                        hasBeenSet = true;
//                    } else {
//                        toolBar.add(multiplier4Button);
//                        hasBeenSet = false;
//                    }
//                    
//                }
//            }
//        });
        

        ImageIcon repeatIcon = new ImageIcon(REPEAT_PNG);
        final Image repeatImage = repeatIcon.getImage().getScaledInstance
                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
        repeatIcon = new ImageIcon(repeatImage);
        final JButton repeatButton = new JButton(repeatIcon);
        toolBar.add(repeatButton);
        
        /*
         * Repeat click button. 
         */
//        ImageIcon repeatColorIcon = new ImageIcon(REPEAT_COLOR_PNG);
//        final Image repeatColorImage = repeatColorIcon.getImage().getScaledInstance
//                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
//        repeatColorIcon = new ImageIcon(repeatColorImage);
//        final JButton repeatColorButton = new JButton(repeatColorIcon);
//        toolBar.add(repeatColorButton);
        
        ImageIcon clearIcon = new ImageIcon(CLEAR_PNG);
        final Image clearImage = clearIcon.getImage().getScaledInstance
                        (24, -1,  java.awt.Image.SCALE_SMOOTH);
        clearIcon = new ImageIcon(clearImage);
        final JButton clearButton = new JButton(clearIcon);
        toolBar.add(clearButton);
        
        restartButton.setEnabled(false);
        playButton.setEnabled(false);
        multiplier1Button.setEnabled(false);
        repeatButton.setEnabled(false);
        clearButton.setEnabled(false);
        
//        if (SET_ENABLE) {
//            restartButton.setEnabled(true);
//            playButton.setEnabled(true);
//            multiplier1Button.setEnabled(true);
//            repeatButton.setEnabled(true);
//            clearButton.setEnabled(true);
//        }
        return toolBar;
    }
    
    /**
     * Creates the menu inside the frame. 
     * @param theFrame something
     * @return menuBar
     */
    final JMenuBar createMenu(final JFrame theFrame) {
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
                    myLoadRace = new LoadRacer();
                    setEnable();
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
     * This is a helping method for switching the values of the buttoms from false to true. 
     * @return boolean
     */
    public boolean setEnable() {
        return true;
    }
    /**
     * This method builds the control menu. 
     * @return controlMenu
     */
    private JMenu buildControlMenu() {
        final JMenu controlMenu = new JMenu("Controls");
        controlMenu.setMnemonic(KeyEvent.VK_C);
        
        ImageIcon restartImage = new ImageIcon(RESTART_PNG);
        final Image sRestartImage = restartImage.getImage().getScaledInstance
                        (12,  -1, java.awt.Image.SCALE_SMOOTH);
        restartImage = new ImageIcon(sRestartImage);
        final JMenuItem restartItem = new JMenuItem("Restart", restartImage);
        
        ImageIcon playImage = new ImageIcon(PLAY_PNG);
        final Image sPlayImage = playImage.getImage().getScaledInstance
                        (12,  -1, java.awt.Image.SCALE_SMOOTH);
        playImage = new ImageIcon(sPlayImage);
        final JMenuItem playPauseItem = new JMenuItem("Play/Pause", playImage);
        
        ImageIcon oneFourImage = new ImageIcon(MULTIPLIER_1_PNG);
        final Image sOneFourImage = oneFourImage.getImage().getScaledInstance
                        (12,  -1, java.awt.Image.SCALE_SMOOTH);
        oneFourImage = new ImageIcon(sOneFourImage);
        final JMenuItem oneFourItem = new JMenuItem("Times One/Times Four", oneFourImage);
        
        ImageIcon singleLoopImage = new ImageIcon(REPEAT_PNG);
        final Image sSingleLoopImage = singleLoopImage.getImage().getScaledInstance
                        (12,  -1, java.awt.Image.SCALE_SMOOTH);
        singleLoopImage = new ImageIcon(sSingleLoopImage);
        final JMenuItem singleLoopItem = new JMenuItem("Single Race/Loop Race", 
                                                       singleLoopImage);
        
        ImageIcon clearImage = new ImageIcon(CLEAR_PNG);
        final Image sClearImage = clearImage.getImage().getScaledInstance
                        (12,  -1, java.awt.Image.SCALE_SMOOTH);
        clearImage = new ImageIcon(sClearImage);
        final JMenuItem clearItem = new  JMenuItem("Clear", clearImage);
        
        controlMenu.add(restartItem);
        restartItem.setEnabled(false);
        controlMenu.add(playPauseItem);
        playPauseItem.setEnabled(false);
        controlMenu.add(oneFourItem);
        oneFourItem.setEnabled(false);
        controlMenu.add(singleLoopItem);
        singleLoopItem.setEnabled(false);
        controlMenu.add(clearItem);
        clearItem.setEnabled(false);
        
        return controlMenu;
    }

    /**
     * This method builds the help menu.
     * @return helpMenu
     */
    private JMenu buildHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        
        final JMenuItem raceInfoItem = new JMenuItem("Race Info...");
        final JMenuItem aboutItem = new JMenuItem("About...");
        
        helpMenu.add(raceInfoItem);
        raceInfoItem.setEnabled(false);
        helpMenu.add(aboutItem);
        aboutItem.setEnabled(false);
        
        return helpMenu;
    }
    
    
    /**
     * This is the main method. 
     * @param theArgs Something
     */
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
        
        UIManager.put("swing.boldMetal",  Boolean.FALSE);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
//                System.out.println("Something");
            }
        });   
    }
    
    /**
     * This creates and kicks off the GUI interface. 
     */
    private static void createAndShowGUI() {
        final JFrame frame = new JFrame("The Astonishing Race");

        ImageIcon mainIcon = new ImageIcon("./images/ic_main_icon.png");
        final Image sMainImage = mainIcon.getImage().getScaledInstance
                        (1000, -1,  java.awt.Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(sMainImage);
        frame.setIconImage(mainIcon.getImage());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final InnerMenu newContentPane = new InnerMenu();
        newContentPane.setOpaque(true);
//        frame.setContentPane(newContentPane);
        frame.add(newContentPane);
        frame.setJMenuBar(newContentPane.createMenu(frame));
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
