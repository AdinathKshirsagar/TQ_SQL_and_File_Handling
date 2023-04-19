package com.FileHandlingAssignment;

import java.io.*;
//  Merged data of two file into another(SequenceStream)
public class MergeDataOfTwoFileInAnother {
    public static void main(String[] args) {
        File file1 = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Output.txt"); 
        File file2 = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\Reader.txt"); 
        File mergedFile = new File("D:\\ADINATH\\ThinkQuotient_Institute\\FileHandling\\OutputReader.txt"); 

        try 
        (
        	InputStream inputStream1 = new FileInputStream(file1);
            InputStream inputStream2 = new FileInputStream(file2);
            OutputStream outputStream = new FileOutputStream(mergedFile);
        		
             SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2)) {

            int data;
            while ((data = sequenceInputStream.read()) != -1) {
                outputStream.write(data);
            }
            System.out.println("Files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
