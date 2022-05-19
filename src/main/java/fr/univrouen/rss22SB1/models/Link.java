package fr.univrouen.rss22SB1.models;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Link  {
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "rel")
	private String rel;
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "type")
	private String type;
	
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "href")
	private String href;
	
	
}
