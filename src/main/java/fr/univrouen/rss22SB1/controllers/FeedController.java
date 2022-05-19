package fr.univrouen.rss22SB1.controllers;

import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.univrouen.rss22SB1.dto.ResponseDTO;
import fr.univrouen.rss22SB1.models.Result;
import fr.univrouen.rss22SB1.exceptions.FeedAPI400Exception;
import fr.univrouen.rss22SB1.exceptions.FeedAPI404Exception;
import fr.univrouen.rss22SB1.models.Feed;
import fr.univrouen.rss22SB1.repository.FeedRepository;
import fr.univrouen.rss22SB1.services.FeedService;

import org.springframework.ui.Model;


@Controller
@CrossOrigin
public class FeedController {
	
	@Autowired
    private FeedService feedService;
	@Autowired
    private FeedRepository feedRepo;
	
	private static final String FEED_NOT_FOUND = "l'article n'existe pas";
    private static final String ID_INCORRECT = "Identifiant incorrect";
    private static final String INVALID_XML = "l'article ne respecte pas le format du xsd";
    
    @PostMapping(
            value="/rss22/insert",
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE
    )
    
    @ResponseBody
    public ResponseEntity<ResponseDTO> addFeed(@RequestBody Feed feed) {
        // vérifier que l'article est conforme au xsd
        if(!feedService.validateFeed(feed))
            throw new FeedAPI400Exception(INVALID_XML);
        
        // // vérifier que l'article n'est exite pas déjà
        Optional<Feed> feedQ = feedRepo.findIfExist(
        	feed.getTitle(),
        	feed.getPubDate(),
        	feed.getCopyright());
        
        if (feedQ.isPresent()) {
            throw new FeedAPI400Exception("article déjà existant");
        }

        //insertion de l'article dans la base
        feed = feedRepo.save(feed);

        return ResponseEntity.ok(new ResponseDTO(feed.getId(), "INSERTED")); 
    }
    
    @GetMapping(
            value="/rss22/resume/xml/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    @ResponseBody
    public ResponseEntity<Feed> getFeedWithId(@PathVariable String id) {

        if ( id.isEmpty() || id.isBlank())
            throw new FeedAPI400Exception(ID_INCORRECT);

        Optional<Feed> feed = feedRepo.findById(id);
        if (feed.isEmpty())
            throw new FeedAPI404Exception(id, FEED_NOT_FOUND);
        
        return ResponseEntity.ok(feed.get());
    }
    
    @GetMapping(value="/rss22/resume/html/{id}")
    public String getFeedInHTMLFormat(@PathVariable String id, Model model) {
        if ( id.isEmpty() || id.isBlank()) {
            throw new FeedAPI400Exception(ID_INCORRECT);
        }
        // récupérer l'article depuis la base de donnée
        Optional<Feed> feed = feedRepo.findById(id);

        if (feed.isEmpty()) {
            throw new FeedAPI404Exception(id, FEED_NOT_FOUND);
        }
        // Mise en forme de la date
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String date = format.format(new Date());
        model.addAttribute("date", date);

        // Création des attributs pour insertion dans la page HTML via Thymeleaf
        model.addAttribute("feed", feed.get());

        // Création de la page HTML avec le template "accueil.html"
        return "feed";
    }
    
    @GetMapping(
            value="/rss22/resume/xml",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    @ResponseBody
    public ResponseEntity<Result> getAllFeed() {
        //le resultat à retourner 
        Result result = new Result();
        result.setFeeds(new ArrayList<>());

        //récuper la liste des articles  et la mapper en lite de FeedDTO
        for(Feed feed: feedRepo.findAll()) {
            result.getFeeds().add(feedService.getFeedDtoFromFeed(feed));
        }

        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping(
            value="/delete/{id}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteCVWithId(@PathVariable String id) {

        if ( id.isEmpty() || id.isBlank()) {
            throw new FeedAPI400Exception(ID_INCORRECT);
        }

        Optional<Feed> feed = feedRepo.findById(id);
        if (feed.isEmpty()) {
            throw new FeedAPI404Exception(id, FEED_NOT_FOUND);
        }

        // supression du cv
        feedRepo.deleteById(id);
        
        return ResponseEntity.ok(new ResponseDTO(id, "DELETED"));
    }



}
