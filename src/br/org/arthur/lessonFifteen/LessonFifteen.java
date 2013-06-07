package br.org.arthur.lessonFifteen;

public class LessonFifteen {
	public static void main(String[] args)
	{
		Vehicle car = new Vehicle(4, 100.00);
		
		System.out.println(car.getWheels());
		System.out.println(car.getSpeed());
		
		car.setCarStrength(10);
		System.out.println("Strength " + car.getCarStrength());
	}
}
