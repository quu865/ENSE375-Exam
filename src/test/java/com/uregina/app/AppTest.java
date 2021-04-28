package com.uregina.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.uregina.exceptions.InvalidTimeException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void convert_toTime24_12am_True() throws InvalidTimeException {
    	Time24 time = new Time24(12, 15);
    	time.toTime24(12, 15, AmPm.am);
    	assertTrue(time.hours == 0);
    }
    
    @Test
    public void convert_toTime24_2am_True() throws InvalidTimeException {
    	Time24 time = new Time24(2, 15);
    	time.toTime24(2, 15, AmPm.am);
    	assertTrue(time.hours == 2);
    }
    
    /*@Test
    public void convert_toTime24_13_True() throws InvalidTimeException {
    	Time24 time = new Time24(13, 15);
    	time.toTime24(13, 15, AmPm.am);
    	assertTrue(time == null);
    }*/
    
    @Test
    public void convert_toTime24_2pm_True() throws InvalidTimeException {
    	Time24 time = new Time24(2, 15);
    	time.toTime24(2, 15, AmPm.pm);
    	assertTrue(time.hours == 14);
    }
    
    /*@Test
    public void convert_toTime24_15_True() throws InvalidTimeException {
    	Time24 time = new Time24(15, 15);
    	time.toTime24(15, 15, AmPm.pm);
    	assertTrue(time == null);
    }*/
    
    @Test
    public void invalid_t1_hours_True() throws InvalidTimeException {
    	Time12 t1 = new Time12(13,20, AmPm.am);
    	Time12 t2 = new Time12(11,20, AmPm.am);
    	try{
    		int difference = Time12.subtract(t1,  t2);
    		assertTrue(difference == 0);
    	}
    	catch(Exception e) {
    		assertTrue(true);
    		
    	}
    	
    }
    
    @Test
    public void invalid_t2_hours_True() throws InvalidTimeException {
    	Time12 t1 = new Time12(11,20, AmPm.am);
    	Time12 t2 = new Time12(13,20, AmPm.am);
    	try{
    		int difference = Time12.subtract(t1,  t2);
    		assertTrue(difference == 0);
    	}
    	catch(Exception e) {
    		assertTrue(true);
    		
    	}
    	
    }
    
    @Test
    public void invalid_t1_minutes_True() throws InvalidTimeException {
    	Time12 t1 = new Time12(1,80, AmPm.am);
    	Time12 t2 = new Time12(11,20, AmPm.am);
    	try{
    		int difference = Time12.subtract(t1,  t2);
    		assertTrue(difference == 0);
    	}
    	catch(Exception e) {
    		assertTrue(true);
    		
    	}
    	
    }
    
    @Test
    public void invalid_t2_minutes_True() throws InvalidTimeException {
    	Time12 t1 = new Time12(1,20, AmPm.am);
    	Time12 t2 = new Time12(11,80, AmPm.am);
    	try{
    		int difference = Time12.subtract(t1,  t2);
    		assertTrue(difference == 0);
    	}
    	catch(Exception e) {
    		assertTrue(true);
    		
    	}
    	
    }
    
    @Test
    public void valid_lessThanCalculation_True() throws InvalidTimeException {
    	Time12 t1 = new Time12(1,20, AmPm.am);
    	Time12 t2 = new Time12(11,20, AmPm.am);
    	
    	boolean validCalculation = Time12.lessThan(t1, t2);
    	assertTrue(validCalculation);
    }
   
    
    
    
    
}
