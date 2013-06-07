package br.org.arthur.lessonThirtyOne;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.*;

public class Lesson31 extends JFrame
{
	static String filePath, parentDirectory;
	static File randomDir, randomFile, randomFile2; 
	
	public static void main(String[] args)
	{		
		randomDir = new File("C:\\Users\\arthur\\java_workspace\\br.org.arthur.lessonsPartOne\\docs");
		
		if(!randomDir.exists())
			randomDir.mkdir();
		
		randomFile = new File("random.txt");
		randomFile2 = new File(randomDir, "random2.txt");
		
		try
		{
			randomFile.createNewFile();
			randomFile2.createNewFile();
			filePath = randomFile2.getCanonicalPath();
			System.out.println("random2.txt " + filePath);
			filePath = randomFile.getCanonicalPath();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		if(randomFile.exists()){
			System.out.println("File Exists!");
			System.out.println("File Readable: " + randomFile.canRead());
			System.out.println("File Writable: " + randomFile.canWrite());
			System.out.println("File Location: " + filePath);
			System.out.println("File Name: " + randomFile.getName());
			parentDirectory = randomFile.getParent();
			System.out.println("File Parent: " + parentDirectory);
			parentDirectory = randomFile2.getParent();
			System.out.println("File 2 Parent: " + parentDirectory);
			
			System.out.println("Is a dir: " + randomDir.isDirectory());
			
			String[] filesInDir = randomDir.list();
			System.out.println("Files in Directory\n");
			
			for(String fileName : filesInDir)
			{
				System.out.println(fileName + "\n");
			}
			
			System.out.println("Is a File: " + randomFile.isFile());
			System.out.println("Is Hidden: " + randomFile.isHidden());
			System.out.println("Last Modified: " + randomFile.lastModified());
			System.out.println("File Size: " + randomFile.length());
			
			randomFile2.renameTo(new File(randomDir,"random3.txt"));
			
		}

		if(randomFile.delete())
		{
			System.out.println("File randomFile was Deleted");
		}
		File[] filesInDir = randomDir.listFiles();
		
		for(File fileName : filesInDir)
		{
			System.out.println("The file " + fileName + " was deleted.");
			fileName.delete();
		}
	} // END OF main METHOD
	
	public Lesson31()
	{
		JFileChooser fileChooser = new JFileChooser(randomDir);
		fileChooser.showOpenDialog(this);
	}

} // END OF Lesson31 CLASS
