package br.org.arthur.lessonFourteen;

public class Cat extends Animal {
	
	public String favToy = "Yarn";
	
	public void playWith()
	{
		System.out.println("Yeah " + this.favToy);
	}
	
	@Override
	public void walkAround()
	{
		System.out.println(this.getName() + " stalks around");
	}
	
	public String getToy()
	{
		return this.favToy;
	}
	
	public Cat()
	{
		
	}
	
	public Cat(String name, String favFood, String favToy)
	{
		super(name, favFood);
		this.favToy = favToy;
	}
}
