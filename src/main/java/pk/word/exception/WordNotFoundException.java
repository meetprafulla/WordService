package pk.word.exception;

public class WordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7754074118926253556L;
	
	public WordNotFoundException() {
		super();
	}
	
	public WordNotFoundException(String msg) {
		super(msg);
	}

}
