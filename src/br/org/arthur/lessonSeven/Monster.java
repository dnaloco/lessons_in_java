package br.org.arthur.lessonSeven;

public class Monster {
	
	public final String TOMBSTOME = "Here lies a dead monster";
	
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	// Default Constructor
	public Monster()
	{
		
	}
	
	// Overload Default Constructor 
	public Monster(int health)
	{
		this.health = health;
	}
	
	public Monster(int health, int attack)
	{
		this(health);
		this.attack = attack;
	}
	
	public Monster(int health, int attack, int movement)
	{
		this(health, attack);
		this.movement = movement;
	}
	
	public String name = "Big Monster";
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int decreaseHealth)
	{
		health = health - decreaseHealth;
		if(health < 0)
		{
			alive = false;
		}
	}
	
	public void setHealth(double decreaseHealth)
	{
		int intDecreaseHealth = (int)decreaseHealth;
		health = health - intDecreaseHealth;
		if(health < 0)
		{
			alive = false;
		}
	}
	
	public int getXPosition()
	{
		return xPosition;
	}
}
