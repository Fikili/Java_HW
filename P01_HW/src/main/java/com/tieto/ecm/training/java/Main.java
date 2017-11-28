package com.tieto.ecm.training.java;

public class Main {

	public static void main(String[] args) {
		// A few test examples for input data - More in tests
		//double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		//double[] inputArray = {-23.1d, -56.794611d, -0.1e10, -1.5e2, -42};
		//double[] inputArray = {-23.1d, -56.794611d, -0.1e10, (Double) null, -42};
		//double[] inputArray = null;
		//double[] inputArray = new double[0];
		double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		
		ArrayHandler arrayHandler = new ArrayHandler();
		// Max value using for loop and temp variable
		System.out.println("Max value = " + arrayHandler.findMax(inputArray));

		// Max value using java.util.Arrays -> Not used
		//System.out.println(arrayHandler.findMaxUsingArrays(inputArray));
		
		// Return top 10 values -> Array is smaller -> Return possible
		double[] mVal = arrayHandler.findMax(inputArray, 2);
		if (mVal.length > 0) {
			for (int i = 0; i < mVal.length; i++) {
				System.out.println("mVal[" + i + "] = " + mVal[i]);			
			}						
		} else {
			System.out.println("mVal is empty array");
		}
		
	}
}
