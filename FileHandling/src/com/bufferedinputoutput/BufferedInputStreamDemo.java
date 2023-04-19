package com.bufferedinputoutput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


public class BufferedInputStreamDemo {

	public static void main(String[] args) {
    
	try
		{
		File f= new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt");
		
		if(f.exists())
		{
			FileInputStream fin= new FileInputStream(f);
			BufferedInputStream bin= new BufferedInputStream(fin);
			
			int i=0;
			
			while((i=bin.read())!=-1)
			{
				System.out.print((char)i);
				
			}
			bin.close();
			System.out.println();
			
			System.out.println("File compelete........");
				
		}
		else
		{
			System.out.println("File dosenot exists.............");
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
