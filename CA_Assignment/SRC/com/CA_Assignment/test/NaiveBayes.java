package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
		this.setPatList();
	}
	
	public void setPatList() 
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
	
	public float Algorithm(String[] options) 
	{
		int probYes = 0;
		int probNo = 0;
		int tonYes = 0;
		int tonNo = 0;
		totalYes = 1;
		totalNo = 1;
		
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
					if(inLoop[i+1].equals(options[i]))
					{
						probYes++;
					}
					tonYes++;
				}
				else if(inLoop[inLoop.length - 1].equals("no"))
				{
					if(inLoop[i+1].equals(options[i]))
					{
						probNo++;
					}
					tonNo++;
				}
			}
			retString[i] = probYes + "/" + tonYes + ","
					+ probNo + "/" + tonNo;
			
			totalYes = totalYes * probYes/tonYes;
			totalNo = totalNo * probNo/tonNo;
		}
		
		int tonAll = tonNo + tonYes;
		
		totalYes = ( totalYes * tonYes ) / tonAll;
		totalNo = ( totalNo * tonNo ) / tonAll;
		
		totalYes = totalYes * 100/( totalYes + totalNo );
		
		return totalYes;
	}
	
	public float CheckRel() 
	{
		int relTop = 0;
		int relBot = 0;
		float checkIt = 0;
		ArrayList<String[]> testList = new ArrayList<String[]>();
		this.forCheck = (int)(patList.size() * 0.3);
		System.out.println(forCheck);
		for(i=0;i<forCheck;i++) 
		{
			String[] options = this.patList.get(patList.size()-forCheck+i);
			String[] optClean = Arrays.copyOfRange(options, 1, 4);
			System.out.println(optClean[0]);
			System.out.println(optClean[1]);
			System.out.println(optClean[2]);
			checkIt = Algorithm(optClean);
			
			if(((checkIt > 50) && (options[options.length-1] == "yes")) ||
					((checkIt < 50) && (options[options.length-1] == "no")))
			{
				relTop++;
			}
			relBot++;
		}
		
		float totalRel = (float)(relTop/relBot);
		System.out.println(totalRel);
		return totalRel;
	}
}
