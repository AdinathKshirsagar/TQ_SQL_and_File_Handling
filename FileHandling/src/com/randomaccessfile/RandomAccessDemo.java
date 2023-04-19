package com.randomaccessfile;

import java.io.RandomAccessFile;

public class RandomAccessDemo {

	public static void main(String[] args) {

    try
    {
    	RandomAccessFile raf= new RandomAccessFile("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\myfile.dat", "rw");
    	raf.writeChar('S');
    	raf.writeInt(12);
    	raf.writeFloat(69.5f);
    	
    	System.out.println("Student added.........");
    	
    	raf.seek(0);
    	
       System.out.println(raf.readChar());
       System.out.println(raf.readInt());
       System.out.println(raf.readFloat());
       
       raf.close();
    	
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    

	}

}
