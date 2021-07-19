package MyTimer;

public class TimerRunningException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TimerRunningException() {
		super("Attempted to Start Timer when Already Running");
	}

}
