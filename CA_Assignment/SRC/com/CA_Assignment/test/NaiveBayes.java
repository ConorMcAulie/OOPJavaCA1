package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class NaiveBayes 
{
	private int i;
	private String[] yesAndOption;
	private String[] noAndOption;
	private ArrayList<String[]> patList = new ArrayList<String[]>();
	
	public NaiveBayes()
	{
		FileAccess dataSetAcc = new FileAccess();
		String[] fileArr = dataSetAcc.readfile();
		
		for(i=0;i<dataSetAcc.getFileSize();i++) 
		{
			String[] passing = fileArr[i].split(",");
			Patient patTemp = new Patient(passing);
			patList.add(passing);
			System.out.println(patTemp);
		}
	}
	public void getProbOfPat() 
	{
		 
	}
}
