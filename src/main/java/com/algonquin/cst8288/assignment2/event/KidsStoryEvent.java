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
public class KidsStoryEvent extends Event {

    public KidsStoryEvent() {
        this.eventName = "Kids Stories";
        this.eventDescription = "A great way to relate stories to children.";
        this.eventActivities = "Interactive storytelling sessions";
    }

    @Override
    public void calculateAdmissionFee() {
    	this.admissionFees = Constants.KIDS_STORY_TIME_RATE * Constants.BOOK_LAUNCH_DURATION;
    }
}
