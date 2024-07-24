/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.algonquin.cst8288.assignment2.event.WorkshopEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jatin
 */
public class WorkshopEventTest {
    
    public WorkshopEventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
 @Test
    public void testCalculateAdmissionFee() {
        WorkshopEvent event = new WorkshopEvent();
        event.calculateAdmissionFee();
        double expectedFee = 40.0;
        assertEquals("Admission fee should be correctly calculated", expectedFee, event.getAdmissionFees(), 0.01);
    }
    
}
