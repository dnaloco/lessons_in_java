package br.org.arthur.lessonTen;

import java.util.Arrays;

public class Monster {
	
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
	private static int numOfMonsters = 0;	
	
	// Default Constructor
	public Monster()
	{
		numOfMonsters++;
	}


	public void setMonsterOnBoard() {
		
		System.out.println("SET MONSTER OM TABLE: ");
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
	
	
	public Monster(String monsterName)
	{
		this();
		this.monsterName = monsterName;
	}
	
	// Overload Default Constructor 
	public Monster(int health)
	{
		this();
		this.health = health;
	}
	
	public Monster(int health, int attack)
	{
		this(health);
		this.attack = attack;
	}
	
	public Monster(int health, int attack, int movement, String monsterName)
	{
		this(health, attack);
		this.monsterName = monsterName;
		this.movement = movement;
	}
	
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	public static int getNumOfMonsters()
	{
		return numOfMonsters;
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
		System.out.println();
	}
	
	public void moveMonster(Monster[] monster, int arrayItemIndex)
	{
		
		boolean isSpaceOpen = true;
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		int randMoveDirection = 0;
		int randMoveDistance = 0;
		
		while(isSpaceOpen)
		{
			randMoveDirection = (int)(Math.random() * 4);
			randMoveDistance = (int)(Math.random() * (this.getMovement() + 1));

			battleBoard[this.yPosition][this.xPosition] = '*';
			
			if(randMoveDirection == 0)
			{
				if((this.yPosition - randMoveDistance) < 0)
				{
					this.yPosition = 0;
				} else {
					this.yPosition = this.yPosition - randMoveDistance;
				}
			}
			else if(randMoveDirection == 1) 
			{
				if((this.xPosition + randMoveDistance) > maxXBoardSpace)
				{
					this.xPosition = maxXBoardSpace;
				} else {
					this.xPosition = this.xPosition + randMoveDistance;
				}
			}
			else if(randMoveDirection == 2) 
			{
				if((this.yPosition + randMoveDistance) > maxYBoardSpace)
				{
					this.yPosition = maxYBoardSpace;
				} else {
					this.yPosition = this.yPosition + randMoveDistance;
				}
			} 
			else
			{
				if((this.xPosition - randMoveDistance) < 0)
				{
					this.xPosition = 0;
				} else {
					this.xPosition = this.xPosition - randMoveDistance;
				}
			}
			
			for(int i = 0; i < monster.length; i++)
			{
				if(i == arrayItemIndex)
				{
					continue;
				}
				
				isSpaceOpen = onMySpace(monster, i);
				if(isSpaceOpen)
				{
					System.out.println("They must change their position");
				}
				else
				{
					System.out.println("Return positions");
				}
			}
			
		}// END OF WHILE LOOP
		
		System.out.println("[Monster: " + this.nameCharMonster + " D: " + randMoveDirection + " M: " + randMoveDistance + "]");
		battleBoard[this.yPosition][this.xPosition] = this.nameCharMonster;
	}//END OF moveMonster
	
	public boolean onMySpace(Monster[] monster, int indexOfOtherMonster)
	{
		if(this.xPosition == monster[indexOfOtherMonster].xPosition && this.yPosition == monster[indexOfOtherMonster].yPosition)
		{
			System.out.println("They Have te same position " + this.getMonsterName() + " and  " + monster[indexOfOtherMonster].getMonsterName());
			return true;
		}

		return false;
			
	} 
}
