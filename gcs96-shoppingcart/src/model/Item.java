/*
 * TCSS 305 - Winter 2018
 * Assignment 2 - Shipping Cart
 * Grant Schorbach
 */


package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * This class stores all the information for the item(s). 
 * @author Grant
 * @version 17 January 2018
 */
public final class Item {
     /**
     * The item name.
     */
    private String myName;
    /**
     * The item price.
     */
    private BigDecimal myPrice;
    /**
     * The bulk item quantity.
     */
    private int myBulkQty;
    /**
     * The bulk item price.
     */
    private BigDecimal myBulkPrice;
    /**
     * The bulk item boolean.
     */
    private boolean myBulk;
    
    /**
     * Takes two parameters and makes sure that none of them are null. 
     * 
     * @param theName           assign the name of this item
     * @param thePrice          assign the price of this item
     * @throws NullPointerException if theName is null.  
     * @throws IllegalArguementException if thePrice is less than zero.
     */
    
    public Item(final String theName, final BigDecimal thePrice) {
        if (thePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        } 
        myName = Objects.requireNonNull(theName);
        myPrice = Objects.requireNonNull(thePrice);
        myBulk = false;  
    }

    /**
     * Takes four parameters and makes sure that none of them are null. 
     * 
     * @param theName           assign the name of this item
     * @param thePrice          assign the price of this item
     * @param theBulkQuantity   assign the bulk quantity of this item
     * @param theBulkPrice      assign the bulk price of this item
     * @throws NullPointerException if theName is null.
     * @throws IllegalArguementException if thePrice is less than zero. 
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) throws NullPointerException {
//        if (theName == null) {
//            throw new NullPointerException();
//        }
        if (thePrice.compareTo(BigDecimal.ZERO) < 0) { 
            throw new IllegalArgumentException();
        }
        
        myName = Objects.requireNonNull(theName);
        myPrice = Objects.requireNonNull(thePrice);
        myBulkPrice = Objects.requireNonNull(theBulkPrice);
        myBulkQty = theBulkQuantity;
        myBulk = true;
    }
 
    /**
     * returns the BigDecimal value for the quantity of an item. 
     * @return myPrice
     */
    public BigDecimal getPrice() {
        return myPrice;
    }
    
    /**
     * Returns the int value for the quantity of an item. 
     * @return myBulkQty
     */
    public int getBulkQuantity() {
        return myBulkQty;
    }
    
    /**
     * Returns the BigDecimal value for the price of an item. 
     * @return myBulkPrice
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * Returns the boolean value determining if the item is bulk or not. 
     * @return myBulk
     */
    public boolean isBulk() {
        return myBulk;
    }
    
    /**
     * This will return a string as such.
     * <br> "Xbox One, $399.00" or
     * <br> "Java Rules!" bumper sticker, $0.99 (20 for $8.95)" 
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(myName + ", $" + myPrice);
        if (myBulk) {
            sb.append(" (" + myBulkQty + " for $" + myBulkPrice + ")");
        }
        return sb.toString();  
    }

    /**
     * Returns true if the given item is equivalent to this item. 
     * In order for both items to be true all fields must match:
     * name, price,m bulk quantities, and bulk prices.
     * Otherwise this will return false. 
     */
    @Override
    public boolean equals(final Object theOther) {
        /*
         * See if you can do this without storing a boolean value. 
         * Not sure what this means. 
         */
        
        boolean result = false;
        if (theOther == this) {
            result = true;
        } else if (theOther != null && this.getClass() == theOther.getClass()) {
            final Item other = (Item) theOther;
            if (!myBulk) {
                result = myName.equals(other.myName) && myPrice.equals(other.myPrice);
            } else {
                result = myName.equals(other.myName) && myPrice.equals(other.myPrice)
                         && myBulkQty == other.myBulkQty && myBulkPrice.equals
                         (other.myBulkPrice);
            } 
        }
        return result;
    }

    /**
     * Returns the hash code as an integer for this item. 
     */
    @Override
    public int hashCode() {
        int hashResult;
        hashResult = Objects.hash(myName, myPrice);
        if ((myBulkQty != 0) && (myBulkPrice != null)) {
            hashResult = Objects.hash(myName, myPrice, myBulkQty, myBulkPrice);
        }
        return hashResult;
    }

}
