package edu.hsingwu.doa.action;
import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.hsingwu.doa.model.User;
import edu.hsingwu.doa.service.LoginService;

public class LoginAction4 extends ActionSupport implements ModelDriven<User>{
	
	
	private User user= new User(); //model object
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	@Override
	public void validate()
	{
		if(StringUtils.isEmpty(user.getUserId()))
		{
			//User id is blank
			addFieldError("userId", "User ID blanked"); //method of ActionSupport class, pass error message to field(member) name
		}
		if(StringUtils.isEmpty(user.getPassword()))
		{
			//User id is blank
			addFieldError("password", "Password blanked");
		}
	}

	public String execute()
	{
		LoginService loginService = new LoginService();
		
		
		if(loginService.verifyLogin(user))
			return SUCCESS;
		
		else
			//return "failure"; 
			return LOGIN; //defined in Action interface
		
	}

	@Override //return model object
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
