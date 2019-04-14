/****************************************
 * Control GUI	: This class is the file connector to link
 * 				: each class to a file if needed
 * Author		: Conor McAuley
 * Date Start 	: 06/04/2019
 * Date	End		: 14/04/2019
****************************************/
package com.CA_Assignment.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAccess 
{
	// All variables for the code
	int fileSize;
	int i;
	// file pathname
	String name = "CSV_Files\\TrainingData.csv";
	File dataSet;
	Scanner dataSetScanner;
	PrintWriter fileApend;
	ArrayList<String[]> dataSetArr = new ArrayList<String[]>();
	
	// instantiates file access
	FileAccess()
	{
		dataSet = new File(name);
	}
	
	// instantiates file access if it gets a name for a file
	
	/*				-UD-
	Isn't used because it overwrites file
	*/
	FileAccess(String name)
	{
		dataSet = new File(this.name);
		File newData = new File(name);
		Scanner newDataScan;
		
		try
	    {
			newDataScan = new Scanner(newData);
	    	fileApend = new PrintWriter(dataSet);
	    	while(newDataScan.hasNextLine()) 
			{
				fileApend.println(newDataScan.nextLine());
			}
	    }
	  	catch (FileNotFoundException e)
	  	{
	  		System.out.println("run time error " + e.getMessage());
	  		return;
	  	}
		
		fileApend.close();
	}
	
	// Reads the file into a string
	public String[] readfile()
	{
		try 
		{
			dataSetScanner = new Scanner(dataSet);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("run time error" + e.getMessage());
			String[] empty = new String[1];
  			return empty;
		}
		String[] readFile = new String[(int) dataSet.length()];
		fileSize = 0;
		while(dataSetScanner.hasNextLine())
		{
			readFile[fileSize] = dataSetScanner.nextLine();
			fileSize++;
		}
		return readFile;
	}
	
	// gets the file size after previous function has been used
	public int getFileSize() 
	{
		if(fileSize!=0)
		{
			return fileSize;
		}
		else 
		{
			return 0;
		}
	}
	
	// Adds patient to data set
	public void addPatientToData(Patient patTemp) 
	{
		String fileAdd = "";
		try
    	{
    		FileWriter fw = new FileWriter(dataSet);
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    PrintWriter fileApend = new PrintWriter(bw);
    	}
  		catch (FileNotFoundException e)
  		{
  			System.out.println("run time error " + e.getMessage());
  			return;
  		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] fileAddtoArr = patTemp.getTraits();
		for(int i = 0; i < patTemp.getTraits().length; i++) 
		{
			fileAdd = fileAdd + "," + fileAddtoArr[i];
		}
		
		fileApend.println(fileAdd);
		fileApend.close();
	}
	
	// Resets the data set
	
	/*				-UD-
	Isn't used because it empties file
	*/
	public void resetData()
	{
		dataSet = new File("CSV_Files\\OriginalData.csv");
	}
}
