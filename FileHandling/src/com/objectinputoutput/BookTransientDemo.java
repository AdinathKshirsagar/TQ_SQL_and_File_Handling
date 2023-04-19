package com.objectinputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BookTransientDemo {
	
	public static void readBook(File f1)
	{
	
		try		
		{
			if(f1.exists())
			{
			FileInputStream finput= new FileInputStream(f1);	
			ObjectInputStream oinput= new ObjectInputStream(finput);
			
			Book2 b1= (Book2)oinput.readObject();
			System.out.println(b1);

             oinput.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	public static void addBook(File f1)
	{
		Book2 b = new Book2(102,"Secret",900f);
		try
		
		{
			//if(!f1.exists())
			//{
		     //f1.createNewFile();
			FileOutputStream foutput= new FileOutputStream(f1);
			ObjectOutputStream ooutput= new ObjectOutputStream(foutput);
			
			ooutput.writeObject(b);
			ooutput.close();
			System.out.println("Book added");
			//}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	

	public static void main(String[] args) throws IOException {

		File f= new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\BookTransientData.txt");
				
		addBook(f);
		readBook(f);

	}

}
