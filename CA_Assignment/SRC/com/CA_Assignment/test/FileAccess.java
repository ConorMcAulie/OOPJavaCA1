package com.CA_Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAccess 
{
	int fileSize;
	int i;
	String name = "CSV_Files\\TrainingData.csv";
	File dataSet;
	Scanner dataSetScanner;
	PrintWriter fileApend;
	ArrayList<String[]> dataSetArr = new ArrayList<String[]>();
	
	FileAccess()
	{
		dataSet = new File(name);
	}
	
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
	
	public void addPatientToData(Patient patTemp) 
	{
		String fileAdd = "";
		try
    	{
    		fileApend = new PrintWriter(dataSet);
    	}
  		catch (FileNotFoundException e)
  		{
  			System.out.println("run time error " + e.getMessage());
  			return;
  		}
		String[] fileAddArr = patTemp.getTraits();
		for(int i = 0; i < patTemp.getTraits().length; i++) 
		{
			fileAdd = fileAdd + "," + fileAddArr[i];
		}
		fileApend.println(fileAdd);
		fileApend.close();
	}
	
	public void resetData()
	{
		dataSet = new File("CSV_Files\\OriginalData.csv");
	}
}
