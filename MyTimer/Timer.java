package MyTimer;

public final class Timer {

	public static final long nanoInDay = (long)(8.64*Math.pow(10, 13));
	public static final long nanoInHour = (long)(3.6*Math.pow(10, 12));
	public static final long nanoInMinute = (long)(6*Math.pow(10, 10));
	public static final long nanoInSecond = (long)Math.pow(10, 9);
	
	public static final long milliInDay = (long)(8.64*Math.pow(10, 7));
	public static final long milliInHour = (long)(3.6*Math.pow(10, 6));
	public static final long milliInMinute = 60000;
	public static final long milliInSecond = 1000;
	
	private static long start = -1;
	private static long timer = 0;
	
	private Timer() {}
	
	public static void startTimer() throws TimerRunningException {
		if(start != -1)
			throw new TimerRunningException();
		start = System.nanoTime();
	}
	
	public static void endTimer() throws TimerNotStartedException {
		if(start == -1)
			throw new TimerNotStartedException();
		timer = System.nanoTime()-start;
		start = -1;
	}
	
	public static String getTime() throws NoTimerException {
		if(timer <= 0)
			throw new NoTimerException();
		return timeToString(timer);
	}
	
	private static String timeToString(long nanoTime) {
		if(nanoTime >= nanoInDay){
			return timeToStringDay(nanoTime);
		}else if(nanoTime >= nanoInHour) {
			return timeToStringHour(nanoTime);
		}else if(nanoTime >= nanoInMinute) {
			return timeToStringMinute(nanoTime);
		}else if(nanoTime >= nanoInSecond){
			return timeToStringSecond(nanoTime);
		}
		return nanoTime + " nano seconds";
	}
	
	private static String timeToStringDay(long nanoTime) {
		long tempSec = nanoTime/(1000*1000*1000);
	    long sec = tempSec % 60;
	    long min = (tempSec /60) % 60;
	    long hour = (tempSec /(60*60)) % 24;
	    long day = (tempSec / (24*60*60)) % 24;
	    
	    return String.format("%dd %dh %dm %ds", day,hour,min,sec);
	}
	
	private static String timeToStringHour(long nanoTime) {
		long tempSec = nanoTime/(1000*1000*1000);
	    long sec = tempSec % 60;
	    long min = (tempSec /60) % 60;
	    long hour = (tempSec /(60*60)) % 24;
	    
	    return String.format("%dh %dm %ds", hour,min,sec);
	}
	
	private static String timeToStringMinute(long nanoTime) {
		long tempSec = nanoTime/(1000*1000*1000);
	    long sec = tempSec % 60;
	    long min = (tempSec /60) % 60;
	    
	    return String.format("%dm %ds", min,sec);
	}
	
	private static String timeToStringSecond(long nanoTime) {
		long tempSec = nanoTime/(1000*1000*1000);
	    long sec = tempSec % 60;
	    
	    return String.format("%ds", sec);
	}
	
}
