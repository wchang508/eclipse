package edu.hsingwu.javabrains;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

/*
 * public class Triangle implements InitializingBean, DisposableBean {
 */

public class Triangle {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public void myInit() //spring.xml init_mehohod defined in here without using InitializingBean and DisposableBean
	{
		System.out.println("InitializingBean init method called for Triangle");
	}
	
	public void cleanup()
	{
		System.out.println("InitializingBean disposable method called for Triangle");
	}
	
	public void draw()
	{
		System.out.println("Point A = (" +getPointA().getX()+", "+getPointA().getY() +")");
		System.out.println("Point B = (" +getPointB().getX()+", "+getPointB().getY() +")");
		System.out.println("Point C = (" +getPointC().getX()+", "+getPointC().getY() +")");
	}


	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

/*
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init method called for Triangle"); //post Bean creation
		
	}


	@Override
	public void destroy() throws Exception {
		// destroy bean
		System.out.println("InitializingBean disposable method called for Triangle");
		
	}

*/
	

}
