/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import static org.junit.Assert.*;

/**
 *
 * @author Jatin
 */
public class LMSLoggerTest {
    
    public LMSLoggerTest() {
    }
    
    
 public void testSingleInstance() {
        LMSLogger instance1 = LMSLogger.getInstance();
        LMSLogger instance2 = LMSLogger.getInstance();
        assertTrue("Two instances are the same", instance1 == instance2);
    }
   
}
