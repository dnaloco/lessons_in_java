package br.org.arthur;

import java.util.Locale;
import java.util.Scanner;

public class LessonFive
{
	static Scanner userInput = new Scanner(System.in);
	static int randomNumber;
		
	public static void main(String[] args)
	{		
		System.out.println(getRandomNum());
		
		int guessResult = 1;
		int randomGuess = 0;
		
		while(guessResult != -1)
		{
			System.out.println("Guess a number between 1 and 50");
			randomGuess = userInput.nextInt();
			guessResult = checkGuess(randomGuess);
		}
		
		System.out.println("Yes, you hit the right number that is " + randomNumber);
	}
	
	public static int getRandomNum()
	{
		randomNumber = (int) (Math.random() * 50 + 1);
		return randomNumber;
	}
	
	
	public static int checkGuess(int guess)
	{
		if(guess == randomNumber)
		{
			return -1;
		}
		else
		{
			return guess;
		}
		
	}

}
