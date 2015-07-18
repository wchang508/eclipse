package edu.hsingwu.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		
		/* execution without using spring
		Triangle triangle = new Triangle();
		triangle.draw();
		*/
		/* execution by XmlBeanFactory object
		BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle=(Triangle)factory.getBean("triangle");  //pass triangle id from spring.xml in BrainSpringDemo folder
		triangle.draw();
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle)context.getBean("triangle2");  //pass triangle id from spring.xml in src folder
		triangle.draw();
		
	
	}

}
