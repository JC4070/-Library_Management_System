package com.algonquin.cst8288.assignment2.database;

/**
 * @author Jatin
 */
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.WorkshopEvent;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

	
    public Event getEventById(int id) {
        String sql = "SELECT event_name, event_description, event_activities, admission_fees FROM events WHERE event_id = ?";
        
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preps = connection.prepareStatement(sql)) {
            
            preps.setInt(1, id); 
            ResultSet rset = preps.executeQuery(); 
            
            if (rset.next()) {
                WorkshopEvent event = new WorkshopEvent();
                event.setEventId(id); 
                event.setEventName(rset.getString("event_name"));
                event.setEventDescription(rset.getString("event_description"));
                event.setEventActivities(rset.getString("event_activities"));
                event.setAdmissionFees(rset.getDouble("admission_fees"));
                
                return event; 
            }
        } catch (SQLException e) {

        }
        return null; 
    }
	
	
    public void addEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.getInstance().getConnection(); // Obtain a connection from the singleton DBConnection class.
             PreparedStatement preps = connection.prepareStatement(sql)) { // Prepare the SQL statement with the provided query.
            
            preps.setString(1, event.getEventName());
            preps.setString(2, event.getEventDescription());
            preps.setString(3, event.getEventActivities());
            preps.setDouble(4, event.getAdmissionFees());
            
            preps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LMSLogger.getInstance().log(LogLevel.INFO, "New event added, Thank you:)");

    }
    
    public void deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preps = connection.prepareStatement(sql)) {
            
            preps.setInt(1, id); 
            
            preps.executeUpdate();
        } catch (SQLException e) {
 e.printStackTrace();
        }
    }
    
    public void updateEvent(int id, Event event) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
        
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preps = connection.prepareStatement(sql)) {
            
            preps.setString(1, event.getEventName());
            preps.setString(2, event.getEventDescription());
            preps.setString(3, event.getEventActivities());
            preps.setDouble(4, event.getAdmissionFees());
            preps.setInt(5, id); 
            
            preps.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

   
}