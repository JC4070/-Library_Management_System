/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.event.Constants;

/**
 *
 * @author Jatin
 */
public class BookLaunchEvent extends Event {

    public BookLaunchEvent() {
        this.eventName = "Book Launch";
        this.eventDescription = " A new book Launch.";
        this.eventActivities = "Interactive Books";
    }

    @Override
    public void calculateAdmissionFee() {
    	this.admissionFees = Constants.BOOK_LAUNCH_RATE * Constants.BOOK_LAUNCH_DURATION;
    }
}
