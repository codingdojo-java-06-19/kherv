package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.codingdojo.web.models.Roster;
import com.codingdojo.web.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Pull out the id from the paramater and use it to identify which team had been clicked on
		String id = request.getParameter("id");
		Roster roster = (Roster)session.getAttribute("roster");
		Team thisTeam = roster.getOneTeam(id);
		session.setAttribute("thisTeam", thisTeam);
		request.setAttribute("thisTeam", thisTeam);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");
        view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Pull out the name of the player from the form info and use it to create a new instance of a Player.
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("We want to make a new player named "+firstName+" "+lastName+" who is "+age+ " years old.");
		
		Team thisPlayersTeam = (Team)session.getAttribute("thisTeam");
		thisPlayersTeam.addPlayer(firstName, lastName, age);
		
		//After we create a new player, we need to redirect back to the team's page we came from.
		//That means we have to pull our team out of session and get it's id...
		
		int teamId = thisPlayersTeam.getId();
		
		//...so that we can append it to our url path for a successful redirect.
		String path = "/TeamRoster/Teams?id=";
		response.sendRedirect(path+teamId);
	}

}
