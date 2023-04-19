package com.FileHandlingAssignment;

import java.io.*;
// Find the lines, words and characters in a file
public class CountLineWordsCharacter {
    public static void main(String[] args) {
    	
    	try
    	{
    		
        File file = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt"); 
        int lineCount = 0;
        int wordCount = 0;
        int characterCount = 0;

        	BufferedReader buffReader = new BufferedReader(new FileReader(file)); 
            String line;
            while ((line = buffReader.readLine()) != null) {
                lineCount++;
                characterCount += line.length();
                String[] words = line.split("\\s");
                wordCount += words.length;
            }
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + characterCount);
            
            buffReader.close();
            
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
