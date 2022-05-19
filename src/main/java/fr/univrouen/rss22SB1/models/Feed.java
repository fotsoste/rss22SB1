package fr.univrouen.rss22SB1.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlType(propOrder={"id", "title", "pubDate", "copyright", "link", "item"})
@Document

@JacksonXmlRootElement(localName = "feed")
@Data
public class Feed {
	
	
	@Id
	private String id;
	
	

	private String title;
	
	private String pubDate;
	
	private String copyright;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "link")
	 private List<Link> links;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "item")
	 private List<Item> items;
	
	
	
	public List<Link> getLinks(){
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
