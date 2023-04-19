package com.readerwriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) {

     try {
    	 
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 System.out.println("Enter a name:");
    	 String name = br.readLine();
    	 
    	 System.out.println("Welcome "+name);
    	 
    	 
    	 
     }
     catch(Exception e)
     {
    	 System.out.println(e);
     }
     
     

	}

}
