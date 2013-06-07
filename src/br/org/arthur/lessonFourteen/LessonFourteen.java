package br.org.arthur.lessonFourteen;

public class LessonFourteen {
	public static void main(String[] args)
	{
		Animal genericAnimal = new Animal();
		
		System.out.println(genericAnimal.getName());
		System.out.println(genericAnimal.favFood);
		
		Cat morris = new Cat("Morris", "Tuna", "Rubber Mouse");
		
		System.out.println(morris.getName());
		System.out.println(morris.favFood);
		System.out.println(morris.favToy);
		
		Animal tabby = new Cat("Tabby", "Salmon", "Ball");
		
		acceptAnimal(tabby);
		
		
	}
	
	public static void acceptAnimal(Animal randAnimal)
	{
		System.out.println();
		System.out.println(randAnimal.getName());
		System.out.println(randAnimal.favFood);
		System.out.println();
		randAnimal.walkAround();		
		
		Cat tempCat = (Cat)randAnimal;
		System.out.println(tempCat.favToy);
		System.out.println(((Cat)randAnimal).favToy);
		
		if(randAnimal instanceof Cat)
		{
			System.out.println(randAnimal.getName() + " is a Cat");
		}
		
	}
}
