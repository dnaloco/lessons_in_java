package br.org.arthur.lessonSixteen;

import br.org.arthur.lessonFifteen.Vehicle;

public class LessonSixteen 
{
	public static void main(String[] args)
	{
		Object superCar = new Vehicle();
		System.out.println(((Vehicle)superCar).getSpeed());
		Vehicle superTruck = new Vehicle();
		String firstString = "Arthur";
		String secondString = "Arthur";
		
		System.out.println(firstString.equals(secondString));
		
		System.out.println(superCar.equals(superTruck));
		System.out.println(superCar.hashCode());
		System.out.println(superTruck.hashCode());
		
		System.out.println("----");
		System.out.println(firstString.hashCode());
		System.out.println(secondString.hashCode());
		
		System.out.println("----");
		System.out.println(superCar.getClass().getName());
		System.out.println(superTruck.getClass().getName());
		
		System.out.println("----");
		if(superCar.getClass() == superTruck.getClass())
		{
			System.out.println("The same class");
		}
		
		System.out.println("----");
		System.out.println(superTruck.getClass().getSuperclass());
		
		System.out.println(superCar.toString());
		int randNum = 100;
		System.out.println(Integer.toString(randNum));
		
		// parse is used to transform a string in a numeric type...
		// NumericType.toString is the inverse method.
		
		superTruck.setWheels(6);
		
		Vehicle superTruck2 = (Vehicle)superTruck.clone();
		
		System.out.println(superTruck.getWheels());
		System.out.println(superTruck2.getWheels());
		
		System.out.println(superTruck.hashCode());
		System.out.println(superTruck2.hashCode());
	}
}
