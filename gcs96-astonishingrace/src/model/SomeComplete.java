package model;

/**
 * 
 * @author Grant
 * @version Something
 */
public class SomeComplete implements Messages {

    /**  */
    private static final String DELIMITER = ":";
    
    /**  */
    private final int myRacerID;
    
    /** */
    private final int myLap;
    
    /** */
    private final boolean myFinish;
    /**  */
    private final int myTimestamp;
    
    /**
     * 
     * @param theRacerID Something
     * @param theLap Something
     * @param theFinish Something
     * @param theTimestamp Something
     */
    public SomeComplete(final int theRacerID, final int theLap,
                             final boolean theFinish, final int theTimestamp) {
        myRacerID = theRacerID;
        myLap = theLap;
        myFinish = theFinish;
        myTimestamp = theTimestamp;
    }
    
    /**
     * 
     * @return myRacerID
     */
    public int getRacerID() {
        return myRacerID;
    }
    
    /**
     * 
     * @return mylap
     */
    public int getLap() {
        return myLap;
    }
    
    /**
     * 
     * @return myRacerID
     */
    public boolean getFinish() {
        return myFinish;
    }
    
    /**
     * 
     * @return myTimestamp 
     */
    public int getTimestamp() {
        return myTimestamp;
    }
    
    /**
     * 
     * @return string
     */
    public String toString() {
        return "$c" + getTimestamp() + DELIMITER + getRacerID() 
                        + DELIMITER + getLap() + DELIMITER + getFinish();
    }

    @Override
    public int compareTo(final Messages theO) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
