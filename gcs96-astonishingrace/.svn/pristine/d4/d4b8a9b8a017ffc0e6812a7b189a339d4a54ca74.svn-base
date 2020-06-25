package model;

/**
 * 
 * @author Grant
 * @version Something
 */
public class SomeLeaderboard implements Messages {

    /**  */
    private static final String DELIMITER = ":";
    /**  */
    private final int myRacerID;
    /**  */
    private final int myTimestamp;
    /**
     * 
     * @param theRacerID Something
     * @param theTimestamp Something 
     */
    public SomeLeaderboard(final int theRacerID, final int theTimestamp) {
        myRacerID = theRacerID;
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
        return "$L" + getTimestamp() + DELIMITER + getRacerID();
    }

    @Override
    public int compareTo(final Messages theO) {
        // TODO Auto-generated method stub
        return 0;
    }
}
