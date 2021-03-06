package edu.hsingwu.javabrains;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

/*role of Bean */
//@Component  // do not need to define circle in the spring.xml
//@Service  //Service Bean
@Repository //Data Object
//@Controller //Controller Object
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	
	private Point center;
	private ApplicationEventPublisher publisher;
	
	
	@Autowired
	private MessageSource messageSource; //mapping to spring bean id="messageSource"

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default drawing.circle", null)); 
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()}, "Default point message", null));
		//System.out.println(this.messageSource.getMessage("greeting", null, "Default greeing", null));  //spring circle bean
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
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

	@Override  //spring will execute this method and provide publisher handle to this circle bean
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}

}
