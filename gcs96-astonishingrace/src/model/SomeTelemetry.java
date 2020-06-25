package model;

/**
 * 
 * @author Grant
 * @version Something
 */
public class SomeTelemetry implements Messages {

    /**  */
    private static final String DELIMITER = ":";
    /**  */
    private final int myRacerID;
    /**  */
    private final double myDistance;
    /**  */
    private final int myLap;
    /**  */
    private final int myTimestamp;
    /**
     * 
     * @param theTimeStamp something
     * @param theRacerID something
     * @param theDistance something
     * @param theLap something
     */
    public SomeTelemetry(final int theTimeStamp, final int theRacerID, 
                         final double theDistance, final int theLap) {
        myTimestamp = theTimeStamp;
        myRacerID = theRacerID;
        myDistance = theDistance;
        myLap = theLap;
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
     * @return myDistance
     */
    public double getDistance() {
        return myDistance;
    }
    
    /**
     * 
     * @return myLap
     */
    public int getLap() {
        return myLap;
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
        return "$T" + getTimestamp() + DELIMITER + getRacerID() + DELIMITER 
                        + getDistance() + DELIMITER + getLap();
    }

    @Override
    public int compareTo(final Messages theO) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
