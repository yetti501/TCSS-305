package model;

/**
 * 
 * @author Grant
 * @version Something
 */
public class SomeRaceInformation implements Messages {

    /**  */
    private final String myRaceName;
    
    /**  */
    private final String myTrackType;
    
    /**  */
    private final int myWidth;
    
    /**  */ 
    private final int myHeight;
    
    /**  */
    private final int myDistance;
    
    /**  */
    private final int myTime;
    
    /**  */
    private final int myParticipants;
    
    /**
     * 
     * @param theRaceName something
     * @param theTrackType something
     * @param theWidth something 
     * @param theHeight something
     * @param theDistance something
     * @param theTime something
     * @param theParticipants something
     */
    public SomeRaceInformation(final String theRaceName,
                                   final String theTrackType,
                                   final int theWidth,
                                   final int theHeight,
                                   final int theDistance,
                                   final int theTime,
                                   final int theParticipants) {
        myRaceName = theRaceName;
        myTrackType = theTrackType;
        myWidth = theWidth;
        myHeight = theHeight;
        myDistance = theDistance;
        myTime = theTime;
        myParticipants = theParticipants;
                                
    }
    
    /**
     * 
     * @return myRaceName
     */
    public String getRaceName() {
        return myRaceName;
    }
    
    /**
     * 
     * @return myTrackType
     */
    public String getTrackType() {
        return myTrackType;
    }
    /**
     * 
     * @return myWidth
     */
    public int getWidth() {
        return myWidth;
    }
    
    /**
     * 
     * @return myHeight
     */
    public int getHeight() {
        return myHeight;
    }
    
    /**
     * 
     * @return myDistance
     */
    public int getDistance() {
        return myDistance;
    }
    
    /**
     * 
     * @return myTime 
     */
    public int getTime() {
        return myTime;
    }
    
    /**
     * 
     * @return myParticipants
     */
    public int getParticipants() {
        return myParticipants;
    }
    
    /**
     * 
     * @return toString
     */
    public String toString() {
        return getRaceName() + getTrackType() + getWidth() 
            + getHeight() + getDistance() + getTime() + getParticipants();
    }

    @Override
    public int compareTo(final Messages arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getRacerID() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getTimestamp() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
