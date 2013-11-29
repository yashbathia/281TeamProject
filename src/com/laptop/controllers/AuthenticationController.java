package com.laptop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptop.dao.UserDAO;
import com.laptop.dao.UserDAOImpl;
import com.laptop.exception.LCAppException;
import com.laptop.pojo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/AuthController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AuthenticationController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Inside POST method of servlet");
		String operation = request.getParameter("operation");
		UserDAO authDaoImpl = new UserDAOImpl();
		User userDto = null;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		try {
		if(operation.equalsIgnoreCase("login"))
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		
			userDto = authDaoImpl.login(email, password);
			if (userDto!=null)
			{
				session.setAttribute("user", userDto);
				out.print("success:Login successful!");
			}else{
				out.print("failed:Login Failed, Please Try Again");
				
			}
			   
					
		}else
		{
			
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			userDto = new User();
			userDto.setUsername(firstName + " "+lastName );
			userDto.setEmail(email);
			userDto.setPassword(password);
			boolean result = authDaoImpl.registration(userDto);
			
			if(result){
				out.print("success:Registration successful!");
			}else
			{
				out.print("failed:Registration Failed, Try Again");
			}
			
			
		}
		} catch (LCAppException e) {
			e.printStackTrace();
			out.print("failed:"+e.getMessage());
		}
	
	}

}
