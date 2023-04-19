package com.fileProperties;

import java.io.File;

public class FileProperties {

	public static void main(String[] args) {

      File f = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\JavaNotes.txt");
     // File f = new File("D:\\Java10Jan\\MyFiles"); // It is a directory
      
      if(f.exists())
      {
    	  if(f.isFile())
    	  {
    		  System.out.println("File Name:"+f.getName());
    		  System.out.println("File Length:"+f.length());
    		  System.out.println("Path:"+f.getPath());
    		  System.out.println("AbsolutePath:"+f.getAbsolutePath());
    		  System.out.println("Write:"+f.canWrite());
    	  }
    	  else
    	  {
    		  System.out.println("Directory");
    	  }
    	  
    	  
      }
      else
      {
    	  System.out.println("File doesnot exists");
      }
      

	}

}
