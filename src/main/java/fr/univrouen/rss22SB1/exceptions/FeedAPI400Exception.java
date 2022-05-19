package fr.univrouen.rss22SB1.exceptions;

public class FeedAPI400Exception extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public FeedAPI400Exception(String message) {
        super(message);
    }

    public FeedAPI400Exception(String message, Throwable cause) {
        super(message, cause);
    }

}
