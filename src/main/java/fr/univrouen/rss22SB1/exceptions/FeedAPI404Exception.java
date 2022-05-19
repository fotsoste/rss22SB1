package fr.univrouen.rss22SB1.exceptions;

public class FeedAPI404Exception extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    //l'identifiant de l'article
    private String feedId;

    public FeedAPI404Exception(String feedId, String message) {
        super(message);
        this.setFeedId(feedId);
    }

    public FeedAPI404Exception(String feedId, String message, Throwable cause) {
        super(message, cause);
        this.setFeedId(feedId);
    }

	public String getFeedId() {
		return feedId;
	}

	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

}
