package com.readerwriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterDemo {
	
	public static void readFile(File file)
	{
		try
		{
			FileReader fr = new FileReader(file);
			int i;
			while((i=fr.read())!=-1)
			{
				System.out.print((char)i);
			}
			fr.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void writeFile(File file)
	{
		try
		{
			FileWriter fw= new FileWriter(file);
			fw.write("I love Java programming.");
			fw.close();
			System.out.println("Data added.............");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		
		File f = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Reader.txt");
		
		writeFile(f);
		readFile(f);


	}

}
