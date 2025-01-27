package model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

/**
 * 
 * @author Grant
 * @version Something
 */
public class ObservableRace extends Observable implements RaceControls {

    /** The delimiter used in the ledger file format. */
    private static final String DELIMITER = ":";
    
    /** The regular expression for an integer. */
    private static final String INTEGER_REGEX = "\\d+";
    
    /** The regular expression for an floating point number (non scientific notation). */
    private static final String FLOAT_REGEX = "\\d+.\\d+";    
    
    /** The amount of message to load before informing the user.  */
    private static final int INFORM_USER_FIELDS = 7;
    
    /**  */
    // THIS IS GOING TO BE A TEMP TESTING VARIABLE. 
    private static final int INFORM_PARTICIPANTS_FIELDS = 5;
    
    /** The error message for an incorrectly formatted file. */
    private static final String FILE_FORMAT_ERROR_MESSAGE = "Invalid file format. ";
    
//    /** The regular expression for an integer. */
//    private static final String INTEGER_REGEX = "\\d+";
    
//    /** The regular expression for an floating point number (non scientific notation). */
//    private static final String FLOAT_REGEX = "\\d+.\\d+";
    
    /** The information for this race loaded from the race file. */
    private final List<Messages> myRace;
    
    /**  */
    private List<SomeRaceInformation> myRaceHeader;
    
    /**  */
    private List<SomeTelemetry> myTelemetry;
    
    /**  */
    private List<SomeParticipants> myParticipants;
    
//    /** The cursor is what you can move up or down as a clock. . */
//    private int myCursor;
    
//    /** The information about the account loaded form the ledger file. */
//    private RaceInformation myRaceInfo;
    

    
    /**
     * 
     */
    public ObservableRace() {
        super();
        myRace = new ArrayList<>();
        myRaceHeader = new ArrayList<>();
        myParticipants = new ArrayList<>();
        myTelemetry = new ArrayList<>();

        
    }
    
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
        broadcastMessage("Loading File: " + theRaceFile.getName());
        final Scanner scanner = new Scanner(theRaceFile);

        loadHeader(scanner);

