package com.codingdojo.web.controllers;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Roster;
import com.codingdojo.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page;
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		//checking to see if id coming in...if so, then details page..if not, then make a team
		if (id != null ) {
			//Show a specific team
			System.out.println("We have an id and it is " + id + "\n");
			
			Roster roster = (Roster)session.getAttribute("roster");
			System.out.println("this far");
			
			Team thisTeam = roster.getOneTeam(id);
			
			System.out.println("this far2");
			
			request.setAttribute("thisTeam",  thisTeam);
			
			System.out.println("this far3");
			
			session.setAttribute("team", thisTeam);
			
			System.out.println("this far4");

			
			page = "/WEB-INF/TeamInfo.jsp";
			
			System.out.println("this far5");
		}
		else {
			// id is null, so let's make a team
			System.out.printf("ID is null, so let's make a team");
			page = "/WEB-INF/NewTeam.jsp";

		}
		
		//page = "/WEB-INF/NewTeam.jsp";
		
		request.getRequestDispatcher(page).forward(request, response);
		
//		RequestDispatcher view = request.getRequestDispatcher(page);
//        view.forward(request, response);
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String teamNameForm = (String) request.getParameter("teamName");
		System.out.printf("Did we get here with the team name of %s%n", teamNameForm);
		
		Team teamObj = new Team(teamNameForm);
		//so now we have a team and it has a team name
		System.out.printf("Team Name from object is %s", teamObj.getName());
		
		//Now that we have a new Team instance, add it to our Roster.
		Roster roster = (Roster)session.getAttribute("roster");
		roster.addTeam(teamObj);
		
		response.sendRedirect("/TeamRoster/Home");
		
		
		//doGet(request, response);
	}

}
