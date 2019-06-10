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
@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		int count = (session.getAttribute("numSess2")==null? 0 : (int)session.getAttribute("numSess2"));

		System.out.printf("count is  %d%n", count);
		
		session.setAttribute("numSess2", count);
		
		System.out.printf("Session value after plus 1 then conversion to string then session setAttribute %s%n", session.getAttribute("numSess2"));
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		System.out.println("In Post");
		
		int count = (int)session.getAttribute("numSess2");
		
		count++;
		session.setAttribute("numSess2", count);
		
		System.out.println(count);
		
		response.sendRedirect("/ButtonClicker/Counter");
		
//		doGet(request, response);
	}

}