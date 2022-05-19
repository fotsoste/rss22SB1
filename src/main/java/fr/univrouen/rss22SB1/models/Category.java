package fr.univrouen.rss22SB1.models;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)

public class Category  {
	@JacksonXmlProperty(isAttribute = true)
    @XmlAttribute(name = "term")
	private String term;
	
	
}
