package com.tieto.ecm.training.java;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//@RunWith(Parameterized.class)
class ArrayHandlerTest {

	/*
	 * I was not able to run Parameterized tests in JUnit5 - there are some options such as  @MethodSource but I had to do something wrong
	 * My example of Parameterized test how it should work with JUnit 4
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 }, { 150.0 },
				{ 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 }, { 150.0 } });
	}
	
	@Parameter(0)
	public double[] inputArray;
	
	@Parameter(1)
	public double maxValue;
	
	@Test
	public void testFindMax() {
		ArrayHandler arrayHandler = new ArrayHandler();
		assertEquals(maxValue, arrayHandler.findMax(inputArray));
	}
	*/	
	
	@Test
	void testFindMaxCommonArray() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		assertEquals(150.0, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxOneItem() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {0d};
		assertEquals(0, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxNegativeArray() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {-23.1d, -56.794611d, -0.1e10, -1.5e2, -42};
		assertEquals(-23.1, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxFirstItemAsMax() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {0.1, -23.1d, -56.794611d, -0.1e10, -1.5e2, -42, 0.0};
		assertEquals(0.1, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxLastItemAsMax() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {-23.1d, -56.794611d, -0.1e10, -1.5e2, -42, 0.0};
		assertEquals(0, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxAllValuesSame() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {-23.1d, -23.1d, -23.1d};
		assertEquals(-23.1d, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxNullArray() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = null;
		assertEquals(Double.NaN, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxEmptyArray() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = new double[0];
		assertEquals(Double.NaN, arrayHandler.findMax(inputArray));
	}
	
	@Test
	void testFindMaxFailCheck() {
		ArrayHandler arrayHandler = new ArrayHandler();
		double[] inputArray = {23.1d, -56.794611d, -0.0e10, 1.5e2, 42};
		assertNotEquals(42.0, arrayHandler.findMax(inputArray));
	}
	
}
