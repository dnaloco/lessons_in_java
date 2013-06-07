package br.org.arthur.lessonEight;

import java.util.Arrays;

public class MonsterTwo {
	
	static char[][] battleBoard = new char[10][10];
	
	
	
	public final String TOMBSTOME = "Here lies a dead monster";
	
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 1;
	private int yPosition = 1;
	private boolean alive = true;
	
	private String monsterName = "Monster";
	private char nameCharMonster;
	public static int numOfMonsters = 0;	
	
	// Default Constructor
	public MonsterTwo()
	{
		numOfMonsters++;
	}


	public void setMonsterOnBoard() {
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length -1;
		
		int randNumX, randNumY;
		
		do {
			randNumX = (int)(Math.random() * maxXBoardSpace);
			randNumY = (int)(Math.random() * maxYBoardSpace);
		}while(battleBoard[randNumX][randNumY] != '*');
		
		this.xPosition = randNumX;
		this.yPosition = randNumY;
		
		this.nameCharMonster = this.monsterName.charAt(0);
		
		battleBoard[this.yPosition][this.xPosition] = this.nameCharMonster;
	}
	
	
	public MonsterTwo(String monsterName)
	{
		this();
		this.monsterName = monsterName;
	}
	
	// Overload Default Constructor 
	public MonsterTwo(int health)
	{
		this();
		this.health = health;
	}
	
	public MonsterTwo(int health, int attack)
	{
		this(health);
		this.attack = attack;
	}
	
	public MonsterTwo(int health, int attack, int movement)
	{
		this(health, attack);
		this.movement = movement;
	}
	
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

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
	
	public boolean getAlive()
	{
		return alive;
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
	
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public static void buildBattleBoard()
	{
		for(char[] row : battleBoard)
		{
			Arrays.fill(row, '*');
		}
	}
	
	public static void redrawBoard()
	{
		int k = 1;
		while(k <= 30)
		{
			System.out.print('-');
			k++;
		}
		System.out.println();
		
		for(int i = 0; i < battleBoard.length; i++)
		{
			for(int j = 0; j < battleBoard[i].length; j++)
			{
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			System.out.println();
		}
		k = 1;
		while(k <= 30)
		{
			System.out.print('-');
			k++;
		}
	}
}
