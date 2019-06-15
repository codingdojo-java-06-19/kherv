package com.codingdojo.Lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;


@Controller
@RequestMapping("/search")
public class SearchController {
	private final SongService songService;
	
	public SearchController(SongService songService) {
		this.songService = songService;
	}
	
	//Display Top Ten
	@RequestMapping("/topTen")
	public String TopTen(Model model) {
		List<Song> topTen = songService.findTopTen();
		model.addAttribute("topsongs", topTen);
		return"topten.jsp";
	}
	
	//Get by search
	@RequestMapping(value="", method=RequestMethod.POST)
	public String searchArtist(@RequestParam(value="searchQuery") String search, Model model) {
		System.out.println("one");
		List<Song> songsWithArtist = songService.findArtist(search);
		System.out.println("two");
		model.addAttribute("search", search);
		System.out.println("three");
		model.addAttribute("songsFromArtist", songsWithArtist);
		System.out.println("four");
		return "search.jsp";
	}
	
}
