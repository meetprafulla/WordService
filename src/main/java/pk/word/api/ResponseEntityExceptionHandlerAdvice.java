package pk.word.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pk.word.exception.WordTitleIsEmptyException;

@ControllerAdvice
public class ResponseEntityExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { WordTitleIsEmptyException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String responseBody = "Word Tile should not empty";
		return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
