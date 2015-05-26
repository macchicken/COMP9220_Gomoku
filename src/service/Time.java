package service;

//import java.util.Timer;

public class Time {

	private static int MAXTIME=60;
	 
	private long start;


	protected Time(int maxTime) {MAXTIME=maxTime;}

	//save current system timer
	public void start() {
		start = System.currentTimeMillis();
	}

	 
	//compare with saved start time.
	public boolean isTimeOut() {
		if (MAXTIME==0){return false;}
		long current = System.currentTimeMillis();
		return (current - start) > (MAXTIME * 1000);
	}

}
