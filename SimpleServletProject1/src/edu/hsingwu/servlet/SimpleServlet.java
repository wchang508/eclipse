package edu.hsingwu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "simple servlet", urlPatterns = { "/SimpleServletPath"},
			initParams={@WebInitParam(name="defaultUser", value="John Doe")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName=request.getParameter("name");
		PrintWriter out= response.getWriter();
		out.println("<h3>Hello from GET</h3> "+userName);
		
		HttpSession session=request.getSession();
		ServletContext context= request.getServletContext();
		
		if (userName !="" && userName != null)
		{
			session.setAttribute("saveUserName", userName);
			context.setAttribute("saveUserName", userName);
		}
		out.println("Request parameter is "+ userName);
		out.println("Session parameter is "+ (String)session.getAttribute("saveUserName"));
		out.println("Context parameter is "+ (String)context.getAttribute("saveUserName"));
		out.println("Init parameter default name is "+ getServletConfig().getInitParameter("defaultUser"));
		
	}

}
