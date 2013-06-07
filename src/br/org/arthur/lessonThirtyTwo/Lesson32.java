package br.org.arthur.lessonThirtyTwo;

import java.io.*;

public class Lesson32 {
	public static void main(String[] args)
	{
		Customer[] customers = getCustomers();
		
		PrintWriter custOutput = createFile("C:\\Users\\arthur\\java_workspace\\br.org.arthur.lessonsPartOne\\docs\\customers.txt");
		
		for(Customer person : customers)
		{
			createCustomers(person, custOutput);
		}
		
		custOutput.close();
		getFileInfo();
	}
	
	private static class Customer
	{
		public String firstName, lastName; 
		public int custAge;
		
		public Customer(String firstName, String lastName, int custAge)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.custAge = custAge;
		}
	}
	
	private static Customer[] getCustomers()
	{
		Customer[] customers = new Customer[5];
		
		customers[0] = new Customer("John", "Smith", 21);
		customers[1] = new Customer("Sally", "Smith", 27);
		customers[2] = new Customer("Paul", "Smith", 22);
		customers[3] = new Customer("Tom", "Smith", 24);
		customers[4] = new Customer("Mark", "Smith", 1);
		
		return customers;
	}
	
	private static PrintWriter createFile(String fileName)
	{
		try
		{
			File listOfNames = new File(fileName);
			
			PrintWriter infoToWrite = new PrintWriter(
					new BufferedWriter(
							new FileWriter(listOfNames)));
			
			return infoToWrite;			
		}
		catch(IOException e)
		{
			System.out.println("An I/O Error Occurred on method PrintWriter");
			System.out.println("STACK TRACE:");
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	private static void createCustomers(Customer customer, PrintWriter custOutput)
	{
		String custInfo = customer.firstName + " " + customer.lastName + " ";
		custInfo += Integer.toString(customer.custAge);
		try
		{
			custOutput.println(custInfo);
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void getFileInfo()
	{
		System.out.println("Info Written to File\n");
		
		File listOfNames = new File("C:\\Users\\arthur\\java_workspace\\br.org.arthur.lessonsPartOne\\docs\\customers.txt");
		
		try
		{
			BufferedReader getInfo = new BufferedReader(
					new FileReader(listOfNames));
			String custInfo = getInfo.readLine();
			
			while(custInfo != null)
			{
				String[] indivCustData = custInfo.split(" ");

				int custAge = Integer.parseInt(indivCustData[2]);
				String yearsOld = (custAge > 1) ? "  years old." : "  year old.";
				System.out.println("The customer name is " + indivCustData[0] + " " + indivCustData[1] + " which has " + custAge + yearsOld);
				
						
				//System.out.println(custInfo);
				custInfo = getInfo.readLine();
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Couldn't Find the File");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("An I/O Error Occurred on method getFileInfo");
			System.out.println("STACK TRACE:\n");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
