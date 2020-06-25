/*
 * TCSS 305 - Winter 2018
 * Assignment 0 - Orientation 
 */

/**
 * This program prints "Grant Schorbach" and "Hello World Main" from the main class. 
 * Then later in the program it prints "Hello World not Main" in the not main class. 
 * 
 * This is also the start of the program. 
 * 
 * @author Grant
 * @version 1
 * 
 */
public final class HelloMain {
    
    /**
     * This makes it so that outside code cannot be instantiated. 
     */
    private HelloMain() {
        
    }
    /**
     * This prints out my name and the first Hello World comment. 
     * After that is calls the other class. 
     * 
     * theArgs The theArgs.
     * @param theArgs the command line arguments 
     */
    public static void main(final String[] theArgs) {
        System.out.println("Grant Schorbach");
        System.out.println("Hello World Main");
        final Hello test = new Hello();
        
        test.printFun();
        
    }

}
