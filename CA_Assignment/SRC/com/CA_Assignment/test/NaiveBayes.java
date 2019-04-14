package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class NaiveBayes 
{
	private int i;
	private float[] yesAndOption;
	private float totalYes;
	private float[] noAndOption;
	private float totalNo;
	
	private ArrayList<String[]> patList = new ArrayList<String[]>();
	FileAccess dataSetAcc = new FileAccess();
	int forCheck = 0;
	
	public NaiveBayes()
	{
		FileAccess dataSetAcc = new FileAccess();
		String[] fileArr = dataSetAcc.readfile();
		
		for( i = 0; i < (dataSetAcc.getFileSize() - forCheck); i++) 
		{
			String[] passing = fileArr[i].split(",");
			Patient patTemp = new Patient(passing);
			patList.add(passing);
			System.out.println(patTemp);
		}
	}
	
	public ArrayList<float[]> Algorithm(String[] options) 
	{
		int probYes = 0;
		int probNo = 0;
		int tonYes = 0;
		int tonNo = 0;
		String[] retString = new String[options.length];
		yesAndOption = new float[options.length];
		noAndOption = new float[options.length];
		
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
			
			yesAndOption[i] = probYes / tonYes;
			noAndOption[i] = probNo / tonNo;
		}
		
		float[] totalYesAndNo = new float[3];
		totalYesAndNo[0] = (float)tonYes;
		totalYesAndNo[1] = (float)tonNo;
		
		ArrayList<float[]> yesAndNoOptions = new ArrayList<float[]>();
		
		yesAndNoOptions.add(yesAndOption);
		yesAndNoOptions.add(noAndOption);
		yesAndNoOptions.add(totalYesAndNo);
		
		return yesAndNoOptions;
	}
	
	public float getProbOfPat(String[] options) 
	{
		ArrayList<float[]> transfer = Algorithm(options);
		yesAndOption = transfer.get(0);
		noAndOption = transfer.get(1);
		float[] totalYesAndNo = transfer.get(2);
		float tonYes = totalYesAndNo[0];
		float tonNo = totalYesAndNo[1];
		
		int tonAll = (int) (tonNo + tonYes);
		
		for(i = 0; i < options.length; i++)
		{
			totalYes = totalYes * yesAndOption[i];
			totalNo = totalNo * noAndOption[i];
		}
		
		totalYes = ( totalYes * (float)tonYes ) / (float)tonAll;
		totalNo = ( totalNo * (float)tonNo ) / (float)tonAll;
		
		totalYes = totalYes * (float)100 /( totalYes + totalNo );
		
		return totalYes;
	}
	
	public void CheckRel(String[] options) 
	{
		ArrayList<float[]> transfer = Algorithm(options);
		
		yesAndOption = transfer.get(0);
		noAndOption = transfer.get(1);
		float[] totalYesAndNo = transfer.get(2);
		float tonYes = totalYesAndNo[0];
		float tonNo = totalYesAndNo[1];
	}
}
