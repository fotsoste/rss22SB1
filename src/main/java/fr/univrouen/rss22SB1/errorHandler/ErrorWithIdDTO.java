package fr.univrouen.rss22SB1.errorHandler;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlType(propOrder={"id", "status", "message"})
@JacksonXmlRootElement(localName = "error")
@Data

public class ErrorWithIdDTO {
	
	// identifiant de l'article dont le traiment à causé l'erreur
    private String id;

    //statut : error
    private String status = "Error";

    //details sur la cause de l'erreur
    private String message;

    public ErrorWithIdDTO(String id, String message) {
        this.id = id;
        this.message = message;
    }

}
