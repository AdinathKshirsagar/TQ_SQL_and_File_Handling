package com.fileinputoutput;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {

	public static void main(String[] args) {
		String data = " I am learning Java at Think Quotient";
		try 
		{
			File f = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt");
			if(!f.exists())
			{
				f.createNewFile();
				FileOutputStream foutput = new FileOutputStream(f);
				
				byte []array = data.getBytes();
				foutput.write(array);
				foutput.close();
				System.out.println("Data added.....");
			}
			else
			{
				System.out.println("File is already exists....");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
