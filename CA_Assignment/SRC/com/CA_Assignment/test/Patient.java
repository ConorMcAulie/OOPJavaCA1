             package com.CA_Assignment.test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Patient {
	private int i = 0;
	private String[] Traits;
	private int patSize = 4;
	
	public Patient()
	{
		FileAccess dataSet = new FileAccess();
		
	}

	public void setTraits(String[] traits) 
	{
		this.Traits = traits;
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
