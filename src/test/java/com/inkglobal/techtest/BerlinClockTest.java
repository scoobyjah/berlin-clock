package com.inkglobal.techtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {
	
	/*
	On the top of the clock there is a yellow lamp that blinks on/off every two seconds. 

The top two rows of lamps are red. These indicate the hours of a day. 
In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. 
So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. 
In the first row every lamp represents 5 minutes. 
In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. 
The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.
	 */
	
	@Test
	public void testAsBerlinTime() {
		assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", BerlinClock.asBerlinTime("00:00:00"));
		assertEquals("O RROO RRRO YYROOOOOOOO YYOO", BerlinClock.asBerlinTime("13:17:01"));
		assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", BerlinClock.asBerlinTime("23:59:59"));
		assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO", BerlinClock.asBerlinTime("24:00:00"));
	}
	
	@Test
	public void testSecondsToTopLamp() {
		assertEquals("Y", BerlinClock.secondsToTopLamp(00));
		assertEquals("O", BerlinClock.secondsToTopLamp(01));
		assertEquals("O", BerlinClock.secondsToTopLamp(59));
	}
	
	@Test
	public void testHoursToUpperLamps() {
		assertEquals("OOOO OOOO", BerlinClock.hoursToUpperLamps(00));
		assertEquals("RROO RRRO", BerlinClock.hoursToUpperLamps(13));
		assertEquals("RRRR RRRO", BerlinClock.hoursToUpperLamps(23));
		assertEquals("RRRR RRRR", BerlinClock.hoursToUpperLamps(24));
	}
	
	@Test
	public void testMinutesToLowerLamps() {
		assertEquals("OOOOOOOOOOO OOOO", BerlinClock.minutesToLowerLamps(00));
		assertEquals("YYROOOOOOOO YYOO", BerlinClock.minutesToLowerLamps(17));
		assertEquals("YYRYYRYYRYY YYYY", BerlinClock.minutesToLowerLamps(59));
	}
}
