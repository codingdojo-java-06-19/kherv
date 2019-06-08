package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher; //imported using Organize imports ..as were some others
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.web.models.Person; //imported using Organize imports 

/**
 * Servlet implementation class ShowPerson
 */
@WebServlet("/ShowPerson")
public class ShowPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
				
		// Create model
		Person person = new Person(name, age);
		
		// Set Model for view
		request.setAttribute("person", person);
		// Let view handle the request
 		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/showPersons.jsp");
		view.forward(request, response);
		
		
		response.getWriter().append("Served attt: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
