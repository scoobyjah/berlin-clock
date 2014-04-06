package com.inkglobal.techtest;

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
		// TODO Auto-generated method stub
		return null;
	}

	public static String minutesToLowerLamps(int minutes) {
		// TODO Auto-generated method stub
		return null;
	}
}
