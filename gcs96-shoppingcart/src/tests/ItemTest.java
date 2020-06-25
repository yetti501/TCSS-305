package tests;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import model.Item;
import org.junit.Before;
import org.junit.Test;

/**
 * This program runs a series of JUnits test on the Item  Class. 
 * 
 * @author Grant
 * @version 23, January2018
 */

public class ItemTest {
    /**
     * This makes the myItem tester. 
     */
    private Item myItem;
    /**
     * 
     */
    private Item myItemTwo;
    
    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myItem = new Item("GameBoy", new BigDecimal("199.99"), 2, new BigDecimal("179.99"));
        myItemTwo = new Item("Potato", new BigDecimal("99.00"));
    }
    /**
     * 
     */
    @Test
    public void testItemCorrect() {
        myItem = new Item("Switch", new BigDecimal("299.99"));
    }
    /**
     * Testing the Item method with 2 parameters.
     * Identifying the String is null error.  
     */
    @Test(expected = NullPointerException.class)
    public void testItemNullName() { 
        myItem = new Item(null, new BigDecimal("299.99"));
    }
    /**
     * Testing the Item method with 2 parameters.
     * Identifying the price as a negative number.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemNegativeValue() {
        myItem = new Item("Switch", new BigDecimal("-299.99"));
    }  
    /**
     * 
     */
    @Test(expected = NullPointerException.class)
    public void testItemNullStringMulti() {
        myItem = new Item(null, new BigDecimal("199.99"), 2, new BigDecimal("179.99"));
    }
    /**
     * 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemNegativeValueMulti() {
        myItem = new Item("Switch", new BigDecimal("-199.99"), 1, new BigDecimal("179.99"));
    } 
    /**
     * 
     */
    @Test
    public void testItemNegativeBulkValueMulti() {
        myItem = new Item("Switch", new BigDecimal("199.99"), 1, new BigDecimal("-179.99"));
    } 
    /**
     * 
     */
    @Test
    public void testItemZeroBulkQuantityMulti() {
        myItem = new Item("Switch", new BigDecimal("199.99"), 0, new BigDecimal("179.99"));
    }
    /** 
     * 
     */
    @Test
    public void testItemNegBulkQuantityMulti() {
        myItem = new Item("Switch", new BigDecimal("199.99"), -1, new BigDecimal("179.99"));
    }
    /**
     * 
     */
    @Test
    public void testGetPrice() {
        assertEquals("testGetPrice Failed", new BigDecimal("199.99"), myItem.getPrice());
    }
    /**
     * 
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals("testGetBulkQuantity Failed", 2, myItem.getBulkQuantity());
    }    
     /**
      * 
      */
    @Test
    public void testGetBulkPrice() {
        assertEquals("testGetBulkPrice Failed", new BigDecimal("179.99"), 
                     myItem.getBulkPrice()); 
    }
     /**
      * 
      */
    @Test
    public void testGetIsBulk() {
        assertEquals("testGetIsBulk Failed", true, myItem.isBulk());
    }
    /**
     * 
     */
    @Test
    public void testToString() {
        assertEquals("testToString Failed", 
                     "GameBoy, $199.99 (2 for $179.99)", myItem.toString());
    }  
    /**
     * 
     */
    @Test
    public void testToStringF() {
        
        assertEquals("testToString Failed", 
                     "Potato, $99.00", myItemTwo.toString());
    }
    /**
     * 
     */
    @Test 
    public void testEquals() {

        final Item itemOne = new Item("potatos", 
                                      new BigDecimal("0.39"), 2,
                                      new BigDecimal("0.14"));
        final Item itemExp = new Item("potatos", 
                                      new BigDecimal("0.39"), 2,
                                      new BigDecimal("0.14"));
        final Item itemTwo = new Item("tomatoe", 
                                      new BigDecimal("0.45"), 5,
                                      new BigDecimal("1.39"));
        final Item itemTwoTwo = new Item("tomato", 
                                      new BigDecimal("0.45"), 5,
                                      new BigDecimal("1.39"));
        final Item itemTwoThree = new Item("tomato", 
                                         new BigDecimal("0.50"), 5,
                                         new BigDecimal("1.39"));
        final Item itemTwoFour = new Item("tomato", 
                                          new BigDecimal("0.45"), 10,
                                          new BigDecimal("1.39"));
        final Item itemTwoFive = new Item("tomato", 
                                          new BigDecimal("0.45"), 5,
                                          new BigDecimal("1.99"));
        
        final Item itemThree = new Item("Orange", new BigDecimal("5.00"));
        final Item itemFour = new Item("Lemon", new BigDecimal("3.00"));
        final Item itemFive = new Item("Lomon", new BigDecimal("3.99"));
        final Item itemSix = new Item("Orange", new BigDecimal("3.99"));
        
        itemTwo.equals(itemTwoTwo);
        itemTwoTwo.equals(itemTwoThree);
        itemTwoTwo.equals(itemTwoFour);
        itemTwoTwo.equals(itemTwoFour);
        itemTwoTwo.equals(itemTwoFive);
        
        itemOne.equals(itemOne);
        itemOne.equals(itemExp);
        itemOne.equals(null);
        
        myItemTwo.equals(myItemTwo);
        myItemTwo.equals(itemThree);
        myItemTwo.equals(new Object());
        myItemTwo.equals(itemFour);
        
        itemFour.equals(itemFive);
        itemFive.equals(itemSix);
        itemThree.equals(itemSix);
        assertEquals(itemExp, itemOne);
        assertNotEquals(itemExp, itemTwo);
    }
    /**
     * 
     */
    @Test
    public void testHash() {
        final Item itemOne = new Item("potatos", 
                                      new BigDecimal("0.39"), 2,
                                      new BigDecimal("0.14"));
        final Item itemExp = new Item("potatos", 
                                      new BigDecimal("0.39"), 2,
                                      new BigDecimal("0.14"));
        final Item itemTwo = new Item("tomatoe", 
                                      new BigDecimal("0.45"), 5,
                                      new BigDecimal("1.39"));
        assertEquals(itemExp.hashCode(), itemOne.hashCode());
        assertNotEquals(itemExp.hashCode(), itemTwo.hashCode());
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
