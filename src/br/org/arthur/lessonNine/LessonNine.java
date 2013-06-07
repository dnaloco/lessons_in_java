package br.org.arthur.lessonNine;

import java.util.Arrays;

public class LessonNine {
	public static void main(String[] args) {
		int[] numberArray = new int[100];
		
		for(int i = 0; i < numberArray.length; i++)
		{
			numberArray[i] = (int)(Math.random() * 100 + 1);
		}
		
		Arrays.sort(numberArray);

		for(int num : numberArray)
		{
			System.out.println(num);
		}
	}
}
