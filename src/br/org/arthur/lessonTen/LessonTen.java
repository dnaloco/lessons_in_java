package br.org.arthur.lessonTen;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Scanner;

public class LessonTen {
	static Scanner inputMonsterName = new Scanner(System.in);
	
	public static void main(String[] args) {
		Monster.buildBattleBoard();
		Monster[] Monsters = new Monster[4];
		
		int k = 0;
		// int health, int attack, int movement, String monsterName
		for(Monster monster : Monsters)
		{
			int randHealt = (int)(Math.random() * 900 + 100);
			int randAttack = (int)(Math.random() * 100 + 20);
			int randMovement = (int)(Math.random() * 4 + 1);
			
			String naneOfMonster;
			
			System.out.print("What is the name of the monster: ");
			naneOfMonster = inputMonsterName.nextLine();
			
			if(naneOfMonster.length() > 0)
			{
				naneOfMonster = Character.toUpperCase(naneOfMonster.charAt(0)) + naneOfMonster.substring(1);
			}
			else 
			{
				naneOfMonster = "Monster";
			}
			
			Monsters[k] = new Monster(randHealt, randAttack, randMovement, naneOfMonster);
			Monsters[k].setMonsterOnBoard();
			k++;			
		}
		Monster.redrawBoard();
		System.out.println();
		int b = 0;
		while(b < 100){
			for(Monster m : Monsters)
			{
				if(m.getAlive())
				{				
					int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
					m.moveMonster(Monsters, arrayItemIndex);
				}
			}
			Monster.redrawBoard();
			b++;
		}
		
	}
	
	
}
