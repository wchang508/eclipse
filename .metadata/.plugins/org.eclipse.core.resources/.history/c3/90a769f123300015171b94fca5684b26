package edu.hsingwu.java.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginAspect {
	
	@Before("execution(public String getName())")
	public void LoginAdvice()
	{
		System.out.println("Advice run. Get Method called");
	}

}
