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
public class WorkshopEvent extends Event {

    public WorkshopEvent() {
        this.eventName = "Workshop";
        this.eventDescription = "Instructional workshops for enhancing abilities";
        this.eventActivities = "Learning new things";
    }

    
    public void setEventId(int id) {
        this.eventId = eventId;	
        }
    
    
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
    }

}