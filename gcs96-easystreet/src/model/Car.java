package model;

import java.util.Arrays;
import java.util.Map;
/**
 * 
 * @author Grant
 * @version Soemthing
 */
public class Car extends AbstractVehicle {
    /**
     * The static parameter that is related to the time until resurrection.
     */
    public static final int MYDEATHTIME = 10;    
    
    /**
     * The static parameter that is related to the proper terrain for the car. 
     */
    public static final Terrain[] ALLOWTERRAIN = {Terrain.STREET, 
        Terrain.LIGHT, Terrain.CROSSWALK};
    
    /**
     * 
     * @param theX The initial x value from where the car spawns on the map.
     * @param theY The initial y value from where the car spawns on the map.
     * @param theDir The initial direction the car is facing when it spawns.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MYDEATHTIME);
    }
    /**
     * Determines if the car can pass through a certain light. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
   
        if (theTerrain == (Terrain.LIGHT)) {
            if (theLight == (Light.RED)) {
                // PUT IN CODE THAT HOLD THE DIRECTION UNTIL GREEN AGAIN.
                return false;
            }
//            } else {
//                return true;
//            }
        } 
        if (theTerrain == (Terrain.CROSSWALK)) {
            if (theLight == (Light.YELLOW) || theLight == (Light.RED)) {
                // PUT IN CODE THAT HOLD THE DIRECTION UNTIL GREEN AGAIN.
                return false;
            }
//            } else {
//                return true;
//            }
        }
        return true;
    }
    /**
     * Determines the direction to which the car can travel. 
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
//        
//        Direction newDir = Direction.random();
//        
//        while ((theNeighbors.get(newDir) == Terrain.GRASS)
//                        || (theNeighbors.get(newDir) == Terrain.WALL)
//                        || (theNeighbors.get(newDir) == Terrain.TRAIL)) {
//            newDir = Direction.random();
//        }
//        
//        
//        while (!(theNeighbors.get(newDir) == Terrain.STREET 
//                        || theNeighbors.get(newDir) == Terrain.LIGHT
//                        || theNeighbors.get(newDir) == Terrain.CROSSWALK)) {
//            newDir = Direction.random();
//        }
//        
//        if (newDir.equals(getDirection())) { 
//            return newDir;
//        } else if (newDir.equals(getDirection().left())) {
//            return newDir;
//        } else if (newDir.equals(getDirection().right())) {
//            return newDir;
//        } else {
//            return newDir;
//        }
        
        Direction preference = getDirection();
        
        if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get(preference))) {
            return preference;
        } else if (Arrays.asList(ALLOWTERRAIN).contains(theNeighbors.get(preference.left()))) {
            preference = preference.left();
        } else if (Arrays.asList(ALLOWTERRAIN).contains
                        (theNeighbors.get(preference.right()))) {
            preference = preference.right();
        } else {
            preference = preference.reverse();
        }
        
        return preference;
        
        
    }
//
//    @Override
//    public void collide(Vehicle theOther) {
//        // TODO Auto-generated method stub
////        if(theOther.equals(Truck) {
////            if(theOther.isAlive() && this.isAlive()) {
////                this.myAlive = false;
////            }
////        }
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
//        if(!(isAlive())) {
//            return "car_dead.gif";
//        }
//        return "car.gif";
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
//    public void setDirection(Direction theDir) {
//        // TODO Auto-generated method stub
//        myDir = theDir;
//    }
//
//    @Override
//    public void setX(int theX) {
//        // TODO Auto-generated method stub
//        myX = theX;
//    }
//
//    @Override
//    public void setY(int theY) {
//        // TODO Auto-generated method stub
//        myY = theY;
//    }

}
