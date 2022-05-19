package fr.univrouen.rss22SB1.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlType(propOrder={"id", "status"})
@JacksonXmlRootElement(localName = "response")
@Data

public class ResponseDTO {
	
	// identifiant de l'article dont le traitement à causé l'erreur
    private String id;
    
    //statut : error
   private String status;

    public ResponseDTO(String id, String status) {
        this.setId(id);
        this.setStatus(status);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
