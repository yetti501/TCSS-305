package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Grant
 * @version Something
 */
public class LoadRacer implements RaceControls {

    @Override
    public void advance() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void advance(final int theMillisecond) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void moveTo(final int theMillisecond) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void toggleParticipant(final int theParticpantID, final boolean theToggle) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void loadRace(final File theRaceFile) throws IOException {
        // TODO Auto-generated method stub
        final Scanner sc = new Scanner(theRaceFile);
//        int counter = 0;
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
//            counter++;
        }
//        System.out.println("COUNTER: " + counter);
        sc.close();
    }


}