package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class NaiveBayes 
{
	
	private String[] yesAndOption;
	private String[] noAndOption;
	private ArrayList<Patient> patTemp = new ArrayList<Patient>();
	
	public NaiveBayes(String dataSet)
	{
		FileAccess dataSetAcc = new FileAccess(dataSet);
		String[] fileArr = dataSetAcc.readfile();
		for(i=0;i<)
		patTemp.add(fileArr[i]);
	}
}
