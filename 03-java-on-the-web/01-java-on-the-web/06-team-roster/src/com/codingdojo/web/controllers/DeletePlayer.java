package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Roster;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("I've reached the Delete a Player page! Now I'm going back home");
		String playerId = request.getParameter("playerid");
		String teamId = request.getParameter("teamid");
		Roster roster = (Roster)session.getAttribute("roster");
		
		
		roster.removePlayerFromTeam(teamId, playerId);
		String path = "/TeamRoster/Teams?id=";
		response.sendRedirect(path+teamId);
	}

}
