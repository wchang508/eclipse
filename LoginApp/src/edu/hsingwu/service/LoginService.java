package edu.hsingwu.service;

import java.util.HashMap;

import edu.hsingwu.dto.User;

public class LoginService {
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService()
	{
		users.put("johndoe", "John Doe");
		users.put("ianchang", "Ian Chang");
		users.put("willchang", "Will Chang");
				
	}
	
	public boolean authenticate(String userId, String password)
	{
		if(password == null || password.trim() =="")
			return false;
		return true;
	}
	
	public User getUserDetail(String userId)
	{
		User user=new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user; 
		
	}

}
