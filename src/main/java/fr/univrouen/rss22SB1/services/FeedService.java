package fr.univrouen.rss22SB1.services;

import java.util.List;
import java.util.Optional;
import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univrouen.rss22SB1.dto.FeedDto;
import fr.univrouen.rss22SB1.models.Feed;

@Service
public class FeedService {
	
	public boolean validateFeed(Feed feed) {
	    try
	    {
	      // creér un SchemaFactory 
	      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	      // chargé le format xsd de vérification  avec une  instance  Schema
	      Source xsdFile = new StreamSource(new File("src/main/resources/fichier.xsd"));
	      Schema schema = factory.newSchema(xsdFile);

	      // créer un Validator 
	      Validator validator = schema.newValidator();

	      // convertir objet CV en fichier xml
	      File xmlFile = getXMLFromFeed(feed);
	      if(xmlFile == null)
	        return false;

	      // valider le cv 
	      validator.validate(new StreamSource(xmlFile)); 
	     
	      return true;
	    }
	    catch(Exception ex)
	    {
	      return false;
	    }
	  }
	
	 private File getXMLFromFeed(Feed feed) {
		    try {
		        JAXBContext jc = JAXBContext.newInstance(Feed.class);

		        Marshaller marshaller = jc.createMarshaller();
		        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		        // fichier xml
		        File xmlFile = new File("feed.xml");
		        marshaller.marshal(feed, xmlFile);

		        return xmlFile;
		    }
		    catch(Exception ex) {
		        return null;
		    }
		  }
	 
	// fonction helper qui permet de passer d'un CV à un CvDto

	  public FeedDto getFeedDtoFromFeed(Feed feed) {

	    //le CvDto à retourner
		FeedDto feedDto = new FeedDto();
		feedDto.setId(feed.getId());
		feedDto.setPubDate(feed.getPubDate());
		feedDto.setTitle(feed.getTitle());
		feedDto.setLink(feed.getLinks().get(0));
		feedDto.setItem(feed.getItems().get(0));

	    return feedDto;
	  }
	  
	  
	  


}
