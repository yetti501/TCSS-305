package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.Direction;
import model.Human;
import model.Truck;
import model.Light;
import model.Terrain;

/**
 * 
 * @author Grant
 * @version Something
 */
public class TruckTest {
    
    /**
     * The number of times to repeat a test to have a high probability that all
     * random possibilities have been explored.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;
    
    
    @Before
    public void setUp() throws Exception {
    }
    /** 
     * Test method for Truck constructor.
     */
    @Test
    public void testTruckConstructor() {
        final Truck t = new Truck(1, 1, Direction.EAST);
        
        assertEquals("Truck x coordinate not initialized correctly!", 1, t.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 1, t.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.EAST, t.getDirection());
        assertEquals("Truck death time not initialized correctly!", 0, t.getDeathTime());
        assertTrue("Truck isAlive() fails initially!", t.isAlive());
    } 

    /** 
     * Test method for Human setters. 
     */
    @Test
    public void testHumanSetters() {
        final Truck t = new Truck(1, 1, Direction.EAST);
        
        t.setX(12);
        assertEquals("Truck setX failed!", 12, t.getX());
        t.setY(5);
        assertEquals("Truck setY failed!", 5, t.getY());
        t.setDirection(Direction.SOUTH);
        assertEquals("Truck setDirection failed!", Direction.SOUTH, t.getDirection());
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPass() {
        
        // Humans can move to GRASS or to CROSSWALKS
        // so we need to test both of those conditions
        
        // Humans should NOT choose to move to other terrain types
        // so we need to test that Humans never move to other terrain types
        
        // Humans should only reverse direction if no other option is available
        // so we need to be sure to test that requirement also
        
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.CROSSWALK);
        validTerrain.add(Terrain.STREET); 
                
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        // test each terrain type as a destination
        for (final Terrain destinationTerrain : Terrain.values()) {
            // try the test under each light condition
            for (final Light currentLightCondition : Light.values()) {
                
                if (destinationTerrain == Terrain.STREET) {
                    // truck can pass GRASS under any light condition
                    assertTrue("Truck should be able to pass STREET"
                               + ", with light " + currentLightCondition,
                               truck.canPass(destinationTerrain, currentLightCondition));
                    
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                           // truck can pass CROSSWALK
                           // if the light is YELLOW or GREEN but not RED

                    if (currentLightCondition == Light.RED) {
                        assertFalse("Truck should NOT be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            truck.canPass(destinationTerrain,
                                          currentLightCondition));
                    } else { // light is yellow or green
                        assertTrue("Truck should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            truck.canPass(destinationTerrain,
                                          currentLightCondition));
                    } 
                } else if (!validTerrain.contains(destinationTerrain)) {
 
                    assertFalse("Truck should be able to pass " + destinationTerrain
                        + ", with light " + currentLightCondition,
                        truck.canPass(destinationTerrain, currentLightCondition));
                }
                
            } 
        }
    }
    
    /**
     * Test method for {@link Human#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionSurroundedByGrass() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.GRASS);
        neighbors.put(Direction.NORTH, Terrain.GRASS);
        neighbors.put(Direction.EAST, Terrain.GRASS);
        neighbors.put(Direction.SOUTH, Terrain.GRASS);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction t = truck.chooseDirection(neighbors);
            
            if (t == Direction.WEST) {
                seenWest = true;
            } else if (t == Direction.NORTH) {
                seenNorth = true;
            } else if (t == Direction.EAST) {
                seenEast = true;
            } else if (t == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenWest && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenSouth);
    }

    
    /**
     * Test method for {@link Human#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionOnGrassNearCrosswalk() {
        
        // If a Human is next to a crosswalk it should always choose to face
        // toward the crosswalk. Except when that would cause the human to reverse
        // direction. A Human will only reverse direction if no other valid option exits.
        // So, test all possible conditions.
        
        final Truck truck = new Truck(12, 1, Direction.NORTH);
        
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        
        for (final Direction d : Direction.values()) {
            truck.setDirection(d);
            
            
            if (d == Direction.EAST) {
                assertNotEquals("A Truck near a crosswalk and facing " + d
                             + " should not reverse direction!",
                             Direction.EAST, truck.chooseDirection(neighbors));
                
            } else {
                assertEquals("A Truck near a crosswalk and facing " + d
                             + " chose a wrong direction!",
                             Direction.WEST, truck.chooseDirection(neighbors));
            }
        }
    }
    
    
    
    
    
    
    
    
}
