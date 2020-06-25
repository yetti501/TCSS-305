package model;

import java.util.Arrays;
import java.util.Map;
/**
 * 
 * @author Grant
 * @version Something
 */
public class Human extends AbstractVehicle {

    /**
     * The static parameter that is related to the time until resurrection.
     */
    public static final int MYDEATHTIME = 50;
    /**
     * The static parameter that is related to the proper terrain for the human. 
     */
    public static final Terrain[] ALLOWTERRAIN = {Terrain.GRASS, Terrain.CROSSWALK};
    /**
     * 
     * @param theX The initial x value from where the human spawns on the map. 
     * @param theY The initial y value from where the human spawns on the map.
     * @param theDir The initial direction the human is facing when it spawns. 
     */
    public Human(final int theX, final int theY, final Direction theDir) {
        super(theX,  theY, theDir, MYDEATHTIME);
    }
    /**
     * Determines is the human can pass through a certain light. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        
        if (theTerrain.equals(Terrain.CROSSWALK) && theLight.equals(Light.GREEN)) {
            return false;
        }
        return true;
    }
    
    /**
     * Determines the direction to which the human can travel. 
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        //Move in a random direction
        //ONLY ON GRASS or CROSSWALK
        //will choose a crosswalk over anything else
        // Not through crosswalk with GREEN
        // Will wait at a crosswalk until it is YELLOW 
        // cross the CROSSWALK when YELLOW or RED
        // The ignore the color of the traffic lights. 
        
//        Direction newDir = Direction.random();
//        
//        while (!(theNeighbors.get(newDir) == Terrain.GRASS)
//                        || theNeighbors.get(newDir) == Terrain.CROSSWALK) {
//            newDir = Direction.random();
//        }
//        
//        if (theNeighbors.get(newDir) == Terrain.CROSSWALK) {
//            return newDir;
//        } else {
//            return newDir;
//        }
//        
//        boolean straight = false;
//        boolean right = false;
//        boolean left = false;
//        
//        Direction preference = Direction.random();
//        while (
//                        //preference == getDirection() 
//                        //|| preference == getDirection().left() 
//                        //|| preference == getDirection().right()
//                         preference != getDirection().reverse()
//                        && !straight && !right && !left) {
//            
//            
//            if(theNeighbors.get(preference) == Terrain.GRASS) {
//                
//            }
//             
//            
//            if (theNeighbors.get(preference) == Terrain.CROSSWALK) {
//                preference = getDirection();
//                straight = true;
//            } else if (theNeighbors.get(preference) == Terrain.GRASS) {
//                preference = getDirection();
//                straight = true;
//            } else if (theNeighbors.get(preference) == Terrain.CROSSWALK) {
//                preference = getDirection().left();
//                left = true;
//            } else if (theNeighbors.get(preference.left()) == Terrain.GRASS) {
//                preference = getDirection().left();
//                left = true;
//            } else if (theNeighbors.get(preference.right()) == Terrain.CROSSWALK) {
//                preference = getDirection().right();
//                right = true;
//            } else if (theNeighbors.get(preference.right()) == Terrain.GRASS) {
//                preference = getDirection().right();
//                right = true;
//            }
//            
//            
//            else {
//                preference = preference.reverse();
//            }
//            preference = Direction.random();
//        }
        
        
        
        
        Direction preference = Direction.random();
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) { 
            preference = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            preference = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            preference = getDirection().right();
            
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get(getDirection()))) {
            preference = getDirection();
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
                                                        (getDirection().left()))) {
            preference = getDirection().left();
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get
                                                        (getDirection().right()))) {
            preference = getDirection().right();
        } else {
            preference = getDirection().reverse();
        }
        

        
        return preference;
    }
}