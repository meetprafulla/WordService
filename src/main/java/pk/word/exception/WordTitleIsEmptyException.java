package pk.word.exception;

public class WordTitleIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9177819546131543456L;

	public WordTitleIsEmptyException(String msg) {
		super(msg);
	}
}
