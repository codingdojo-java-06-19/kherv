package com.codingdojo.SpringCounter;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	Date curDate = new Date();
	//SimpleDateFormat format;
	//String DateToStr = format.format(curDate);
	
	@RequestMapping("") //dashboard page
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("numTimes") == null) {
			session.setAttribute("numTimes", 0);
		}
		//do the counter stuff here
		Integer numCount =(Integer) session.getAttribute("numTimes");
		numCount++;
		
		session.setAttribute("numTimes", numCount);
		return "welcome.jsp";
	}
  
	@RequestMapping("/counter") //date route to render date
	public String date(HttpSession session, Model model) {
		Integer numCount =(Integer) session.getAttribute("numTimes");
		if (session.getAttribute("numTimes") == null) {
			session.setAttribute("numTimes", 0);
		}	
		//int testNum = -22;
		return "current.jsp";
	}
	
}  // end class


//Before Controllers and View tab, it was:
//	public String home() {
//	return "index.jsp";
//}
