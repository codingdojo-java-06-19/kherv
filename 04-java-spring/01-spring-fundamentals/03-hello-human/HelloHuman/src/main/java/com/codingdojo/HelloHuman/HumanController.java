package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("") // I wanted to include it for reference, but don't have anything to prepend
public class HumanController {
	String secondLine= "<p>Welcome to SpringBoot</p>";
    @RequestMapping("/") //this makes it a root route:  "/"
    //sample strings that work:  http://localhost:8089/?q=Fred&q2=Jones; http://localhost:8089/ and this gives same as second:  http://localhost:8089/?q=Fred
    public String query(@RequestParam(value="q", required=false) String searchQuery, @RequestParam(value="q2", required=false) String lName) {
    	if(searchQuery == null || lName == null) {
    		return "<h2>Hello Human!</h2>" + secondLine;
    	}
    	else {
    		return "<h1>Hello " + searchQuery+ " " + lName +  "!</h1>" + secondLine;
    	}
    }
	
	
	
	
	
	
	

}
