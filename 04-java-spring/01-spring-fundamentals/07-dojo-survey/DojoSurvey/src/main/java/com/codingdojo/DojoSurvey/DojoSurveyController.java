package com.codingdojo.DojoSurvey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	@RequestMapping("/") 
	public String index() { //because we don't render on a post
		return "index.jsp";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String showResult(HttpSession session, @RequestParam(value="personName") String personNameStr, @RequestParam(value="dojoLocation") String dojoLocationStr, @RequestParam(value="favoriteLanguage") String favoriteLanguageStr, @RequestParam(value="userComment") String userCommentStr, RedirectAttributes redirectAttributes) {
		System.out.println("here");
		System.out.printf("parameters received are:  name, %s; Dojo Location, %s; Favorite Language, %s, Comments, %s", personNameStr, dojoLocationStr, favoriteLanguageStr, userCommentStr);
		session.setAttribute("personName", personNameStr);
		session.setAttribute("dojoLocation", dojoLocationStr);
		session.setAttribute("favoriteLanguage", favoriteLanguageStr);
		session.setAttribute("userComment", userCommentStr);
		
		
		
		
		
		
		
		
		
		
			return "redirect:/next";	
	}
	
	@RequestMapping("/next") 
	public String goBack() { //because we don't render on a post
		return "showOne.jsp";
	}

} // end class

//<p>Name:  <c:out value="${personName}"/></p>
//<p>Dojo Location:  <c:out value="${dojoLocation}"/></p>
//<p>Favorite Language:  <c:out value="${favoriteLanguage}"/></p>
//<p>Comment:  <c:out value="${userComment}"/></p>










