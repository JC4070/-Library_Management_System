/*
 * Click nbfs://nbhost/SystemFileSystem/Templat2es/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * @author Jatin
 */
public class AcademicLibrary extends Library {

    @Override
    public Event createEvent(EventType type) {
        
        switch (type) { 
            case BOOK_LAUNCH:
                return new BookLaunchEvent(); 
            case WORKSHOP:
                return new WorkshopEvent(); 
            default:
                throw new IllegalArgumentException("Wrong event type");
        }
    }
}
