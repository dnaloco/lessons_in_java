package br.org.arthur.lessonSeventeen;

import java.util.*;
import java.text.DateFormat;

public class GetTime20 extends Thread 
{
	public void run()
	{
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		DateFormat dateFormatter;
		String timeOutput;
		String dateOutput;
		
		for(int i = 1; i <= 20; i++)
		{
			rightNow = new Date();
			currentLocale = new Locale("br");
			
			timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
			dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
			
			timeOutput = timeFormatter.format(rightNow);
			dateOutput = timeFormatter.format(rightNow);
			
			System.out.println(timeOutput);
			System.out.println(dateOutput);
			System.out.println();
			
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
