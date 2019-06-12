package com.codingdojo.firstproject2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Hello World! and Universe";
    }
    
    @RequestMapping("/world")
    public String world() {
    	return "Class level annotations are cool too!";
    }
    
    //an example of passing by query from platform tab:
    //sample URL for testing:  http://localhost:8087/hello/query?q=BillyBob
    
    @RequestMapping("/query")
    public String query(@RequestParam(value="q", required=false) String searchQuery) {
    	if(searchQuery == null) {
    		return "You searched for: nothing";
    	}
    	else {
    		return "you searched for: " + searchQuery;
    	}
    }
    //below uses path parameters which are in the URL versus at the end
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
    
    
    
    
}  // end class
