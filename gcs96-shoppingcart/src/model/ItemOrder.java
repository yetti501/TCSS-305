// Finish and comment me!

package model;

import java.util.Objects;
/**
 * This class stores all order information about the item(s).
 * @author Grant
 * @version 17 January 2018
 */
public final class ItemOrder {
    /**
     * The object of an item as an Item.
     */
    private final Item myItem;
    /**
     * The quantity of an item as an int. 
     */
    private final int myQuantity;
    
    /**
     * Takes two parameters and makes sure that they are not null.
     *  
     * @param theItem       assigns the object of the item.
     * @param theQuantity   assigns the quantity of the item.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
        }
        
        myItem = Objects.requireNonNull(theItem);
        myQuantity = theQuantity;
    }

    /**
     * Returns the object for the item in an order. 
     * @return myItem
     */
    public Item getItem() {
        return myItem;
    }
    
    /**
     * Returns the int value for the quantity of an item in an order. 
     * @return myQuantity
     */
    public int getQuantity() {
        return myQuantity;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item: " + myItem + ", "
                        + "quantity is: " + myQuantity);
        return sb.toString();
    }

}
