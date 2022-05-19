package fr.univrouen.rss22SB1.models;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import fr.univrouen.rss22SB1.dto.FeedDto;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "result")
public class Result {
	
	@JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "feed")
    private List<FeedDto> feeds;
	
	public List<FeedDto> getFeeds(){
		return feeds;
	}
	
	public void setFeeds(List<FeedDto> feeds) {
		this.feeds = feeds;
	}

}
