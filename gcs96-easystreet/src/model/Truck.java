package model;

import java.util.Arrays;
import java.util.Map;

/**
 * 
 * @author Grant
 * @version something
 */
public class Truck extends AbstractVehicle {
    
    /**
     * The static parameter that is related to the time until resurrection. 
     */
    public static final int MYDEATHTIME = 0;
    /**
     * The static parameter that is related to the proper terrain for the truck.
     */
    public static final Terrain[] ALLOWTERRAIN = {Terrain.STREET, 
        Terrain.LIGHT, Terrain.CROSSWALK};

    /**
     * 
     * @param theX The initial x value from where the car spawns on the map.
     * @param theY The initial y value from where the car spawns on the map.
     * @param theDir The initial direction the car is facing when it spawns. 
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MYDEATHTIME);
    }
    
    /**
     * Determines if the car can pass through a certain light. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
//        // TODO Auto-generated method stub
//
//        if (theTerrain.equals(Terrain.CROSSWALK) && !(theLight.equals(Light.RED)
//                        || theTerrain.equals(Terrain.STREET)
//                        || theTerrain.equals(Terrain.LIGHT))) {
//            return true;
//        }
//        
//        return false;
        
        //return true;
        
        
        
        if (theTerrain.equals(Terrain.CROSSWALK) && theLight.equals(Light.RED)) {
            return false;
        } else if (
                        theTerrain.equals(Terrain.STREET) 
                        || theTerrain.equals(Terrain.LIGHT)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines the direction to which the car can travel. 
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
       // STREET, LIGHT, CROSSWALK
        Direction preference = Direction.random();
        
        if (theNeighbors.get(preference) == Terrain.STREET) {
            preference = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET) {
            preference = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET) {
            preference = getDirection().right();
        } else if (theNeighbors.get(preference) == Terrain.LIGHT) {
            preference = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            preference = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            preference = getDirection().right();
        } else if (theNeighbors.get(preference) == Terrain.CROSSWALK) {
            preference = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            preference = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            preference = getDirection().right();
        } else {
            preference = getDirection().reverse();
        }
        
        return preference;
        
        
        
        
//        boolean something = false;
//        
//        while(newDir != getDirection().reverse()) {
//            if(theNeighbors.get(newDir) == Terrain.STREET) {
//                if(Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
//                                              (getDirection().left()))) {
//                    newDir = newDir.left();
//                }
//            } else if(Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
//                                                                 (getDirection().right()))) {
//                newDir = newDir.right();
//            } else if(Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
//                                                                 (getDirection()))) {
//                return newDir;
//            }
//            else {
//                newDir = newDir.reverse();
//            }
//            
//        }
        
        
//        while (newDir == getDirection().reverse()
//                        || (theNeighbors.get(newDir) != Terrain.STREET
//                        && theNeighbors.get(newDir) != Terrain.LIGHT
//                        && theNeighbors.get(newDir) != Terrain.CROSSWALK)) {
//            newDir = Direction.random();
//            if (theNeighbors.get(getDirection()) != Terrain.STREET
//                            && theNeighbors.get(getDirection()) != Terrain.LIGHT
//                            && theNeighbors.get(getDirection()) != Terrain.CROSSWALK) {
//                newDir = getDirection().reverse();
//                break;
//            } 
//        }
    }
}
