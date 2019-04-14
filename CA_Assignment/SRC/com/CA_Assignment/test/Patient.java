/****************************************
 * Patient		: This class is to be used as the patient
 * 				: to hold info relevant to the patient
 * Author		: Conor McAuley
 * Date Start 	: 06/04/2019
 * Date	End		: 14/04/2019
****************************************/             
package com.CA_Assignment.test;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Patient {
	private int i = 0;
	private String[] Traits;
	FileAccess dataSet;
	// private patSize = 4;

	// Constructor for patient with string array element for traits
	public Patient(String[] patTraits)
	{
		FileAccess dataSet = new FileAccess();
		this.Traits = patTraits;
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

	// Getter
	public String[] getTraits() {
		return Traits;
	}
	
	// Setter
	public void setTraits(String[] traits) 
	{
		for(i=0;i<(traits.length);i++) 
		{
			this.Traits[i] = traits[i];
		}
		i = 0;
	}
}
