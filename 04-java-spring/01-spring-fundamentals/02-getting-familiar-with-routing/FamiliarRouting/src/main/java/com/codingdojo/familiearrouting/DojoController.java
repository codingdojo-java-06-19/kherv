package com.codingdojo.familiearrouting;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

    //below uses path parameters which are in the URL versus at the end
    @RequestMapping("/{track}")
    public String dojo(@PathVariable("track") String track){
    	if (track.equals("dojo")) {
    		System.out.println("dojo");
    		return "The dojo is awesome";
    	}
    	else if (track.equals( "burbank-dojo")) {
    		System.out.println("dojo");
    		return "Burbank Dojo is located in Southern California";
    	}
    	else if(track.equals("san-jose")) {
    		System.out.println("dojo");
    		return "SJ dojo is headquarters";
    	}
    	System.out.println(track);
    	return "error happened and input was " + track;
    }

   
    
}  // end class
