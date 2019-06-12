package com.codingdojo.DisplayDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class DateController {
	Date curDate = new Date();
	//SimpleDateFormat format;
	//String DateToStr = format.format(curDate);
	
	@RequestMapping("/") //dashboard page
	public String index(Model model) {
		String tested ="Dashboard Page";
		model.addAttribute("tester", tested);
		return "index.jsp";
	}
  
	@RequestMapping("/date") //date route to render date
	public String date(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy ");
        String DateToStr = format.format(curDate);
		model.addAttribute("dateOut", DateToStr);
		return "date.jsp";
	}
	
	@RequestMapping("/time") //time route to render time
	public String time(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss z");
        String DateToStr = format.format(curDate);
		model.addAttribute("timeOut", DateToStr);
		return "time.jsp";
	}
	
	
    
    
}  // end class


//Before Controllers and View tab, it was:
//	public String home() {
//	return "index.jsp";
//}
