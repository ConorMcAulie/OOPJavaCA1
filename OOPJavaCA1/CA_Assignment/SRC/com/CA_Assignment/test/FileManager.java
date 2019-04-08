/**************************************************
 * 
 * 
 *  This class provides file reading and writing functionality
 *  Author: Susan McKeever
 *  2019
 *  
 ************************************************************************************/

package com.CA_Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager 
{
	String fileName;
	File fileExample;
	Scanner myScanner;
    PrintWriter pwInput;
	
	// Constructor
	FileManager (String fileName)
	{
		
		this.fileName = fileName;
		
	}
	
	// get a connection to the file
	void connectToFile()
	{
		fileExample = new File(fileName);
	}

	// Read the file, returning a string of lines
    String[] readFile()
    {
    
    	String[] values = new String[6];
	    try
		{
	    	int i = 0;
	    	myScanner = new Scanner(fileExample); 
			 while (myScanner.hasNextLine())
			    {
			      
				 values[i] = myScanner.nextLine();
			      i++;
			    }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
	        return values;
    }
    
	// get hold of a Print writer object
    void getFileWriter()
    {
    	try
    	{
    		pwInput = new PrintWriter(fileExample);
    	}
  		catch (FileNotFoundException e)
  		{
  			System.out.println("run time error " + e.getMessage());
  		}
    	
    }	

	// write a string to the file
    void writeLineToFile(String line)
    {
       System.out.println(line);
  		pwInput.println(line);    	
    }	

    
    
    void closeReadFile()
    {
		 myScanner.close();
    }

    void closeWriteFile()
    {
		 pwInput.close();
    }

}
