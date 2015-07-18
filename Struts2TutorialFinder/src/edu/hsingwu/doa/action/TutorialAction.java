package edu.hsingwu.doa.action;

import edu.hsingwu.doa.service.TutorialFinderService;

public class TutorialAction {
	
	private String bestTutorialSite; //member variable of this action which show this data on the Success.jsp page
	private String language;  //Value Stack, set private member variable
	
	public String execute(){
		
		
		//A tag and a business service
		TutorialFinderService tutorialFinderService = new TutorialFinderService(); //build a service object
		String bestTutorialSite = tutorialFinderService.getBestTutorialSite(getLanguage()); //service find the result and pass to the object local variable(value stack)
		setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));//pass result to member variable again(not necessary)
		System.out.println(language+", "+getLanguage()); //Interceptor will access input parameter and pass to value stack
		////http://localhost:8080/Struts2TutorialFinder/tutorials/getTutorial?language=java
		return "success";
	}
	
	public String updateTutorialMethod()
	{
		System.out.println("update Tutorial method executed!");
		return "success";	
	}
	
	public String addTutorialMethod()
	{
		System.out.println("Add Tutorial method executed!");
		return "success";
	}
	

	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
