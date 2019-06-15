package com.codingdojo.Lookify.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;


@Controller
//@RequestMapping("")
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}

	//splash page with one link to index or dashboard page
	@RequestMapping("/") 
	public String splash() {
		return "home.jsp";
	}
	
	//show all
	@RequestMapping("/dashboard") 
	public String index(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "index.jsp";
	}

	//make one song
	 @RequestMapping("/songs/new")
	 public String newSong(@ModelAttribute("song") Song song) {
		 return "new.jsp";
	 }
	
	 @RequestMapping(value="/songs", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		 if (result.hasErrors()) {
			 System.out.println("error happened here");
			 return "new.jsp";
		 }
		 songService.createSong(song);
		 System.out.println("We are trying to go back to dashboard");
		 return "redirect:/dashboard";
	 }
	 
	
	//show one
	 @RequestMapping("/songs/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
	 model.addAttribute("songs", songService.findSong(id));
	 return "show.jsp";
	 }
	 
	//no update
	
	//delete
	 @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	 public String destroy(@PathVariable("id") Long id, RedirectAttributes redirectattrs) {
		 songService.deleteSong(id);
		 redirectattrs.addFlashAttribute("success", "Successfully Deleted!!");
		 return "redirect:/dashboard";
	 }
	
	

}
