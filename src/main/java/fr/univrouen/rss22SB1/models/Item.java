package fr.univrouen.rss22SB1.models;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Item  {
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "guid")
	private String guid;
	
	private String title;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	 private List<Category> categories;
	
	private String published;
	private Image image;
	private Content content;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	 private List<Author> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	
	

}
