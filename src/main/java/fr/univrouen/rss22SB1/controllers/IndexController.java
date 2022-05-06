package fr.univrouen.rss22SB1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	
	
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(); 
		
		mav.setViewName("index.html");
		 
		return mav;
		
	}
	
	
	 @Value("${mymessage}")
    private String message;

	 @GetMapping("/getMessage2")
	 public ModelAndView getMessage() {

	     var mav = new ModelAndView();
	     mav.addObject("message", message);
	     mav.setViewName("show");

	     return mav;
	 }

}
