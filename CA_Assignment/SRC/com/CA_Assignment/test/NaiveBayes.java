package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class NaiveBayes 
{
	private int i;
	private String[] yesAndOption;
	private String[] noAndOption;
	private Patient patTemp;
	private ArrayList<Patient> patList = new ArrayList<Patient>();
	
	public NaiveBayes()
	{
		FileAccess dataSetAcc = new FileAccess();
		String[] fileArr = dataSetAcc.readfile();
		
		for(i=0;i<dataSetAcc.getFileSize();i++) 
		{
			patTemp.setTraits(fileArr[i].split(","));
			patList.add(patTemp);
			System.out.println(patTemp);
		}
	}
}
