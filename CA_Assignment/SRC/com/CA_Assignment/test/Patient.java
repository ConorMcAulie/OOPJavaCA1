             package com.CA_Assignment.test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Patient {
	private int i = 0;
	private String[] Traits;
	private int patSize = 4;
	
	public Patient(String[] patTraits)
	{
		FileAccess dataSet = new FileAccess();
		this.Traits = patTraits;
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
}
