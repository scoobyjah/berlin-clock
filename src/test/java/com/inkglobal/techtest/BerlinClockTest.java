package com.inkglobal.techtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {
	
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
	public void testLightupUpperLamps() {
		assertEquals("OOOO", BerlinClock.lightupUpperLamps(0));
		assertEquals("ROOO", BerlinClock.lightupUpperLamps(1));
		assertEquals("RROO", BerlinClock.lightupUpperLamps(2));
		assertEquals("RRRO", BerlinClock.lightupUpperLamps(3));
		assertEquals("RRRR", BerlinClock.lightupUpperLamps(4));
	}
	
	@Test
	public void testLightupLowerBottomLamps() {
		assertEquals("OOOO", BerlinClock.lightupLowerBottomLamps(0));
		assertEquals("YOOO", BerlinClock.lightupLowerBottomLamps(1));
		assertEquals("YYOO", BerlinClock.lightupLowerBottomLamps(2));
		assertEquals("YYYO", BerlinClock.lightupLowerBottomLamps(3));
		assertEquals("YYYY", BerlinClock.lightupLowerBottomLamps(4));
	}
	
	@Test
	public void testLightupLowerTopLamps() {
		assertEquals("OOOOOOOOOOO", BerlinClock.lightupLowerTopLamps(00));
		assertEquals("YYROOOOOOOO", BerlinClock.lightupLowerTopLamps(3));
		assertEquals("YYRYYRYYRYY", BerlinClock.lightupLowerTopLamps(11));
	}
	
	@Test
	public void testMinutesToLowerLamps() {
		assertEquals("OOOOOOOOOOO OOOO", BerlinClock.minutesToLowerLamps(00));
		assertEquals("YYROOOOOOOO YYOO", BerlinClock.minutesToLowerLamps(17));
		assertEquals("YYRYYRYYRYY YYYY", BerlinClock.minutesToLowerLamps(59));
	}
}
