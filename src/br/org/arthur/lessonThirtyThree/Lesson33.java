package br.org.arthur.lessonThirtyThree;

import java.io.*;

public class Lesson33 {

	public static void main(String[] args)
	{
		String fileName = "indebtedCustomers.txt";
		Customer[] customers = getCustomers();
		DataOutputStream custOutput = createFile(fileName);
		
		for(Customer person : customers)
		{
			createCustumers(person, custOutput);
		}
		
		try
		{
			custOutput.close();
		}
		catch(IOException e)
		{
			System.out.println("I/O Error occurred");
			System.exit(0);
		}
		
		getFileInfo(fileName);
	} // END OF main
	
	private static class Customer
	{
		public String custName;
		public int custAge;
		public double custDebt;
		public boolean oweMoney;
		public char custSex;
		
		public Customer(String custName, int custAge, double custDebt, boolean oweMoney, char custSex)
		{
			this.custName = custName;
			this.custAge = custAge;
			this.custDebt = custDebt;
			this.oweMoney = oweMoney;
			this.custSex = custSex;
		} //END OF constructor to CUSTOMER
		
	} // END OF PRIVATE CLASS CUSTOMER
	
	private static Customer[] getCustomers()
	{
		Customer[] customers = new Customer[5];
		
		customers[0] = new Customer("Maria", 25, 534.21, true, 'F');
		customers[1] = new Customer("Alessandra", 12, 5.99, false, 'F');
		customers[2] = new Customer("João", 35, 14.50, true, 'M');
		customers[3] = new Customer("Fernanda", 15, 120.23, true, 'F');
		customers[4] = new Customer("Pedro", 29, 29, true, 'M');
		
		return customers;
		
	} // END OF getCustomers
	
	private static DataOutputStream createFile(String fileName)
	{
		try
		{
			File listOfNames = new File(fileName);
			
			DataOutputStream infoToWrite = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(listOfNames)));
			return infoToWrite;
		}
		catch(IOException e)
		{
			System.out.println("I/O Error occurred");
			System.exit(0);
		}
		return null;
	} // END OF createFile
	
	private static void createCustumers(Customer customer, DataOutputStream custOutput)
	{
		try
		{
			custOutput.writeUTF(customer.custName);
			custOutput.writeInt(customer.custAge);
			custOutput.writeDouble(customer.custDebt);
			custOutput.writeBoolean(customer.oweMoney);
			custOutput.writeChar(customer.custSex);
			
			/*
			 * UTF to String...
			 * writeByte, writeFloat, writeLong
			 */
		}
		catch(IOException e)
		{
			System.out.println("I/O Error occurred");
			System.exit(0);
		}
	} // END OF createCustomers
	
	private static void getFileInfo(String fileName)
	{
		System.out.println("Info Written fo File\n");
		
		File listOfNames = new File(fileName);
		
		boolean eof = false;
		
		try
		{
			DataInputStream getInfo = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(listOfNames)));
			while(!eof)
			{
				System.out.println("\nDebtor Customer Data:");
				
				String custName = getInfo.readUTF();
				int custAge = getInfo.readInt();
				double custDebt = getInfo.readDouble();
				boolean oweMoney = getInfo.readBoolean();
				char custSex = getInfo.readChar();
				
				String personPronoum 		= (custSex == 'M') ? "He" : "She";
				String gender	= (custSex == 'M') ? "Male" : "Female";
				
				System.out.println("Name: " + custName);
				System.out.println("Age: " + custAge);
				System.out.println("Debt: " + custDebt);
				System.out.println(personPronoum + " owes me money? " + oweMoney);
				System.out.println("Sex: " + gender);
			}

		} // END OF TRY
		catch(EOFException e)
		{
			eof = true;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No File");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("I/O Error occurred");
			System.exit(0);;
		}
	}
	
} // END OF CLASS LESSON33
