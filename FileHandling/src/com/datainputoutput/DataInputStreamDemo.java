package com.datainputoutput;

import java.io.DataInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputStreamDemo {

	public static void main(String[] args) {

		try
		{
		File f= new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\MyData.txt");
		
		if(f.exists())
		{
			f.createNewFile();
	        DataInputStream din= new DataInputStream(new FileInputStream(f)) ;
	        
	        int count = din.available();
	        byte arr[] = new byte[count];
	        
	        din.read(arr);
	        for(byte b: arr)
	        {
	        	char ch= (char) (b);
	        	System.out.print(ch);
	        }
	         System.out.println();
			System.out.println("Data added........");
			
		}
		else
		{
			System.out.println("File already exists.............");
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

	}

