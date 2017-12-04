package com.tieto.ecm.training.java;

import java.util.Arrays;

public class StringArrayHandler {

    /**
     * Find n biggest distinctive (= each String is different) Strings in the given input array.
     * The returned values are sorted ascending (= from A to Z).
     * Don't handle accented letters (ř, š, č, …)
     * 
     * @param input An array containing String values. The {@code null} value <strong>is</strong> allowed.
     * @param n A non-negative number.
     * @return The n "smallest" distinctive text values in the array. 
     *         If there are not enough distinctive values in the input array, 
     *         returns as many values  as possible and nothing more.
     *         If the array is empty or {@code null}, returns an empty array.
     *         If value differs only in lower/upper case, keep the order from {@code input}
     * @throw IllegalArgumentException if {@code n < 0}
     */
	
	public String[] orderStringArray(String[] input, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Parameter n cannot be negative number");
		}
		
		if (input == null || input.length == 0) {
			return new String[0];
		}
		
		String orderedStringArray[];
		// n cannot be higher than array length
		n = (input.length < n) ? input.length : n;
		orderedStringArray = new String[n];
		// Fill array by empty string; Is it good approach? Or should be kept without init vals
		Arrays.fill(orderedStringArray, "");
		for (String element : input) {
			sortElementIntoArray(orderedStringArray, element);
		}

		return removeEmptyVals(orderedStringArray);
	}

	private String[] removeEmptyVals(String[] orderedStringArray) {
		String[] shrinkedArray;
		int i = 0;
		// Init new array only with real values
		for (String element : orderedStringArray) {
			if ( ! element.equals("")) {
				i++;
			}
		}
		shrinkedArray = new String[i];
		System.arraycopy(orderedStringArray, 0, shrinkedArray, 0, i);
		return shrinkedArray;
	}

	private void sortElementIntoArray(String[] orderedStringArray, String element) {
		for (int i = 0; i < orderedStringArray.length; i++) {
			
			// If the value is null or same, don't do anything
			if (element == null || element.equals(orderedStringArray[i])) {
				return;
			}
			
			// Let's put element to relevant position and shift other items
			if (orderedStringArray[i].equals("") || element.compareToIgnoreCase(orderedStringArray[i]) < 0) {
				// Special handling values which are different only in lower/upper case can be added here
				shiftArrayElements(orderedStringArray, i);
				orderedStringArray[i] = element;
				return;
			}
		}
		
	}

	private void shiftArrayElements(String[] orderedStringArray, int i) {
		// copy n-1 to n, n-2 to n-1, n-3 to n-2, ... 
		for (int j = orderedStringArray.length - 1; i < j; j--) {
			orderedStringArray[j] = orderedStringArray[j - 1]; 
		}
	}
}