        int x = 5, i = 0;
        for(i = 0; i < x; i++) {
//            System.out.println(i);
            loadParticipants(scanner);
        }
        broadcastMessage("Start - This may take a while, please calm your tits.");
        loadRaceData(scanner);
    }
        
    /**
     * 
     * @param theScanner something
     * @throws IOException something
     */
    private void loadParticipants(final Scanner theScanner) throws IOException {
        System.out.println("\nLoad Participants!");
        while (theScanner.hasNext()) {
            if (myParticipants.size() % INFORM_PARTICIPANTS_FIELDS == 0) {
                broadcastMessage("Loading Participants...");
            }
//            skipping too many lines, you need to make a variable 
//            so that you can move one line at a time, format it like 
//            the example. This should fin you covering too many lines. 
            
//            There might be something wrong with your paseDouble
//            method, you will have to debug this later. 
            
            final String line = theScanner.nextLine();
            
            final String racerNumber = parseString(line, 3, 0);
            System.out.println("Race Number: " + racerNumber);
            final String racerName = parseString(line, 3, 1);
            System.out.println("Racer Name: " + racerName);
//            final double racerStart = parseDouble(line, 3, 2);
//            final BigDecimal racerStart = parseBigDecimal(line, 3, 2);
            final double racerStart = 0.0;
            System.out.println("Racer Start: " + racerStart);
//            myParticipants.add(new SomeParticipants(racerNumber, racerName, racerStart));
            break;
        }
    }
    
    /**
     * 
     * @param theScanner something
     * @throws IOException something 
     */
    private void loadHeader(final Scanner theScanner) throws IOException {
        while (theScanner.hasNext()) {
            if (myRaceHeader.size() % INFORM_USER_FIELDS == 0) {
                broadcastMessage("Still Loading...");
            }
            final String raceName = parseString(theScanner.nextLine(), 2, 0);
            System.out.println("Race Name: " + raceName);
            final String trackType = parseString(theScanner.nextLine(), 2, 1);
            System.out.println("Track Type: " + trackType);
            final int width = parseInteger(theScanner.nextLine(), 2, 1);
            System.out.println("Width: " + width);
            final int height = parseInteger(theScanner.nextLine(), 2, 1);
            System.out.println("Height: " + height);
            final int distance = parseInteger(theScanner.nextLine(), 2, 1);
            System.out.println("Distance: " + distance);
            final int time = parseInteger(theScanner.nextLine(), 2, 1);
            System.out.println("Time: " + time);
            final int participants = parseInteger(theScanner.nextLine(), 2, 1);
            System.out.println("Participants: " + participants);            
            myRaceHeader.add(new SomeRaceInformation(raceName, trackType, width, 
                                          height, distance, time, participants));
            break;
        }
    }
    
    /**
     * 
     * @param theScanner Something
     * @throws IOException Something
     */
    private void loadRaceData(final Scanner theScanner) throws IOException {
        System.out.println("\nLoading Racer Data... ");
        while (theScanner.hasNext()) {
            //Change my race to something else??? 
            if (myRace.size() % INFORM_USER_FIELDS == 0) {
                broadcastMessage("Still loading...");
            }            
            
            final int racerTimeStamp;            
            final String racerID;
            final double racerDistance;
            final int racerLap;
            final boolean racerFinished;

            final String line = theScanner.nextLine(); 
            
            System.out.println(line);
            /*
            if (line.startsWith("$T")) {
                System.out.println("$T");
                
                racerTimeStamp = parseInteger(line, 5, 1);
                System.out.println("Racer Time Stamp: " + racerTimeStamp);
                
                racerID = parseString(line, 5, 2);
                System.out.println("Race ID : " + racerID);
                
//                racerDistance = parseDouble(line, 5, 3);
                racerDistance = 0.0;
                System.out.println("Racer Distance: " + racerDistance);
                
                racerLap = parseInteger(line, 5, 4);
                System.out.println("Racer Lap: " + racerLap);
                
//                myTelemetry = new SomeTelemetry(racerTimeStamp, racerID, 
//                                                racerDistance, racerLap);                
            } else if(line.startsWith("$L")) {
                System.out.println("$L");
                
                racerTimeStamp = parseInteger(line, 4, 0);
                System.out.println("Racer Time Stamp: " + racerTimeStamp);
                
//                int i = 0, x = 5;
//                for(i = 0; i < x; i++) {
////                    i = i + 1;
//                    final int racerName = parseInteger(line, 4, i);
//                    System.out.println("Racer Name: " + racerName);
//                    i = i - 1;         
//                }
                
//                notifyObservers(); 

            } else if (line.startsWith("$C")) {
                System.out.println("$C");
//                
//                racerTimeStamp = parseInteger(line, 5, 1);
//                System.out.println("Racer Time Stamp: " + racerTimeStamp);
//                
//                racerID = parseString(line, 5, 1);
//                System.out.println("Race ID : " + racerID);
//                
//                racerLap = parseInteger(line, 5, 1);
//                System.out.println("Racer Lap: " + racerLap);
//                
//                racerFinished = parseBoolean(line, 5, 1);
//                System.out.println("Racer Finished: " + racerFinished);
//
            } else {
                throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
                
            }
            */
        }
    }

    /**
     * 
     * @param theLine something
     * @param theExpectedLength something
     * @param theIndex something
     * @return parts[theIndex]
     * @throws IOException something
     */
    private String parseString(final String theLine, 
                               final int theExpectedLength,
                               final int theIndex) throws IOException {
        final String[] parts = theLine.split(DELIMITER);
        if (parts.length != theExpectedLength) {
            throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
        }

        return parts[theIndex];
    }
    
    /**
     * 
     * @param theLine Something
     * @param theExpectedLength Something
     * @param theIndex Something
     * @return parts[theIndex] Something
     * @throws IOException Something
     */
    private int parseInteger(final String theLine, 
                         final int theExpectedLength,
                         final int theIndex) throws IOException {
        final String[] parts = theLine.split(DELIMITER);
        if (parts.length != theExpectedLength || !parts[theIndex].matches(INTEGER_REGEX)) {
            throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
        }
        return Integer.parseInt(parts[theIndex]);
    }
    
    /**
     * 
     * @param theLine Something
     * @param theExpectedLength Something
     * @param theIndex Something
     * @return parts[theIndex] Something
     * @throws IOException Something
     */
    private boolean parseBoolean(final String theLine, 
                         final int theExpectedLength,
                         final int theIndex) throws IOException {
        final String[] parts = theLine.split(DELIMITER);
        if (parts.length != theExpectedLength || !parts[theIndex].matches(INTEGER_REGEX)) {
            throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
        }
        return Boolean.parseBoolean(parts[theIndex]);
    }
    
//    /**
//     * 
//     * @param theLine Something
//     * @param theExpectedLength Something
//     * @param theIndex Something
//     * @return parts[theIndex] Something
//     * @throws IOException Something
//     */
//    private double parseDouble(final String theLine, 
//                         final int theExpectedLength,
//                         final int theIndex) throws IOException {
//        final String[] parts = theLine.split(DELIMITER);
//        if (parts.length != theExpectedLength || !parts[theIndex].matches(INTEGER_REGEX)) {
//            throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
//        }
//        return Double.parseDouble(parts[theIndex]);
//    }

    private BigDecimal parseBigDecimal(final String theLine,
                                       final int theExpectedLength,
                                       final int theIndex) throws IOException {
                final String[] parts = theLine.split(DELIMITER);
                if (parts.length != theExpectedLength || !parts[theIndex].matches(FLOAT_REGEX)) {
                    throw new IOException(FILE_FORMAT_ERROR_MESSAGE);
                }
                return new BigDecimal(parts[theIndex]);
            }
    

    /**
     * 
     * @param theMessage
     */
    private void broadcastMessage(final String theMessage) {
        setChanged();
        notifyObservers(theMessage);
    }
}