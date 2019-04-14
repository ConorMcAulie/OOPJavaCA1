package com.CA_Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAccess 
{
	int fileSize;
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
		this.name = name;
		dataSet = new File(name);
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
		int getPatSize = 2;
		try
    	{
    		fileApend = new PrintWriter(dataSet);
    	}
  		catch (FileNotFoundException e)
  		{
  			System.out.println("run time error " + e.getMessage());
  			return;
  		}
		for(int i = 0; i < getPatSize; i++) 
		{
			
		}
		fileApend.println(patTemp);
		fileApend.close();
	}
	
	public void resetData()
	{
		File trainingData = new File("TrainingData.csv");
		dataSet = trainingData;
	}
}
