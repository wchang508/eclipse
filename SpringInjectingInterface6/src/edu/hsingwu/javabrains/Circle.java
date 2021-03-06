package edu.hsingwu.javabrains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle implements Shape {
	
	
	private Point center;

	public Point getCenter() {
		return center;
	}
	/*
	@Required // telling spring this is a required member variable, <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
	public void setCenter(Point center) {
		this.center = center;
	}
	*/
	
	/*
	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}
	*/
	
	/*
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}
	*/
	
	@Resource(name="point3")  //If we did not define name ="point3", spring will looking for bean id "center"
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is: ("+ center.getX()+", "+center.getY()+")");
	}
	
	@PostConstruct
	public void initializeCircle()
	{
		System.out.println("Init of Circle");
	}
	
	@PreDestroy  //Should register shutdownhook in DrawingApp.java in order to work
	public void destoryCircle()
	{
		System.out.println("Destory of Circle");
	}

}
