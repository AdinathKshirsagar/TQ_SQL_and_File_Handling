package com.objectinputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputDemo {
	
	public static void adddata()
	{
		int roll=12;
		String name="Pritish";
		
		try
		{
			
			File f= new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\StudentData.txt");
			
			if(!f.exists())
			{
				f.createNewFile();
			     
				ObjectOutputStream oout= new ObjectOutputStream(new FileOutputStream(f));
				oout.writeInt(roll);
			    oout.writeObject(name);
			    				
				System.out.println("Data added........");
				oout.close();
					
			}
			else
			{
				System.out.println("File already exists.............");
			}
				
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void readData()
	{
				
		try
		{
			
			File f= new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\StudentData.txt");
			
			if(f.exists())
			{
							     
				ObjectInputStream oin= new ObjectInputStream(new FileInputStream(f));
				System.out.println(oin.readInt());
				System.out.println(oin.readObject());
			    				
				//System.out.println("Data added........");
				oin.close();
					
			}
			else
			{
				System.out.println("File doesnot exists.............");
			}
				
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		//adddata();
		readData();

   }
}
