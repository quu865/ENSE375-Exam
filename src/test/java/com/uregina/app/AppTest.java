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
    
    @Test
    public void convert_toTime24_13_True() throws InvalidTimeException {
    	Time24 time = new Time24(13, 15);
    	time.toTime24(13, 15, AmPm.am);
    	assertTrue(time == null);
    }
    
    @Test
    public void convert_toTime24_2pm_True() throws InvalidTimeException {
    	Time24 time = new Time24(2, 15);
    	time.toTime24(2, 15, AmPm.pm);
    	assertTrue(time.hours == 14);
    }
    
    @Test
    public void convert_toTime24_15_True() throws InvalidTimeException {
    	Time24 time = new Time24(15, 15);
    	time.toTime24(15, 15, AmPm.pm);
    	assertTrue(time == null);
    }
}
