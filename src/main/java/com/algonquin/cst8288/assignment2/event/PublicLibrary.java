/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * @author Jatin
 */
public class PublicLibrary extends Library {

    @Override
    public Event createEvent(EventType type) {
        switch (type) {
            case MOVIE_NIGHT:
                return new MovieNightEvent();
            case KIDS_STORY:
                return new KidsStoryEvent();
            default:
                throw new IllegalArgumentException("Wrong event type");
        }
    }
 
}