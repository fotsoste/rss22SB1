package fr.univrouen.rss22SB1.models;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;


@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Image  {
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "type")
	private String type;
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "href")
	private String href;
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "alt")
	private String alt;
	
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "length")
	private int length;
	
	

}
