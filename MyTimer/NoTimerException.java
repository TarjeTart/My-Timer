package MyTimer;

public class NoTimerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoTimerException() {
		super("Timer has not been ran or stopped");
	}

}
