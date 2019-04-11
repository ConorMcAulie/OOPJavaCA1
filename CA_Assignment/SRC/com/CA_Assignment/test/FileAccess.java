package com.CA_Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAccess 
{
	int fileSize;
	String name = "TrainingData.csv";
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
			System.out.println("run time error " + e.getMessage());
			String[] empty = new String[1];
  			return empty;
		}
		String[] readFile = new String[(int) dataSet.length()];
		return readFile;
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
		File trainingData = new File("TrainingData");
		dataSet = trainingData;
	}
}
