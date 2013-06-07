package br.org.arthur;

import java.util.Scanner;

public class LessonTwo 
{
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.print("Input a number ");
		
		if(userInput.hasNextInt()) 
		{
			int numberEntered = userInput.nextInt();
			System.out.println("You entered " + numberEntered);
			numberEntered--;
			System.out.println(numberEntered);
			
			int numberABS = Math.abs(numberEntered);
			System.out.println("ABS " + numberABS);
			int whichIsBigger = Math.max(5, 7);
			int whichIsSmaller = Math.min(4, 1);
			System.out.println("Maior " + whichIsBigger);
			System.out.println("Menor " + whichIsSmaller);
			
			int numCeiling = (int) Math.ceil(5.23);
			int numFloor = (int) Math.floor(4.86);
			int numRound = (int) Math.round(8.49);
			int numRound2 = (int) Math.round(8.245);
			int randomNumber = (int)(Math.random() * 11);
			
			System.out.println("numCeiling " + numCeiling);
			System.out.println("numFloor " + numFloor);
			System.out.println("numRound " + numRound);
			System.out.println("numRound2 " + numRound2);
			System.out.println("randomNumber " + randomNumber);
			
		} else {
			System.out.println("It's not an integer number! Enter an integer next time");
		}
	}
}
