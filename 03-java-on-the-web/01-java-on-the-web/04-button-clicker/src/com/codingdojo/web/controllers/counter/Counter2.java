package com.codingdojo.web.controllers.counter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/Counter-deletemelater")
public class Counter2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("here");

		int numClicksInt = (session.getAttribute("numClickSess")==null? 0 : (int)session.getAttribute("numClickSess"));
		
		request.setAttribute("numClickSess2", numClicksInt);
		
		System.out.printf("value after ternary is  %d%n", numClicksInt); // null for now


		System.out.printf("still int after plus 1 %d%n", numClicksInt);
		
		//int numClicksInt = 24;
		System.out.printf("Session value after plus 1 then conversion to string then session setAttribute %s%n", session.getAttribute("numCickSess"));
		
		
 		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("Posting content!");
		int numClickInt = (int)session.getAttribute("numClickSess");
//		numClickInt++;
//		session.setAttribute("numClickSess", numClickInt);
//		System.out.println(numClickInt);
		response.sendRedirect("/ButtonClicker/Counter");
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
