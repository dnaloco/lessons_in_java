package br.org.arthur;

import java.io.*;

// java.lang.RunTimeException
// java.lang.Exception
/*
 * ArithmeticException
 * ClassNotFoundException
 * IllegalArgumentException
 * IndexOutOfBoundsExceptions ... arrays...
 * InputMismatchExcpection ... wrong data type input
 * IOException ... any exception io...
 */

public class LessonSix {
	
	public static void main(String[] args)
	{
		try
		{
			getAFile("./somestuff.txt");
		}
		catch(IOException e)
		{
			System.out.println("An IO Error Occurred");
		}
		
	}
	
	public static void getAFile(String fileName) throws IOException, FileNotFoundException
	{
		FileInputStream file = new FileInputStream(fileName);
	}
}


