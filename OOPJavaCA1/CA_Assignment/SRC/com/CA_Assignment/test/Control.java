/****************************************
 * Control	: the purpose of this class
 * Author	: Conor McAuley
 * Date		: 31/01/2019
****************************************/
package com.CA_Assignment.test;

public class Control 
{

	public static void main(String[] args) 
	{
		System.out.println("helloworld");
		
		TestHashSet testSet = new TestHashSet();
		testSet.printSet();
		testSet.addEntry("Vatican City");
		//unsorted cause it's a set
		System.out.println(testSet.matchEntry("Russia"));
		System.out.println(testSet.matchEntry("Spain"));
		// testSet.clearSet();
		// testSet.printSet();
		testSet.sortSet();
	}
}
