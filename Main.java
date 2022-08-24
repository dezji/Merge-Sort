// Name: Deziallia Morris

package com.dezji;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;



public class Main {

	public static void main(String[] args) {
		
		// creates the number list for the program
		List<Integer> numberList = new ArrayList<>();
		
		// random number generator for list
		for (int i = 0; i < 10; i++) {
			
			// assigns a random number for the while loop check
			int randomNumber = (int) (Math.random() * 1000);
			
			// if a number already exists in the list, then a new number will be generated
			while (numberList.contains(randomNumber)) {
				randomNumber = (int) (Math.random() * 1000);
			}
			
			// add number if it isn't already in the list
			numberList.add(randomNumber);
			
		}
		
		// adds decoration for the program
		for (int s = 0; s < 150; s++) {
			out.print("*");	
		}
		
		
		out.print("\n\nList before merge sort: " + numberList);
		numberList = mergeSort(numberList);
		out.print("\nThe two smallest numbers in list after merge sort: " + numberList + "\n\n");
		
		// separates both tests
		for (int s = 0; s < 150; s++) {
			out.print("*");	
		}
		
		// a list of names, to be randomly picked for the name list
		
		List<String> randomNames = new ArrayList<>();
		
		randomNames.add("Rue");
		randomNames.add("Gia");
		randomNames.add("Cassie");
		randomNames.add("Maddy");
		randomNames.add("Nate");
		
		randomNames.add("Cal");
		randomNames.add("Leslie");
		randomNames.add("Kat");
		randomNames.add("Fezco");
		randomNames.add("Ashtray");
		
		randomNames.add("Jesse");
		randomNames.add("Emma");
		randomNames.add("Alexis");
		randomNames.add("Emery");
		randomNames.add("Andrew");
		
		// list for the names for the program
		List<String> namesList = new ArrayList<>();
		
		// this short loop adds numbers to the list and runs the same check as the number generator
		for (int i = 0; i < 10; i++) {
			
			int randomNumber = (int) (Math.random() * 15);
			
			// if the name already exists in the list, it will draw a different name using a different number
			while (namesList.contains(randomNames.get(randomNumber))) {
				randomNumber = (int) (Math.random() * 15);
			}
			
			// adds the name to the list
			namesList.add(randomNames.get(randomNumber));
			
		}
		
		
		out.println("\n\nNames in list before merge sort: " + namesList);
		namesList = mergeSort(namesList);
		out.println("The two first names in list after merge sort: " + namesList + "\n");
		
		// end of program line
		for (int s = 0; s < 150; s++) {
			out.print("*");	
		}

	}
	
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> list) {
		
		List<E> half1 = new ArrayList<>();
		List<E> half2 = new ArrayList<>();
		
		
		if (list.size() < 2) {
			return list;
		}
		
		for (int i = 0; i < list.size() / 2; i++) {
			half1.add(list.get(i));
			half1 = mergeSort(half1);
		}
		
		for (int i = list.size() / 2; i < list.size(); i++) {
			half2.add(list.get(i));
			half2 = mergeSort(half2);
		}
		
		return merge(half1, half2);
	}

	public static <E extends Comparable<E>> List<E> merge(List<E> half1, List<E> half2) {
		
		List<E> result = new ArrayList<>();
		List<E> smallestList = new ArrayList<>();
		
		int index1 = 0;
		int index2 = 0;
		
		while (index1 < half1.size() || index2 < half2.size()) {
			if (index1 == half1.size()) {
				result.add(half2.get(index2++));
			}
			
			else if (index2 == half2.size()) {
				result.add(half1.get(index1++));
			}
			
			else {
				if (half1.get(index1).compareTo(half2.get(index2)) > 0) {
					result.add(half2.get(index2++));
				}
				else {
					result.add(half1.get(index1++));
				}
			}
		}
		
		// after the merge sort has sorted the elements, just grab the first two elements and return
		// since the values will be the smallest in the entire list
		
		smallestList.add(result.get(0));
		smallestList.add(result.get(1));
		
		return smallestList;
	}
}
