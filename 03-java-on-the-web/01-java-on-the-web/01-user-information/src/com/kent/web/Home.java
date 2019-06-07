package com.kent.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		if(firstName == null) firstName = "Unknown";
		
		String lastName = request.getParameter("lastName");
		if(lastName == null) lastName = "Unknown";
		
		String favLanguage = request.getParameter("favLanguage");
		if(favLanguage == null) favLanguage = "Unknown";
		
		String homeTown = request.getParameter("homeTown");
		if(homeTown == null) homeTown = "Unknown";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String outString= "<h1> Welcome,  " + firstName + "</h1>";
		outString += "<h2>Your favorite language is:  " + favLanguage + "<h2>";
		outString += "<h3>Your hometown is:  " + homeTown + "<h3>";
		out.write(outString);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
