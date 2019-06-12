package com.codingdojo.firstproject2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JSPController2 {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
  
    
    
}  // end class


//Before Controllers and View tab, it was:
//	public String home() {
//	return "index.jsp";
//}
