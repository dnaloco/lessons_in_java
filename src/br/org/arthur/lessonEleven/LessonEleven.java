package br.org.arthur.lessonEleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class LessonEleven {
	public static void main(String[] args)
	{
		ArrayList arrayListOne;
		arrayListOne = new ArrayList();
		
		ArrayList arrayListTwo = new ArrayList();
		
		ArrayList<String> names= new ArrayList<String>();
		
		names.add("Arthur Santos");
		names.add("Dalila Santos");
		names.add("Terezinha Santos");
		
		names.add(2, "Jack Ryan");
		names.set(3, "Bruna Santos");
		names.remove(1);
		names.add(1,"Carl Smith");
		
		
		for(int i = 0; i < names.size(); i++)
		{
			System.out.println(names.get(i));
		}
		
		System.out.println(names);
		
		for(String name : names) 
		{
			System.out.println(name);
		}
		
		Iterator indivItems = names.iterator();
		System.out.println("-----------------------------");
		while(indivItems.hasNext())
		{
			System.out.println(indivItems.next());
	
		}
		System.out.println("-----------------------------");
		
		ArrayList nameCopy = new ArrayList();
		ArrayList nameBackup = new ArrayList();
		
		nameCopy.addAll(names);
		
		String paulYoung = "Paul Young";
		String jeffBriggs = "Jeff Briggs";
		nameCopy.add(jeffBriggs);
		
		names.add(paulYoung);
		
		if(names.contains(paulYoung))
		{
			System.out.println("Paul is here");
		}
		
		if(names.containsAll(nameCopy))
		{
			System.out.println("Everything is there");
		}
		
		nameBackup.addAll(names);
		names.clear();
		
		if(names.isEmpty())
		{
			System.out.println("Array list is empty");
		}
		
		Object[] moreNames = new Object[4];
		
		moreNames = nameCopy.toArray();
		System.out.println(Arrays.toString(moreNames));
	}
}
