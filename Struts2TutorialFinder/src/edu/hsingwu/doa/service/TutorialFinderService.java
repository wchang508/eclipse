package edu.hsingwu.doa.service;

public class TutorialFinderService {

	public String getBestTutorialSite(String language)
	{
		
		if (language.equals("java"))
		{
			//struct08: Accessing input parameter
			//http://localhost:8080/BrainStruts2Starter/tutorials/getTutorial?language=java
			return "Java Good";
		}
		else
		{
			//http://localhost:8080/BrainStruts2Starter/tutorials/getTutorial?language=dotnet
			return "Language not supported yet!";
		}
		
	}
}
