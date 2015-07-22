package edu.hsingwu.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hsingwu.java.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService= ctx.getBean("shapeService", ShapeService.class); //bean name
		shapeService.getCircle().setName("Dummy name");
		System.out.println(shapeService.getCircle().getName());
	}

}
