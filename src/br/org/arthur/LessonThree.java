package br.org.arthur;

public class LessonThree {
	public static void main(String[] args)
	{
		char theGrade = 'b';
		switch(theGrade)
		{
		case 'A':
			System.out.println("Great job");
			break;
		case 'b':
		case 'B':
			System.out.println("Good job");
			break;
		case 'C':
			System.out.println("OK");
			break;
		case 'D':
			System.out.println("Bad");
			break;
		default:
			System.out.println("You failed");
			break;
		}
	}
}
