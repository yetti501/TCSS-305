package model;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PanelTab extends JPanel{
    
    /** The number of rows in the text area. */
    private static final int TEXT_AREA_ROWS = 10;
    
    /** The number of columns in the text area. */
    private static final int TEXT_AREA_COLS = 50;
    
    /**
     * 
     * @return Something
     */
    public JPanel createTab() {
        JTextArea myTextArea = new JTextArea();
        final JTabbedPane daTabPane = new JTabbedPane();
        final JPanel tab1 = new JPanel(new BorderLayout());
        final JPanel tab2 = new JPanel(new BorderLayout());
        
    //    final JTextArea area1 = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
    //    area1.setEditable(false);
    //    tab1.add(area1);
    //    final JTextArea area2 = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLS);
    //    area2.setEditable(false);
    //    tab2.add(area2);
        
        
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
    
        daTabPane.setEnabledAt(0, true);
        daTabPane.setEnabledAt(1, true);
        return tabPanel; 
    }
}
