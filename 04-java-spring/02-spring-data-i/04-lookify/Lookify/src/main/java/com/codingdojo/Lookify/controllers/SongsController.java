package com.codingdojo.Lookify.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.Lookify.services.SongService;


@Controller
@RequestMapping("")
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/") 
	public String splash
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
}
	
	

}
