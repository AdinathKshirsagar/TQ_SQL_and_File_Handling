package com.fileinputoutput;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		try 
		{
			File f = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt");
			if(f.exists())
			{
				FileInputStream finput = new FileInputStream(f);
				
				int i=0;
				while((i=finput.read())!=-1)
				{
					System.out.print((char)i);
				}
				finput.close();
				System.out.println();
				System.out.println("File Complete....");
				
			}
			else
			{
				System.out.println("Data is already exists....");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
