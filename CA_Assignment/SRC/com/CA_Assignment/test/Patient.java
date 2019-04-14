             package com.CA_Assignment.test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Patient {
	private int i = 0;
	private String[] Traits;
	FileAccess dataSet;
	// private patSize = 4;

	public Patient(String[] patTraits)
	{
		FileAccess dataSet = new FileAccess();
		this.Traits = patTraits;
	}

	public String[] getTraits() {
		return Traits;
	}

	public void setTraits(String[] traits) 
	{
		for(i=0;i<(traits.length);i++) 
		{
			this.Traits[i] = traits[i];
		}
		i = 0;
	}

	public String toString() 
	{
		int i = 1;
		String toReturn = Traits[0];
		while(Traits.length!=i) 
		{
			toReturn = toReturn + "|" + Traits[i];
			i++;
		}
		return toReturn;
	}
	
	public void setDataSet(FileAccess dataSet) 
	{
		this.dataSet = dataSet;
	}
}
