package com.tieto.ecm.training.java;

import java.util.Arrays;

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
		double maxValue = Double.NEGATIVE_INFINITY; 
		if (input != null && input.length > 0) {
			for (int i = 0; i < input.length; i++) {
				if (input[i] > maxValue) {
					maxValue = input[i]; 
				}
			}
			return maxValue;
		}
    	return Double.NaN;
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
}
