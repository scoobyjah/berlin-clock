package com.inkglobal.techtest;

import static org.junit.Assert.assertEquals;

public class BerlinClock {

	public static Object asBerlinTime(String normalTime) {
		// split by : and convert each part into the correct row of lamps and then combine them
		String[] parts = normalTime.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);
		int seconds = Integer.parseInt(parts[2]);
		
		return secondsToTopLamp(seconds) + " " + hoursToUpperLamps(hours) + " " + minutesToLowerLamps(minutes);
	}

	public static String secondsToTopLamp(int seconds) {
		//even seconds are on, odd seconds are off
		return (seconds % 2 ) == 0 ?  "Y" : "O";
	}

	public static String hoursToUpperLamps(int hours) {
		/*
		The top two rows of lamps are red. These indicate the hours of a day. 
In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. 
So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
		assertEquals("OOOO OOOO", BerlinClock.hoursToUpperLamps(00));
		assertEquals("RROO RRRO", BerlinClock.hoursToUpperLamps(13));
		assertEquals("RRRR RRRO", BerlinClock.hoursToUpperLamps(23));
		assertEquals("RRRR RRRR", BerlinClock.hoursToUpperLamps(24));
		 */
		int noOfTopRowLampsOn = hours / 5;
		int noOfBottomRowLampsOn = hours - 5*noOfTopRowLampsOn;
		return lightupUpperLamps(noOfTopRowLampsOn) + lightupUpperLamps(noOfBottomRowLampsOn);
	}
	
	public static String lightupUpperLamps(int i) {
		/*
		assertEquals("OOOO", BerlinClock.lightupUpperLamps(0));
		assertEquals("ROOO", BerlinClock.lightupUpperLamps(1));
		assertEquals("RROO", BerlinClock.lightupUpperLamps(2));
		assertEquals("RRRO", BerlinClock.lightupUpperLamps(3));
		assertEquals("RRRR", BerlinClock.lightupUpperLamps(4));
		 */
		return null;
	}

	public static String minutesToLowerLamps(int minutes) {
		/*
		The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. 
In the first row every lamp represents 5 minutes. 
In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. 
The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.
		assertEquals("OOOOOOOOOOO OOOO", BerlinClock.minutesToLowerLamps(00));
		assertEquals("YYROOOOOOOO YYOO", BerlinClock.minutesToLowerLamps(17));
		assertEquals("YYRYYRYYRYY YYYY", BerlinClock.minutesToLowerLamps(59));
		 */
		return null;
	}	
}
