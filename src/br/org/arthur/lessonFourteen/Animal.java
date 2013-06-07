package br.org.arthur.lessonFourteen;

public class Animal {
	private String name = "Animal";
	public String favFood = "Food";
	
	public Animal()
	{
		
	}
	
	public Animal(String name, String favFood)
	{
		this.name = name;
		this.favFood = favFood;
	}
	
	protected final void changeName(String newName)
	{
		this.name = newName;
	}
	
	protected final String getName()
	{
		return this.name;
	}
	
	public void eatStuff()
	{
		System.out.println("Yumm " + this.favFood);
	}
	
	public void walkAround()
	{
		System.out.println(this.name + "walks around");
	}
}
