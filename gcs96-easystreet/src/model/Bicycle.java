package model;

import java.util.Arrays;
import java.util.Map;

/**
 * 
 * @author Grant
 * @version Something
 */
public class Bicycle extends AbstractVehicle {

    /**
     * The static parameter that is related to the time until resurrection.
     */
    public static final int MYDEATHTIME = 30;
    
    /**
     * The static parameter that is related to the proper terrain for the car. 
     */
    public static final Terrain[] ALLOWTERRAIN = {Terrain.LIGHT, 
        Terrain.CROSSWALK, Terrain.TRAIL, Terrain.STREET};
    /**
     * 
     * @param theX The initial x value from where the bicycle spawns on the map. 
     * @param theY The initial y value from where the bicycle spawns on the map. 
     * @param theDir The initial direction the car is facing when it spawns. 
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MYDEATHTIME);
    }
    /**
     * Determines if the car can pass through a certain light. 
     */
    
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
//        Bicycles ignore green lights.
//        Bicycles stop for yellow and red lights; if a traffic light 
//        or crosswalk light is immediately ahead of the bicycle and the 
//        light is not green, the bicycle stays still and does not move 
//        unless a trail is to the left or right. If a bicycle is facing 
//        a red or yellow light and there is a trail to the left or right, 
//        the bicycle will turn to face the trail.
        
        //Ignore green lights
        //STOP for yellow and red lights
            //will take trail over waiting for light
        
        
        if (theTerrain.equals(Terrain.CROSSWALK) || theTerrain.equals(Terrain.LIGHT)) {
            if (theLight.equals(Light.RED) || theLight.equals(Light.YELLOW)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Determines the direction to which the car can travel. 
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        //streets, lights and crosswalk 
        //but they prefer to travel on trails.
        // NOT: GRASS, WALL, 
//        Direction newDir = Direction.random();
//        
//        while ((theNeighbors.get(newDir) == Terrain.GRASS)
//                        || (theNeighbors.get(newDir) == Terrain.WALL)) {
//            newDir = Direction.random();
//        } 
//
//        if (theNeighbors.get(newDir).equals(Terrain.TRAIL)) {
//            return newDir;
//        } else {
//            return newDir;
//        }
        
        Direction preference = getDirection();

        
        // No trial straight, so wants to go straight.
        // Then check left. 
        // Then check right.
        if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get(getDirection()))) {
            preference = getDirection();
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
                                              (getDirection().left()))) {
            preference = getDirection().left();
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
                  (getDirection().right()))) {
            preference = getDirection().right();
        }
        
        //Sees is trail straight.
        // Sees if there is a trail left. 
        // See if there is a trail right.
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) { 
            preference = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            preference = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            preference = getDirection().right();
        }
 
        
        return preference;
    }
//
//    @Override
//    public void collide(final Vehicle theOther) {
//        // TODO Auto-generated method stub
//        
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
//        if (!(isAlive())) {
//            return "bicycle_dead.gif";
//        }
//        return "bicycle.gif";
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
