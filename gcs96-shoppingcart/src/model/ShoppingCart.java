// Finish and comment me!

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Objects;
/**
 * This class creates an empty shopping cart. 
 * @author Grant
 * @version 17 January 2018
 */
public class ShoppingCart {   
    /**
     * The map that makes up the cart. 
     */
    private Map<Item, Integer> myCart;

    /**
     * 
     */
    private BigDecimal myOrderTotal;
    
    /**
     * The boolean value that determines if the membership is true or false. 
     */
    private boolean myMembership;
    
    
    /**
     * Assigns the values of the hash map to that of the myCart map.
     */
    public ShoppingCart() {
        myMembership = false;
        myCart = new HashMap<Item, Integer>();
    }

    /**
     * Adds non-null values from theOrder to the map of myCart.
     * @param theOrder something
     */
    public void add(final ItemOrder theOrder) {
        Objects.requireNonNull(theOrder, "");
        myCart.put(theOrder.getItem(), theOrder.getQuantity());
        
//        if (myCart.containsKey(theOrder.getItem())) {
//            myCart.put(theOrder.getItem(),  theOrder.getQuantity());
//        }
    }
 
    /**
     * 
     * @param theMembership something
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * 
     * @return total The calculated total cost of the item(s).
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        if (myMembership)  {
            for (Item key : myCart.keySet()) {
                myCart.get(key);
                final BigDecimal qty = new BigDecimal(myCart.get(key));
                if (key.isBulk()) {
                    final int bulkNum = myCart.get(key) / key.getBulkQuantity();
                    final BigDecimal bdBulk = new BigDecimal(bulkNum);
                    final int modNum = myCart.get(key) % key.getBulkQuantity();
                    final BigDecimal bdMod = new BigDecimal(modNum);
                    
                    final BigDecimal totalBulk = bdBulk.multiply(key.getBulkPrice());
                    
                    final BigDecimal totalMod = bdMod.multiply(key.getPrice());
                    
                    total = total.add(totalBulk.add(totalMod));  
                } else {
                    total = total.add(qty.multiply(key.getPrice())); 
                }
            }
        } else {
            for (Item key : myCart.keySet()) {
                myCart.get(key);
                final BigDecimal qty = new BigDecimal(myCart.get(key));
                total = total.add(qty.multiply(key.getPrice())); 
            } 
        }
        return total; 
    }
    
    /**
     * 
     */
    
    ///Look up the clear hash set
    
    public void clear() {
        myCart = new HashMap<Item, Integer>();
    }
    /**
     * 
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myCart);
        return sb.toString();
    }

}
