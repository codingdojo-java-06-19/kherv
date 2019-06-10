package com.kenthervey.greatnumber;

//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;



/**
 * Servlet implementation class Number
 */
@WebServlet("/Number")
public class Number extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Number() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		
		session.setAttribute("showForm", "yes");
		
		
		
		int targetNumber = (session.getAttribute("targetNumber")==null? getRandomOne100() : (int)session.getAttribute("targetNumber"));
		
		
		session.setAttribute("targetNumber", targetNumber);
		request.setAttribute("targetNumberR", targetNumber);
		
		String guessResultS = (String)session.getAttribute("guessResult");
		request.setAttribute("guessResultR", guessResultS);
		
		//System.out.printf("Target Number is:  %d%n, (int)session.getAttribute('targetNumber')");
		

		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String redirectLocation = "/GreatNumberGame/Number";
		
		String guess = request.getParameter("inputNumber");
		if(guess=="") {
			response.sendRedirect(redirectLocation);
			return;
		}
		else {
			session.setAttribute("didGuess", "yes");
		}
		
		System.out.printf("Printing request InputNumber %s", guess);
		
		int guessInt = Integer.parseInt(guess);
		int targetNumberInt = (int)session.getAttribute("targetNumber");
		 
		if(guessInt == targetNumberInt) {
			System.out.printf("Your guess was correct, %d%n", guessInt);
			session.setAttribute("guessResult", "0");
		}
		else if (guessInt < targetNumberInt) {
			System.out.printf("Target Number is  %d  ",targetNumberInt);
			System.out.printf("Your guess %d was too low, %n", guessInt);
			session.setAttribute("guessResult", "-1");
		}
		else {
			System.out.printf("Target Number is  %d  ",targetNumberInt);
			System.out.printf("Your guess %d was too High, %n", guessInt);
			session.setAttribute("guessResult", "1");
		}
		
		response.sendRedirect(redirectLocation);
		
	}

	public static int getRandomOne100(){
		double smallRandom =Math.random();
		int randomInRange =(int) (smallRandom * (double)(100));
	    return randomInRange;
	}
	
	
}
