package fr.univrouen.rss22SB1.errorHandler;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.univrouen.rss22SB1.exceptions.FeedAPI400Exception;
import fr.univrouen.rss22SB1.exceptions.FeedAPI404Exception;
import fr.univrouen.rss22SB1.exceptions.FeedAPI500Exception;
import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class APIExceptionHandler extends ResponseEntityExceptionHandler{
	
	private ResponseEntity<Object> buildResponseEntity(final ErrorWithoutIdDTO errorDto, final HttpStatus status) {
		return new ResponseEntity<>(errorDto, status);
	}
	
	private ResponseEntity<Object> buildResponseEntity(final ErrorWithIdDTO errorDto, final HttpStatus status) {
		return new ResponseEntity<>(errorDto, status);
	}
	
	@ExceptionHandler(value={FeedAPI400Exception.class})
    public ResponseEntity<Object> handleException(final FeedAPI400Exception ex) {
        ErrorWithoutIdDTO error = new ErrorWithoutIdDTO("Error", ex.getMessage());
        logger.error(ex.getMessage(), ex);

        return buildResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value={FeedAPI404Exception.class})
    public ResponseEntity<Object> handleException(final FeedAPI404Exception ex) {
        ErrorWithIdDTO error = new ErrorWithIdDTO(ex.getFeedId(), ex.getMessage());
        logger.error(ex.getMessage(), ex);

        return buildResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(FeedAPI500Exception.class)
	protected ResponseEntity<Object> handleException(final FeedAPI500Exception ex) {
		ErrorWithoutIdDTO error = new ErrorWithoutIdDTO("Error", ex.getMessage());
		logger.error(ex.getMessage(), ex);
		return buildResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
