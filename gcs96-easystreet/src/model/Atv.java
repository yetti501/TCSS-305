package model;

import java.util.Map;
/**
 * 
 * @author Grant
 * @version Something
 */
public class Atv extends AbstractVehicle {
    
    /**
     * The static parameter that is related to the time until resurrection. 
     */
    public static final int MYDEATHTIME = 20;
    
    /**
     * 
     * @param theX The initial x value from where the ATV spawns on the map. 
     * @param theY The initial y value from where the ATV spawns on  the map.
     * @param theDir The  initial direction the ATV is facing when  it spawns.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MYDEATHTIME);
    }
    /**
     * Determines if the ATV can pass through a certain light. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        
        if (theTerrain.equals(Terrain.WALL)) {
            return false;
        }        
        return true;
    }
    /**
     * Determines the directions to which the ATV can travel. 
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        Direction newDir = Direction.random();
        
        while (newDir == getDirection().reverse() 
                        || theNeighbors.get(newDir) == Terrain.WALL) {
            newDir = Direction.random();
        } 
        return newDir;
    }
//
//    @Override
//    public void collide(final Vehicle theOther) {
//        // TODO Auto-generated method stub
//        //This will be error until you make them. 
//        if(theOther instanceof Taxi || theOther instanceof Car 
//                                      || theOther instanceof Truck) {
//            if(theOther.isAlive() && this.isAlive()) {
//                this.myAlive = false;
//            }
//        }
//    }
//
//    @Override
//    public int getDeathTime() {
//        // TODO Auto-generated method stub
//        return MYDEATHTIME;
//    }
//
//    @Override
//    public String getImageFileName() {
//        // TODO Auto-generated method stub
//        if (!(super.isAlive())) {
////        if (!(isAlive())) {
//            return "atv_dead.gif";
//        }
//        return "atv.gif";
//    }
//
//    @Override
//    public Direction getDirection() {
//        // TODO Auto-generated method stub
//        return myDir;
//    }
//
//    @Override
//    public int getX() {
//        // TODO Auto-generated method stub
//        return myX;
//    }
//
//    @Override
//    public int getY() {
//        // TODO Auto-generated method stub
//        return myY;
//    }
//
//    @Override
//    public boolean isAlive() {
//        // TODO Auto-generated method stub
//        return myAlive;
//    }
//
//    @Override
//    public void poke() {
//        // TODO Auto-generated method stub
//        int counter = 0;
//        counter++;
//        if (counter >= MYDEATHTIME) {
//            myAlive = true;
//            Direction.random();
//        }
//    }
//
//    @Override
//    public void reset() {
//        // TODO Auto-generated method stub        
//        setX(newX);
//        setY(newY);
//        setDirection(newDirection);
//    }
//
//    @Override
//    public void setDirection(final Direction theDir) {
//        // TODO Auto-generated method stub
//        myDir = theDir;
//    }
//
//    @Override
//    public void setX(final int theX) {
//        // TODO Auto-generated method stub
//        myX = theX;
//    }
//
//    @Override
//    public void setY(final int theY) {
//        // TODO Auto-generated method stub
//        myY = theY;
//    }

}
