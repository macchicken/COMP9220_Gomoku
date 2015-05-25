package service;

//import java.util.Timer;

public class Time {

	private static int MAXTIME=60;
	 
//	private static Timer time;

	private long start;
	protected Time(int maxTime) {MAXTIME=maxTime;}

//	 public Timer getTimer() {
//	   if (time == null) {
//	     time = new Timer();
//	   }
//	   return time;
//	 }

	//save current system timer
	public void start() {
		start = System.currentTimeMillis();
	}

//	public long getStartTime() {
//		return start;
//	}
	 
	//compare with saved start time.
	public boolean isTimeOut() {
		long current = System.currentTimeMillis();
		return (current - start) > (MAXTIME * 1000);
	}

}
