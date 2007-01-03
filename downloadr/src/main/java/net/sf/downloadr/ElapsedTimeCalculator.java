package net.sf.downloadr;

public class ElapsedTimeCalculator {
	public String calculateElapsedTime(long start, long finish) {
		long elapsedTimeInMilliSecs = finish - start;
		if (elapsedTimeInMilliSecs < 1000) {
			return elapsedTimeInMilliSecs + " ms";
		}
		int timeInSeconds = (int)(elapsedTimeInMilliSecs / 1000);
		int hours, minutes, seconds;
		hours = timeInSeconds / 3600;
		timeInSeconds = timeInSeconds - (hours * 3600);
		minutes = timeInSeconds / 60;
		timeInSeconds = timeInSeconds - (minutes * 60);
		seconds = timeInSeconds;
		if (hours == 0) {
			if (minutes == 0) {
				return seconds + " second(s)";
			}
			return minutes + " minute(s) " + seconds + " second(s)";
		}
		return hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)";
	}
}
