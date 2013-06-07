package br.org.arthur.lessonNineteen;

import java.util.regex.*;

public class LessonNineTeen
{
	public static void main(String[] args) {
		String longString = "Arthur Costa SP 12233 BR arthur_scosta@yahoo.asss.ass";
		String strangeString = "1z aaa *** **** {{{{ {{{ {";
		regexChecker("([A-Za-z0-9._%-]+@[A-Za-z0-9_-]+(\\.[A-Za-z]{2,4})+(\\.[A-Za-z)]{1,2})?)$", longString);
		regexReplace(longString);
		System.out.println(longString);
	}
	
	public static void regexChecker(String theRegex, String str2check)
	{
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2check);
		
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
			{
				System.out.println(regexMatcher.group().trim());
			}
			
			System.out.println("Start index: " + regexMatcher.start());
			System.out.println("End index: " + regexMatcher.end());
		}
		
	}
	
	public static void regexReplace(String str2Replace)
	{
		Pattern replace = Pattern.compile("\\s+");
		Matcher regexMatcher = replace.matcher(str2Replace.trim());
		System.out.println(regexMatcher.replaceAll(", "));
	}

}
