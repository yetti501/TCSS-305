package gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 * @author Grant
 * @version Something 
 */
public class TetrisGUI extends JPanel {
    
    

    /**
     * Generated UID version. 
     */
    private static final long serialVersionUID = -5683520608599598141L;

    public TetrisGUI(final JFrame theFrame) {
        super();
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        layoutComponents(theFrame);
    }
    
    private void layoutComponents(final JFrame theFrame) {
//        final JMenuBar menuBar = new JMenuBar();
        final TetrisMenuBar menuBar = new TetrisMenuBar();
        menuBar.createMenuBar(theFrame);
        
//        final JPanel gameBoard = new JPanel();
//        final TetrisGameBoard gameBoard = new TetrisGameBoard();
        
//        final JPanel nextPiecePanel = new JPanel();
//        final TetrisNextPiecePanel nextPiecePanel = new TetrisNextPiecePanel();
        
//        final JPanel controlPanel = new JPanel();
//        final TetrisControlPanel controlPanel = new TetrisControlPanel();
        
//        final JPanel controlButtons = new JPanel();
//        final TetrisControlButtons = new TetrisConrolButtons();
        
        theFrame.add(menuBar);
        
    }
    
    
    /**
     * 
     */
    public static void createAndShowGUI() {
        final JFrame frame = new JFrame("TETRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final TetrisGUI tetris = new TetrisGUI(frame);
        tetris.setOpaque(true);
        frame.setContentPane(tetris);
        
        frame.pack();
        frame.setVisible(true);
    }
    
}
