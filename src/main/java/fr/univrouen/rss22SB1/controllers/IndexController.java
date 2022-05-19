package fr.univrouen.rss22SB1.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.univrouen.rss22SB1.util.FeedUtil;


@Controller
public class IndexController {

  @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<String> getInfo()  {
    FeedUtil feedUtil = new FeedUtil();

    return ResponseEntity.ok(feedUtil.loadFileXML());
  }
  
  @GetMapping("/help")
	public String help(Model model) {
		
		
		
		 
		return "help";
		
	}

}