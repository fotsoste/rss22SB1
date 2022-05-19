package fr.univrouen.rss22SB1.errorHandler;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlType(propOrder={"status", "message"})
@JacksonXmlRootElement(localName = "error")
@Data
public class ErrorWithoutIdDTO {
	
	private String status;

    private String message;

    public ErrorWithoutIdDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
