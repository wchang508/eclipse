package edu.hsingwu.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hsingwu.dto.User;
import edu.hsingwu.service.LoginService;

/**
 * MVC (Controller)
 */
@WebServlet("/loginPath")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId, password;
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		
		//business service (MVC) model
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		
		if(result){
			//request.getSession().setAttribute("user", userId);
			User user=loginService.getUserDetail(userId);
			/*request.getSession().setAttribute("userinfo", user);
			response.sendRedirect("success.jsp"); */    //pass to browser(client side); url show /success.jsp
			request.setAttribute("userInfo", user);
			RequestDispatcher dispatcher= request.getRequestDispatcher("success_jstl.jsp"); //pass in the server side (servlet or jsp); url show /loginPath
			dispatcher.forward(request, response); //user object is inside of request in line 45
			return;
		}
		else{
			response.sendRedirect("login.jsp");
			return;
		}
		
		
	}

}
