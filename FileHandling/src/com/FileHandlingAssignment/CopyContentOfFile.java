package com.FileHandlingAssignment;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

// // Copy the content of one file to another
public class CopyContentOfFile{
	public static void main(String[] args) {
		
		try
		{
		File OriginalFile = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt");
		File copyFile = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\OutputCopy.txt");
		
			FileReader fileReader = new FileReader(OriginalFile);
			FileWriter fileWriter = new FileWriter(copyFile);
		int character;
        while ((character = fileReader.read()) != -1) {
            fileWriter.write(character);
        }
        System.out.println("File copied successfully!");
        fileReader.close();
        fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
