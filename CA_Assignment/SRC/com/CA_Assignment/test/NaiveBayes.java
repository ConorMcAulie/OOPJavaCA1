/****************************************
 * NaiveBayes	: This class is to be the algorithm of the project 
 * 				: being the main functionality of the code
 * Author		: Conor McAuley
 * Date Start 	: 06/04/2019
 * Date	End		: 14/04/2019
****************************************/
package com.CA_Assignment.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class NaiveBayes 
{
	// All Attributes 
	private int probYes = 0;
	private int probNo = 0;
	private int tonYes = 0;
	private int tonNo = 0;
	private int i;
	private float[] yesAndOption;
	private float totalYes;
	private float[] noAndOption;
	private float totalNo;
	private ArrayList<String[]> patList = new ArrayList<String[]>();
	FileAccess dataSetAcc = new FileAccess();
	int forCheck = 0;
	
	// Instantiates object
	public NaiveBayes()
	{
		this.setPatList();
	}
	
	// makes the transfer from file to Array List of string Arrays
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
	
	// prints files elements
	
	/*				-UD-
			wasn't implemented
	*/
	public void printList()
	{
		for(i=0;i<patList.size();i++)
		{
			Patient patTemp = new Patient(patList.get(i));
			System.out.println(patTemp);
		}
	}
	
	// Naive Bayes algorithm conditional probability
	public float Algorithm(String[] options) 
	{
		totalYes = 1;
		totalNo = 1;
		
		String[] retString = new String[options.length];
		yesAndOption = new float[options.length];
		noAndOption = new float[options.length];
		
		// Start of algorithm
		for(i = 0; i < options.length; i++)
		{
			probYes = 0;
			probNo = 0;
			tonYes = 0;
			tonNo = 0;
			
			for(int j = 0; j < patList.size(); j++) 
			{
				String[] inLoop = patList.get(j);
				// if yes tonsillitis
				if(inLoop[inLoop.length - 1].equals("yes"))
				{
					if(inLoop[i+1].equals(options[i]))
					{
						probYes++;
					}
					tonYes++;
				}
				// if no tonsillitis
				else if(inLoop[inLoop.length - 1].equals("no"))
				{
					if(inLoop[i+1].equals(options[i]))
					{
						probNo++;
					}
					tonNo++;
				}
			}
			//making it readable
			retString[i] = probYes + "/" + tonYes + ","
					+ probNo + "/" + tonNo;
			System.out.println(retString);
			
			totalYes = totalYes * probYes/tonYes;
			totalNo = totalNo * probNo/tonNo;
		}
		
		int tonAll = tonNo + tonYes;
		
		totalYes = ( totalYes * tonYes ) / tonAll;
		totalNo = ( totalNo * tonNo ) / tonAll;
		
		totalYes = totalYes * 100/( totalYes + totalNo );
		
		//Probability of it being Tonsillitis
		return totalYes;
	}
	
	// Checking Reliability
	
	/*		-UD-
	Didn't work, made an infinite loop for some reason and almost destroyed the program
	*/
	@SuppressWarnings("null")
	public float CheckRel() 
	{
		int relTop = 0;
		int relBot = 0;
		int sizeOfFArr = 0;
		float[] checkIt = null;
		String[] options = null;
		ArrayList<String[]> testList = new ArrayList<String[]>();
		this.forCheck = (int)(patList.size() * 0.3);
		System.out.println(forCheck);
		
		for(i=0;i<forCheck;i++) 
		{
			options = this.patList.get(patList.size()-forCheck+i);
			String[] optClean = Arrays.copyOfRange(options, 1, 4);
			checkIt[i] = Algorithm(optClean);
			sizeOfFArr++;
		}
		
		checkIt = new float[sizeOfFArr];
		for(i=0;i<checkIt.length;i++)
		{
			if(((checkIt[i] > 50.0) && (options[options.length-1] == "yes")) ||
						((checkIt[i] < 50) && (options[options.length-1] == "no")))
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
