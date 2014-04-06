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
		//The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. 
		//Every lamp represents 5 hours. 
		int noOfTopRowLampsOn = hours / 5;
		//In the lower row of red lamps every lamp represents 1 hour.
		//So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
		int noOfBottomRowLampsOn = hours - 5*noOfTopRowLampsOn;
		return lightupUpperLamps(noOfTopRowLampsOn) + " " + lightupUpperLamps(noOfBottomRowLampsOn);
	}
		
	private static String lightUpQuartet(char colour, int i) {
		StringBuilder row = new StringBuilder("OOOO");
		for (int j = 0; j < i; j++) {
			row.setCharAt(j, colour);
		}
		return row.toString();
	}
	
	public static String lightupUpperLamps(int i) {
		return lightUpQuartet('R', i);
	}
	
	public static String lightupLowerBottomLamps(int i) {
		return lightUpQuartet('Y', i);
	}
	
	public static String lightupLowerTopLamps(int i) {
		StringBuilder row = new StringBuilder("OOOOOOOOOOO");
		for (int j = 1; j <= i; j++) {
			//start at one to test modulus 3
			//In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.
			char colour = (j % 3 ) == 0 ?  'R' : 'Y';
			row.setCharAt(j, colour);
		}
		return row.toString();
	}

	public static String minutesToLowerLamps(int minutes) {
		//The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. 
		//In the first row every lamp represents 5 minutes. 
		int noOfTopRowLampsOn = minutes / 5;
		//The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.
		int noOfBottomRowLampsOn = minutes - 5*noOfTopRowLampsOn;
		return lightupLowerTopLamps(noOfTopRowLampsOn) + " " + lightupLowerBottomLamps(noOfBottomRowLampsOn);
	}	
}
