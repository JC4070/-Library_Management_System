/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.algonquin.cst8288.assignment2.event.MovieNightEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jatin
 */
public class MovieNightEventTest {
    
    private double expectedFee;
	public MovieNightEventTest() {
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
        MovieNightEvent event = new MovieNightEvent();
        event.calculateAdmissionFee();
        double expectedFee = 30.0;
        assertEquals("Admission fee should be correctly calculated", expectedFee, event.getAdmissionFees(), 0.01);
    }

}
