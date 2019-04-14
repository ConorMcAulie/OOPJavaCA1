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
	public String[] getProbOfPat(String[] options) 
	{
		int probYes = 0;
		int probNo = 0;
		int tonYes = 0;
		int tonNo = 0;
		String[] retString = new String[options.length];
		
		for(i = 0; i < options.length; i++)
		{
			probYes = 0;
			probNo = 0;
			tonYes = 0;
			tonNo = 0;
			
			for(int j = 0; j < patList.size(); j++) 
			{
				String[] inLoop = patList.get(j);
				if(inLoop[inLoop.length - 1].equals("yes"))
				{
					if(options[i].equals(inLoop[i+1]))
					{
						probYes++;
					}
					tonYes++;
				}
				else if(inLoop[inLoop.length - 1].equals("no"))
				{
					if(options[i].equals(inLoop[i+1]))
					{
						probNo++;
					}
					tonNo++;
				}
				System.out.println(probYes + "/" + tonYes + ","
				+ probNo + "/" + tonNo);
			}
			retString[i] = probYes + "/" + tonYes + ","
					+ probNo + "/" + tonNo;
		}
		return retString;
	}
}
