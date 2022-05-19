package fr.univrouen.rss22SB1.models;

import javax.xml.bind.annotation.*;

import lombok.Data;
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Author  {
	
	private String name;
	
	private String email;
	
	private String uri;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
