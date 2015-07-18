package edu.hsingwu.javabrains;

public class Triangle {
	
	private String type;
	private int height;
	
	public int getHeight() {
		return height;
	}

	//<constructor-arg/>
	public Triangle(String type)
	{
		this.type=type;
	}
	
	public Triangle(int height)
	{
		this.height=height;
	}
	
	public Triangle(String type, int height)
	{
		this.type=type;
		this.height=height;
	}
	
	public String getType() {
		return type;
	}
	
	
/* <property name="type" value="Equilateral" /> pass value by spring.xml automatically
 * 
	public setType(String type) {
		this.type = type;
	}
*/
	public void draw()
	{
		System.out.println(getType()+" Triangle drawn of height "+ getHeight());
	}

}
