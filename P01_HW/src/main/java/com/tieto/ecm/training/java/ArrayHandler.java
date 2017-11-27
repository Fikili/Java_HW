package com.tieto.ecm.training.java;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayHandler {

	/**
     * Find the biggest number in the given input array using comparing current value and max value
     * This algorithm offers O(n) performance
     * 
     * @param input An array containing values. The {@code null} value <strong>is</strong> allowed.
     * @return The biggest number in the array. 
     *         If the array is empty or {@code null}, returns {@code Double.NaN}
     */
	public double findMax(double[] input) {
		if (input == null || input.length == 0) {
			return Double.NaN;
		}

		double maxValue = Double.NEGATIVE_INFINITY;

		for (double d : input) {
			if (d > maxValue) {
				maxValue = d;
			}
		}
		return maxValue;
	}
	
	/**
     * Find the biggest number in the given input array using DualPivotQuicksort via java.util.Arrays.sort
     * This algorithm offers O(n log(n)) performance on many data sets
     * 
     * <strong>>It is not used now </strong> but it could be good for verification results in test cases
     * 
     * @param input An array containing values. The {@code null} value <strong>is</strong> allowed.
     * @return The biggest number in the array. 
     *         If the array is empty or {@code null}, returns {@code Double.NaN}
     */
	
    public double findMaxUsingArrays(double[] input) {
    	if (input != null && input.length > 0) {
    		Arrays.sort(input);
    		return input[input.length -1];
    	}
    	return Double.NaN;
    }

    
    /**
     * Find n biggest distinctive (= each number is different) numbers in the given input array.
     * The returned numbers are sorted descending (= from the biggest to the smallest).
     * 
     * @param input An array containing values. The {@code null} value <strong>is</strong> allowed.
     * @param n A non-negative number.
     * @return The n biggest distinctive numbers in the array. 
     *         If there are not enough distinctive numbers in the input array, 
     *         returns as many numbers as possible and nothing more.
     *         If the array is empty or {@code null}, returns an empty array.
     * @throw IllegalArgumentException if {@code n < 0}
     */

/* 
   First test using arrays -> Replaced by SortedSet because of easier implementation :)
   
	public double[] findMax(double[] input, int n) {
		double[] maxValues;
		if (n < 0) {
			throw new IllegalArgumentException("n has to be non-negative number");
		} else if (input != null && input.length > 0) {
			// n cannot be higher than array length
			n = (input.length < n) ? input.length : n;
			maxValues = new double[n];
			Arrays.fill(maxValues, Double.NEGATIVE_INFINITY);
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < maxValues.length; j++) {
					if (input[i] > maxValues[j]) {
						double tempValue = maxValues[j];
						maxValues[j] = input[i];
						if (j < n) {
							maxValues[j + 1] = tempValue;
						}
						break;
					}
				}
			}
			
			return maxValues;
		} else {
			return new double[0];			
		}
		
	}
    */
    
	public double[] findMax(double[] input, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n has to be non-negative number");
		}

		if (input == null || input.length == 0 || n == 0) {
			return new double[0];
		}
		
		// Copy and sort values from array to set
		SortedSet<Double> maxValuesSet = new TreeSet<>();
		for (double d : input) {
			maxValuesSet.add(d);
		}
		
		n = (maxValuesSet.size() < n) ? maxValuesSet.size() : n;
		// Initialize array 
        double[] maxValuesArray = new double[n];

		// Greatest numbers are in the end -> Let's take the last one and remove it
		
        // Example with stream
        //maxValuesSet.stream().skip(maxValuesSet.size() - n).forEach(maxValuesArray[0] = );
        
        for (int i = 0; i < n; i++) {
			double temp = maxValuesSet.last();
			maxValuesArray[i] = temp;
			maxValuesSet.remove(temp);
		}
		
		return maxValuesArray;
	}
	
}
