package com.readerWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferReaderDemo {
	public static void main(String[] args) {
		
		try {
		BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the data [ enter Stop ] if you want to finish");
		
		String data="";
		String output="";
		while(!data.equalsIgnoreCase("Stop"))
		{
			data = breader.readLine();
			output = output.concat(data);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
