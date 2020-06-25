package model;

import java.util.Map;
/**
 * 
 * @author Grant
 * @version Something
 */
abstract class AbstractVehicle implements Vehicle {
    /**
     * The in that hold the x axis for the vehicle. 
     */
    private int myX;
    /**
     * The int that hold the y axis for the vehicle.
     */
    private int myY;
    /**
     * The int that hold the x axis for the reset of the vehicle. 
     */
    private int myNewX;   
    /**
     * the int that hold the y axis for the reset of the vehicle.
     */
    private int myNewY;
    /**
     * The direction variable that hold the new direction of a vehicle. 
     */
    private Direction myNewDirection;
    /**
     * The direction variable that hold the direction of a vehicle. 
     */
    private Direction myDir;
    /**
     * The boolean variable that holds the life value of a vehicle.
     */
    private boolean myAlive;
    /**
     * The variable that holds the total death time of a given vehicle. 
     */
    private int myDeathTime;
    /**
     * The death time counter used in the poke method. 
     */
    private int myDeathCounter;
    /**
     * 
     * @param theX The initial x value from where the human spawns on the map. 
     * @param theY The initial y value from where the human spawns on the map. 
     * @param theDir The initial direction the vehicle spawns looking.
     * @param theDeathTime The death time affiliated with a given vehicle. 
     */
    AbstractVehicle(final int theX, final int theY, final Direction theDir, 
                           final int theDeathTime) {
        myX = theX;
        myY = theY;
        myDir = theDir;
        myNewX = theX;
        myNewY = theY;
        myNewDirection = theDir;
        myAlive = true;
        myDeathTime = theDeathTime;
    }
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void collide(final Vehicle theOther) {
        // TODO Auto-generated method stub
        if (theOther.getDeathTime() < this.getDeathTime()) {
            this.myAlive = false;
        }
    }

    @Override
    public int getDeathTime() {
        // TODO Auto-generated method stub
        return myDeathTime;
    }

    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        if (!(isAlive())) {
            return getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }
        return getClass().getSimpleName().toLowerCase() + ".gif";
    }

    @Override
    public Direction getDirection() {
        // TODO Auto-generated method stub
        return myDir;
    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return myX;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return myY;
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return myAlive;
    }

    @Override
    public void poke() {
        // TODO Auto-generated method stub
        //int counter = 0;
        myDeathCounter++;
        if (myDeathCounter >= myDeathTime) {
            myAlive = true;
            Direction.random();
            myDeathCounter = 0;
        }   
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        setX(myNewX);
        setY(myNewY);
        setDirection(myNewDirection);
    }

    @Override
    public void setDirection(final Direction theDir) {
        // TODO Auto-generated method stub
        myDir = theDir;
    }

    @Override
    public void setX(final int theX) {
        // TODO Auto-generated method stub
        myX = theX;
    }

    @Override
    public void setY(final int theY) {
        // TODO Auto-generated method stub
        myY = theY;
    }

}
