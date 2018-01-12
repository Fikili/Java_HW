package com.tieto.ecm.training.java;

import java.lang.reflect.Array;

public class ArrayHandler {

	/**
	 * Find first n objects using results from Comparable interface
	 * 
	 * @param input
	 * @param n
	 * @return
	 */
	public <T extends Comparable<T>> T[] findMinObjects(T[] input, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Parameter n cannot be negative number");
		}

		if (input == null) {
			throw new IllegalArgumentException("Input parameter cannot be null");
		}

		if (input.length == 0) {
			return createEmptyArray(0, input);
		}

		// n cannot be higher than array length
		n = (input.length < n) ? input.length : n;

		// Create new array
		final T[] orderedArray = createEmptyArray(n, input);

		for (T element : input) {
			sortElementIntoArray(orderedArray, element);
		}

		return removeEmptyVals(orderedArray);
	}

	private <T> T[] createEmptyArray(int n, T[] template) {
		final Class<T> templ = (Class<T>) template.getClass().getComponentType();
		return (T[]) Array.newInstance(templ, n);
	}

	private <T> T[] removeEmptyVals(T[] orderedArray) {
		int i = 0;
		// Init new array only with real values
		for (T element : orderedArray) {
			if (element != null) {
				i++;
			}
		}
		final T[] shrinkedArray = createEmptyArray(i, orderedArray);
		System.arraycopy(orderedArray, 0, shrinkedArray, 0, i);
		return shrinkedArray;
	}

	private <T extends Comparable<T>> void sortElementIntoArray(T[] orderedArray, T element) {
		for (int i = 0; i < orderedArray.length; i++) {

			// If the value is null or same, don't do anything
			if (element == null || element.equals(orderedArray[i])) {
				return;
			}

			if (orderedArray[i] == null) {
				orderedArray[i] = element;
				return;
			}

			// Let's put element to relevant position and shift other items
			if (element.compareTo(orderedArray[i]) < 0) {
				// Special handling values which are different only in lower/upper case can be
				// added here
				shiftArrayElements(orderedArray, i);
				orderedArray[i] = element;
				return;
			}
		}

	}

	private <T> void shiftArrayElements(T[] orderedArray, int i) {
		// copy n-1 to n, n-2 to n-1, n-3 to n-2, ...
		for (int j = orderedArray.length - 1; i < j; j--) {
			orderedArray[j] = orderedArray[j - 1];
		}
	}
}