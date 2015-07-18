package edu.hsingwu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String userName=request.getParameter("userName");
		String fullName=request.getParameter("userName");
		PrintWriter out=response.getWriter();
		out.println("Hello from GET method! "+ userName);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String userName=request.getParameter("userName");
		String fullName=request.getParameter("fullName");
		String prof=request.getParameter("prof");
		
		PrintWriter out=response.getWriter();
		out.println("Hello from POST method! "+ userName+"! Your full name is "+ fullName);
		out.println("You are a "+ prof);
		String[] locations = request.getParameterValues("location");
		out.println("You are at "+ locations.length+ " places");
		for (int i=0; i<locations.length; i++)
		{
			out.println(locations[i]);
		}
				
	}

}
