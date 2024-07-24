/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * @author Jatin
 */
public class LibraryEventOrganizer {

    public static void main(String[] args) {
        organizePublicLibraryEvent();
        organizeAcademicLibraryEvent();
    }

    private static void organizePublicLibraryEvent() {
        PublicLibrary publicLibrary = new PublicLibrary();
        Event event = publicLibrary.createEvent(EventType.KIDS_STORY);
        event.calculateAdmissionFee();
        displayEventInfo("Public Library", event);
    }

    private static void organizeAcademicLibraryEvent() {
        AcademicLibrary academicLibrary = new AcademicLibrary();
        Event event = academicLibrary.createEvent(EventType.WORKSHOP);
        event.calculateAdmissionFee();
        displayEventInfo("Academic Library", event);
    }

    private static void displayEventInfo(String libraryType, Event event) {
        System.out.println(libraryType + " - " + event.getEventName() + ": $" + event.getAdmissionFees());
    }
}
