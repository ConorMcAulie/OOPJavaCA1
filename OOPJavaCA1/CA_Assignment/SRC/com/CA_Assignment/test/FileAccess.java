package com.CA_Assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAccess 
{
	String name;
	File dataSet;
	Scanner dataSetScanner;
	PrintWriter fileApend;
	ArrayList<Array> dataSetArr = new ArrayList<Array>();
	
	FileAccess(String name)
	{
		this.name = name;
		dataSet = new File(name);
	}
	
	void addPatientToData(String patient) 
	{
		try
    	{
    		fileApend = new PrintWriter(dataSet);
    	}
  		catch (FileNotFoundException e)
  		{
  			System.out.println("run time error " + e.getMessage());
  			return;
  		}
		
		fileApend.println(patient);
		fileApend.close();
	}
}
