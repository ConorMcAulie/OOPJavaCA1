package com.CA_Assignment.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
	
	// ArrayList country = new ArrayList;
	
	Set<String> testSet = new HashSet<String>();
	
	public TestHashSet()
	{
		testSet.addAll(Arrays.asList("Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia Herzegovina", 
				"Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Hungary", 
				"Iceland", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein","Lithuania", "Luxemburg", 
				"Macedonia", "Malta", "Moldova", "Monaco", "Montenegro", "Norway", "Poland","Portugal", 
				"Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain","Sweden", 
				"Switzerland", "the Netherlands", "the United Kingdom", "Turkey", "Ukraine"));
	}
	
	public void printSet()
	{
		Iterator<String> itHS = testSet.iterator();
		while(itHS.hasNext())
		{
			System.out.println(itHS.next());
		}
		System.out.println("\n**********\n");
	}
	
	public void addEntry(String entry)
	{
		testSet.add(entry);
	}
	
	public boolean matchEntry(String entry)
	{
		return testSet.contains(entry);
	}
	
	public void clearSet()
	{
		testSet.clear();
	}
	
	public void sortSet()
	{
		ArrayList<String> testArrList = new ArrayList<String>(testSet);
		Collections.sort(testArrList);
		
		Iterator<String> itAL = testArrList.iterator();
		while(itAL.hasNext())
		{
			System.out.println(itAL.next());
		}
		System.out.println("\n**********\n");
		this.reverseSet(testArrList);
		System.out.println("\n**********\n");
		this.shuffleSet(testArrList);
	}
	
	public void reverseSet(ArrayList<String> testArrList)
	{
		Collections.reverse(testArrList);
		
		Iterator<String> itAL = testArrList.iterator();
		while(itAL.hasNext())
		{
			System.out.println(itAL.next());
		}
	}
	
	public void shuffleSet(ArrayList<String> testArrList)
	{
		Collections.shuffle(testArrList);
		
		Iterator<String> itAL = testArrList.iterator();
		while(itAL.hasNext())
		{
			System.out.println(itAL.next());
		}
	}
}
