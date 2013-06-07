package br.org.arthur.lessonThirteen;

import java.util.Arrays;

public class LessonThirteen {
	public static void main(String[] args)
	{
		String randomString = "I'm just a random String";
		
		String goToQuote = "He said, \"I'm here\"";
		
		int numTwo = 2;
		
		System.out.println(randomString + " " + goToQuote + " " + numTwo);
		
		String uppercaseStr = "BIG";
		String lowercaseStr = "big";
		
		if(uppercaseStr.equalsIgnoreCase(lowercaseStr))
		{
			System.out.println("They're equal");
		}
		
		String letters = "abcde";
		String moreLetters  = "fghijk";
		String moreLetters2 = "lmnrs";
		
		System.out.println("2nd char: " + letters.charAt(1));
		
		System.out.println(letters.compareTo(moreLetters));
		
		System.out.println(letters.contains("abc"));
		System.out.println(letters.endsWith("de"));
		System.out.println(letters.startsWith("ab"));
		System.out.println(letters.indexOf("e",3));
		System.out.println("Numbers of characters in a String " + letters.length());
		System.out.println(moreLetters2.replace("rs", "opq"));
		
		System.out.println();
		
		String[] lettersArray = letters.split("");
		
		System.out.println(Arrays.toString(lettersArray));
		
		System.out.println(letters.substring(1,5));
		System.out.println(letters.toUpperCase());
		String randString ="                 aasdfdfass                ";
		System.out.println(randString.trim());
		
		// String multable ... create a new location ...over and over ...and over again..
		// Use stringBuilder
		
		StringBuilder randSB = new StringBuilder("A random value");
		
		System.out.println(randSB.append(" again "));
		System.out.println(randSB.capacity());
		System.out.println(randSB);
		System.out.println((randSB.delete(15, 21)));
		randSB.ensureCapacity(58);
		System.out.println(randSB.capacity());
		randSB.trimToSize();
		System.out.println(randSB.capacity());
		System.out.println(randSB.insert(1, " just another"));
		randSB.trimToSize();
		System.out.println(randSB.capacity());
		
		// Old String
		/*
		 * charAt()
		 * indexOf()
		 * lastIndexOf()
		 * substring
		 */
		
	}
}
