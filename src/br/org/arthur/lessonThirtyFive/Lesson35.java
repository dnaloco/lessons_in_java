package br.org.arthur.lessonThirtyFive;

import br.org.arthur.LessonFive;

public class Lesson35 
{
	public static void main(String[] args)
	{
		
		// length to array | length() to primitive ...
		int fat = 0;
		fat = Math.abs(fat);
		System.out.println("Fatorial de " + fat + " = " + fatorial((fat)));
		
	}
	
	public static int fatorial(int n)
	{
		if(n == 0) 
				return 1;
		return n * fatorial(n-1);
	}
}
