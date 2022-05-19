package fr.univrouen.rss22SB1.exceptions;

public class FeedAPI500Exception extends RuntimeException{
private static final long serialVersionUID = 1L;
    
    public FeedAPI500Exception(String message) {
        super(message);
    }

    public FeedAPI500Exception(String message, Throwable cause) {
        super(message, cause);
    }

}
