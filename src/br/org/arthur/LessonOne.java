package br.org.arthur;

public class LessonOne {
	
	static String randomString = "String to print";
	static final double PINUM =  3.141529;
	static byte bigByte = 127;
	static short bigShort = 32767;
	static int bigInt = 2000000;
	static long bigLong = 92233720;
	static float bigFloat = 3013.30F;
	static double bigDouble = 1.1221233123132312;
		
	public static void main(String[] args) {
		System.out.println(PINUM);
		
		int integerOne = 22;
		int integerTwo = integerOne + 1;
		float floatNumber = 1223;
		long longNumber = 99999999;
		
		System.out.println(integerTwo);
		System.out.println("Byte max value = " + Byte.MAX_VALUE);
		System.out.println("Short max value = " + Short.MAX_VALUE);
		System.out.println("Integer max value = " + Integer.MAX_VALUE);
		System.out.println("Long max value = " + Long.MAX_VALUE);
		System.out.println("Float max value = " + Float.MAX_VALUE);
		System.out.println("Double max value = " + Double.MAX_VALUE);
		
		boolean trueOrFalse = true;
		
		char randomChar = 68;
		char anotherChar = 'A';
		
		char escapedChars1 = '\b';
		char escapedChars2 = '\f';
		char escapedChars3 = '\t';
		
		String randomString = "I'm a random string";
		String anotherString = "Stuff";
		
		String andAnotherString = randomString + ' ' + anotherChar ;
		
		System.out.println(randomChar);
		System.out.println(anotherChar);
		
		String byteString = Byte.toString(bigByte);
		String shortString = Short.toString(bigShort);
		String intString = Integer.toString(bigInt);
		String longString = Long.toString(bigLong);
		String floatString = Float.toString(bigFloat);
		String doubleString = Double.toString(bigDouble);
		String booleanString = Boolean.toString(trueOrFalse);
		
		System.out.println("============================");
		
		System.out.println("byteString = " + byteString);
		System.out.println("shortString = " + shortString);
		System.out.println("intString = " + intString);
		System.out.println("longString = " + longString);
		System.out.println("floatString = " + floatString);
		System.out.println("doubleString = " + doubleString);
		System.out.println("booleanString = " + booleanString);
		double aDoubleValue = 3100000000000000000.14546466464;
		int doubleToInt = (int)aDoubleValue;
		
		System.out.println(Integer.toString(doubleToInt));
		
		System.out.println("============================");
		
		int stringToInt = Integer.parseInt(intString);
		System.out.println(stringToInt);
	}
}
