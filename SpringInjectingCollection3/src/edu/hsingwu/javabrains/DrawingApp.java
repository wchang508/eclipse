package edu.hsingwu.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		
		/* execution version 1
		Triangle triangle = new Triangle();
		triangle.draw();
		*/
		/* execution version 2
		BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle=(Triangle)factory.getBean("triangle");  //pass triangle id from spring.xml in BrainSpringDemo folder
		triangle.draw();
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle1=(Triangle)context.getBean("triangle1");  //can receive triangle bean id and bean name from spring.xml in src folder
		Triangle triangle=(Triangle)context.getBean("triangle");
		triangle1.draw();
		triangle.draw();
		
	
	}

}
