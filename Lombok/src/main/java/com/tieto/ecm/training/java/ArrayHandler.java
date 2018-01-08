package com.tieto.ecm.training.java;

public class ArrayHandler {

	public Person[] findMaxPersons(Person[] input, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Parameter n cannot be negative number");
		}

		if (input == null || input.length == 0) {
			return new Person[0];
		}

		Person orderedArray[];
		// n cannot be higher than array length
		n = (input.length < n) ? input.length : n;
		orderedArray = new Person[n];
		// Fill array by empty ; Is it good approach? Or should be kept without init vals
		// Arrays.fill(orderedArray, "");
		for (Person element : input) {
			sortElementIntoArray(orderedArray, element);
		}

		return removeEmptyVals(orderedArray);
	}

	private Person[] removeEmptyVals(Person[] orderedArray) {
		Person[] shrinkedArray;
		int i = 0;
		// Init new array only with real values
		for (Person element : orderedArray) {
			if (element != null) {
				i++;
			}
		}
		shrinkedArray = new Person[i];
		System.arraycopy(orderedArray, 0, shrinkedArray, 0, i);
		return shrinkedArray;
	}

	private void sortElementIntoArray(Person[] orderedArray, Person element) {
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
				// Special handling values which are different only in lower/upper case can be added here
				shiftArrayElements(orderedArray, i);
				orderedArray[i] = element;
				return;
			}
		}

	}

	private void shiftArrayElements(Person[] orderedArray, int i) {
		// copy n-1 to n, n-2 to n-1, n-3 to n-2, ...
		for (int j = orderedArray.length - 1; i < j; j--) {
			orderedArray[j] = orderedArray[j - 1];
		}
	}
}