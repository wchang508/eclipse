package edu.hsingwu.doa.action;

import com.opensymphony.xwork2.Action;

public class LoginAction2 implements Action {
	
	private String userId;  //corresponds to the login.jsp key="userId"
	private String password; //corresponds to the login.jsp key="userId"
	
	
	
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
	
	public String execute()
	{ 
		if(getUserId().equals("userId") && getPassword().equals("password"))
		{
			return SUCCESS; //inherited from the action interface
		}
		
			return LOGIN; //inherited from action interface
		
	}

}
