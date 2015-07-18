package edu.hsingwu.javabrains;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		
		
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle)context.getBean("triangle2");  //can receive triangle bean id and bean name from spring.xml in src folder
		triangle.draw();
		*/
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Triangle2 triangle=(Triangle2)context.getBean("triangle_second"); 
		triangle.draw();
		
	
	}

}
