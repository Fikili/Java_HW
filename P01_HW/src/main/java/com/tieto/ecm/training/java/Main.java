package com.tieto.ecm.training.java;

public class Main {

	public static void main(String[] args) {
		// A few test examples for input data
		//double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		//double[] inputArray = {-23.1d, -56.794611d, -0.1e10, -1.5e2, -42};
		//double[] inputArray = {-23.1d, -56.794611d, -0.1e10, (Double) null, -42};
		//double[] inputArray = null;
		//double[] inputArray = new double[0];
		double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		
		ArrayHandler arrayHandler = new ArrayHandler();
		// Max value using java.util.Arrays
		System.out.println(arrayHandler.findMaxUsingArrays(inputArray));
		// Max value using for loop and temp variable
		System.out.println(arrayHandler.findMax(inputArray));
	}
}
