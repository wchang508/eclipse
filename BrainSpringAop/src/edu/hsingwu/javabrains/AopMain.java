package edu.hsingwu.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hsingwu.javabrains.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService=ctx.getBean("shapeService", ShapeService.class);
		//System.out.println(shapeService.getTriangle().getName());
		System.out.println(shapeService.getCircle().getName());
	}

}
