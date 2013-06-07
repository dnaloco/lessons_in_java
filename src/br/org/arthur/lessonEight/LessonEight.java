package br.org.arthur.lessonEight;

import br.org.arthur.lessonEight.MonsterTwo;

public class LessonEight {
	public static void main(String[] args) {
		MonsterTwo.buildBattleBoard();
		
		char[][] tempBattleBoard = new char[10][10];
		
		MonsterTwo[] Monsters = new MonsterTwo[4];
		
		Monsters[0] = new MonsterTwo("Bob");
		Monsters[1] = new MonsterTwo("Frank");
		Monsters[2] = new MonsterTwo();
		Monsters[3] = new MonsterTwo();
		
		for(MonsterTwo monster : Monsters)
		{
			monster.setMonsterOnBoard();
		}
		
		MonsterTwo.redrawBoard();
		
	}
}
