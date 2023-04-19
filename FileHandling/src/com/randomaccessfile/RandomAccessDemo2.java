package com.randomaccessfile;

import java.io.RandomAccessFile;

public class RandomAccessDemo2 {

	public static void main(String[] args) {

    try
    {
    	RandomAccessFile raf= new RandomAccessFile("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Mycities.txt", "rw");
       raf.writeUTF("Delhi");
       raf.writeUTF("Pune");
       raf.writeUTF("Mumbai");  
       raf.writeInt(90);
                   
       raf.seek(0);
       // to reach beginning of file
       System.out.println(raf.readUTF());
       System.out.println(raf.readUTF());
       System.out.println(raf.readUTF());
       System.out.println(raf.readInt());
       
       
       raf.close();
       
    	
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    

	}

}
