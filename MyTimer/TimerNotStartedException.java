package MyTimer;

public class TimerNotStartedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TimerNotStartedException() {
		super("Attempted to End Timer without Starting First");
	}

}
