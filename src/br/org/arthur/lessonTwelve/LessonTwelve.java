package br.org.arthur.lessonTwelve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

public class LessonTwelve {
	public static void main(String[] args)
	{
		long tempoInicio = System.currentTimeMillis();  
		LinkedList linkedListOne = new LinkedList();
		
		LinkedList<String> names = new LinkedList<String>();
		
		names.add("Ahmed Bennani");
		names.add("Ali Syed");
		
		names.addLast("Nathan Martin");
		
		names.addFirst("Joshua Smith");
		
		names.add(0, "Noah Peeters");
		
		System.out.println("--------------------------------");
		
		for(String name : names)
		{
			System.out.println(name);
		}
		
		names.set(2, "Paul Newman");
		
		System.out.println("--------------------------------");
		for(String name : names)
		{
			System.out.println(name);
		}
		
		System.out.println("--------------------------------");
		names.remove(4);
		
		for(String name : names)
		{
			System.out.println(name);
		}
		System.out.println("--------------------------------");
		names.remove("Noah Peeters");
		
		for(String name : names)
		{
			System.out.println(name);
		}

		System.out.println("--------------------------------");
		
		LinkedList<String> namesCopy = new LinkedList<String>(names);
		System.out.println("\nFirs Index " + names.get(0));
		System.out.println("\nLast Index " + names.getLast());
		System.out.println("--------------------------------");
		
		for(String name : namesCopy)
		{
			System.out.println(name);
		}
		
		System.out.println("Index of Paul Newman is " + names.indexOf("Paul Newman"));
		System.out.println("\nList namesCopy is empty " + namesCopy.isEmpty());
		
		namesCopy.add("Arthur Santos Costa");
		
		if(namesCopy.size() != names.size())
		{
			System.out.println("The size of namesCopy  " + namesCopy.size() + " is diferent of the copied LinkedList names " + names.size());
		}
		// names.clear();
		System.out.println("Look with error " + names.get(0));
		System.out.println("\nLook Withou Error " + names.peek());
		
		System.out.println("\nRemove last element " + namesCopy.pollLast());
		
		if(namesCopy.size() != names.size())
		{
			System.out.println("The size of namesCopy  " + namesCopy.size() + " is diferent of the copied LinkedList names " + names.size());
		}
		else 
		{
			System.out.println("They each other have the same size.");
		}
		
		System.out.println("-------------------------------------------------------");
		if(names.containsAll(namesCopy))
		{
			System.out.println("They contain the same items");
		}
		
		//namesCopy.push("Ali Syed");
		//namesCopy.remove("Ali Syed");
		namesCopy.push("Daryl Crow");
		
		//namesCopy.pop();
		System.out.println("-------------------------------------------------------");
		Collections.sort(namesCopy);
		for(String name : namesCopy)
		{
			System.out.println(name);
		}
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));  
	}
}
