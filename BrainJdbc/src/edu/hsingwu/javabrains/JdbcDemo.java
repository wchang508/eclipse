package edu.hsingwu.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hsingwu.javabrains.dao.JdbcDaoImpl;
import edu.hsingwu.javabrains.dao.SimpleJdbcDaoImpl;
import edu.hsingwu.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		/*for jdbc code
		Circle circle = new JdbcDaoImpl().getCircle(2);
		System.out.println(circle.getName());
		*/
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		/* Tutorial 38: Spring and DataSource Configuration 執行*/
		//Circle circle = dao.getCircle(2);
		//System.out.println(circle.getName());
		
		System.out.println(dao.getCircleCount());
		
		System.out.println(dao.getCircleName(2));
		
		System.out.println(dao.getCircleforId(1).getName());
		//dao.insertCircle(new Circle(3, "Third Circle"));
		dao.insertCircleParameter(new Circle(4, "Fourth Circle"));
		System.out.println(dao.getAllCircles().size());
		//dao.createTriangleTable();
		
		SimpleJdbcDaoImpl daos= ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		System.out.println(daos.getCircleCount());
		
		
	}

}
