package edu.hsingwu.javabrains;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//Aspect class definition
@Aspect
public class LoggingAspect {
	
	//@Before("execution(public String edu.hsingwu.javabrains.model.Circle.getName())")
	//@Before("execution (public String getName())")
	/*@Before("execution (public * get*( * means [1 or more argument] | .. means [0 or more] ))")  
	  wild card: call any method with any return and any arguments start with get */
	@Before("allGetters() && allCircleMethod()")
	public void LoggingAdvice()
	{
		System.out.println("Advice Run. Get Method Called");
	}
	
	//@Before("execution(* get*())")
	@Before("allGetters()")
	public void SecondAdvice()
	{
		System.out.println("Second Advice executed. ");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		//dummy method, just to define Pointcut expression 
	}
	
	//@Pointcut("execution(* * edu.hsingwu.javabrains.model.Circle.*(..))")
	@Pointcut("within(edu.hsingwu.javabrains.model.Circle)") //class name not function name 
	public void allCircleMethod()
	{}
	
	//@Pointcut(args()) method that match this argument
	
	
}
