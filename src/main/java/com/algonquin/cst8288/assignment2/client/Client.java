package com.algonquin.cst8288.assignment2.client;

/**
 * @author Jatin
 */
import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryEvent;
import com.algonquin.cst8288.assignment2.event.AcademicLibrary;
import com.algonquin.cst8288.assignment2.event.Library;
import com.algonquin.cst8288.assignment2.event.PublicLibrary;
import com.algonquin.cst8288.assignment2.event.WorkshopEvent;
import com.algonquin.cst8288.assignment2.event.BookLaunchEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import java.util.Scanner;

public class Client {

    private static final Scanner scan = new Scanner(System.in);
    private static final DBOperations dbOperations = new DBOperations();
    Library academic = new AcademicLibrary();
    Library publicL = new PublicLibrary();
    
    Event workshop = academic.createEvent(EventType.WORKSHOP);
    Event bookLaunch = academic.createEvent(EventType.BOOK_LAUNCH);
    Event movieNight = publicL.createEvent(EventType.MOVIE_NIGHT);
    Event kidsStoryTime = publicL.createEvent(EventType.KIDS_STORY);
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Library Management System Programmed by Jatin Jatin");
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1: Add event");
            System.out.println("2: Retrieve event");
            System.out.println("3: Update event");
            System.out.println("4: Delete event");
            System.out.println("5: Exit");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    addEvent(); // Add event.
                    break;
                case 2:
                    getEventById(); // Retrieve event
                    break;
                case 3:
                    updateEvent(); // Update event.
                    break;
                case 4:
                    deleteEvent(); // Delete event.
                    break;
                case 5:

                	System.out.println("Exiting...");
                    return;
                default:

                	System.out.println("Sorry its not a valid option, please check again :(");
            }
        }
        
    }
    
    
    private static void deleteEvent() {
        System.out.println("Please enter Event Id that you want to delete");
        int id = scan.nextInt();
        dbOperations.deleteEvent(id);
        LMSLogger.getInstance().log(LogLevel.INFO, "Event deleted :(");
    }

    private static void addEvent() {
        System.out.println("Please select the type of event to add:");
        System.out.println("1: Academic Library");
        System.out.println("2: Public Library");

        int eventType = scan.nextInt();
        scan.nextLine(); // Consume newline

        Event event;
        switch (eventType) {
            case 1:
                event = selectAcademicEvent();
                break;
            case 2:
                event = selectPublicLibraryEvent();
                break;
            default:
                System.out.println("Invalid event type selected.");

                return;
        }
        
    }
    private static Event selectAcademicEvent() {
        System.out.println("Please select the type of academic event:");
        System.out.println("1: Workshop");
        System.out.println("2: Book Launch");

        int academicEventType = scan.nextInt();
        scan.nextLine(); // Consume newline

        switch (academicEventType) {
            case 1:
            	
                    System.out.println("Adding event...");
                    Event event = new WorkshopEvent();
                    event.calculateAdmissionFee(); 
                    dbOperations.addEvent(event); 
                    LMSLogger.getInstance().log(LogLevel.INFO, "New event added, Thank you:)");
                    
            case 2:
            	System.out.println("Adding event...");
                Event event1 = new BookLaunchEvent();
                event1.calculateAdmissionFee(); 
                dbOperations.addEvent(event1); 
                LMSLogger.getInstance().log(LogLevel.INFO, "New event added, Thank you:)");
            default:
                System.out.println("Invalid academic event type selected.");
                return null;
        }
    }

    private static Event selectPublicLibraryEvent() {
        System.out.println("Please select the type of public library event:");
        System.out.println("1: Movie Night");
        System.out.println("2: Kids Story Time");

        int publicLibraryEventType = scan.nextInt();
        scan.nextLine(); // Consume newline

        switch (publicLibraryEventType) {
            case 1:
            	System.out.println("Adding event...");
                Event event2 = new MovieNightEvent();
                event2.calculateAdmissionFee(); 
                dbOperations.addEvent(event2); 
                LMSLogger.getInstance().log(LogLevel.INFO, "New event added, Thank you:)");

            case 2:
            	System.out.println("Adding event...");
                Event event3 = new KidsStoryEvent();
                event3.calculateAdmissionFee(); 
                dbOperations.addEvent(event3); 
                LMSLogger.getInstance().log(LogLevel.INFO, "New event added, Thank you:)");

                
            default:
                System.out.println("Invalid public library event type selected.");
                return null;
        }

    }

    private static void updateEvent() {
        System.out.println("Please enter the event ID that you want to update");
        int id = scan.nextInt(); 
        
        Event existingEvent = dbOperations.getEventById(id);
        if (existingEvent == null) {
            System.out.println("Sorry event is not found :(");
            return;
        }
        
        System.out.println("Please enter the new name for event:");
        scan.nextLine(); 
        String newName = scan.nextLine(); 
        
        existingEvent.setEventName(newName);

        dbOperations.updateEvent(id, existingEvent);
        
        LMSLogger.getInstance().log(LogLevel.INFO, "Event updated :)");

        
    }

    
    
    private static void getEventById() {
        System.out.println("Enter the ID of the event to retrieve:");
        int id = scan.nextInt();
        Event event = dbOperations.getEventById(id); 
        if (event != null) {
        	System.out.println("Event Retrieved: " + event.getEventName());
        } else {
            System.out.println("Event not found.");
        }
        
        LMSLogger.getInstance().log(LogLevel.INFO, "Event Retrived");

    }
    
       
}