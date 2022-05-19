package fr.univrouen.rss22SB1.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import fr.univrouen.rss22SB1.models.Item;
import fr.univrouen.rss22SB1.models.Link;
import lombok.Data;

@XmlRootElement
@XmlType(propOrder={"id", "title", "prenom", "pubDate", "copyright"})
@JacksonXmlRootElement(localName = "feed")
@Data
public class FeedDto {
	
	private String id;
	private String title;
	
	private String pubDate;
	
	private String copyright;
	private Link link;
	private Item item;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

}
