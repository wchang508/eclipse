package edu.hsingwu.doa.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import edu.hsingwu.doa.model.User;
import edu.hsingwu.doa.service.LoginService;

public class LoginAction3 extends ActionSupport{
	
	/*non-model object*/
	private String userId;
	private String password; 
	
	private User user; //model object
	
	//private static String SUCCESS="success"; /*already inherited in Action interface and ActionSupport class*/
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public void validate()
	{
		if(StringUtils.isEmpty(getUserId()))
		{
			//User id is blank
			addFieldError("userId", "User ID blanked"); //method of ActionSupport class, pass error message to field(member) name
		}
		if(StringUtils.isEmpty(getPassword()))
		{
			//User id is blank
			addFieldError("password", "Password blanked");
		}
	}

	public String execute()
	{
		LoginService loginService = new LoginService();
		
		user= new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		if(loginService.verifyLogin(user))
			return SUCCESS;
		
		else
			//return "failure"; 
			return LOGIN; //defined in Action interface
		
	}

}
