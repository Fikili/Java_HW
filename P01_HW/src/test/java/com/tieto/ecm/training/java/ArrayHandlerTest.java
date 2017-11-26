package com.tieto.ecm.training.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
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

		assertEquals(maxValue, arrayHandler.findMax(inputArray));
	}
	*/	
	
	static ArrayHandler arrayHandler;

	@BeforeAll
	static void init() {
		arrayHandler = new ArrayHandler();
	}

	// Find 1 max value
	@Test
	void testFindMaxCommonArray() {
		double[] inputArray = { 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 };
		assertEquals(150.0, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxOneItem() {
		double[] inputArray = { 0d };
		assertEquals(0, arrayHandler.findMax(inputArray));
	}
	@Test
	void testFindMaxNegativeArray() {
		double[] inputArray = { -23.1d, -56.794611d, -0.1e10, -1.5e2, -42 };
		assertEquals(-23.1, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxFirstItemAsMax() {
		double[] inputArray = { 0.1, -23.1d, -56.794611d, -0.1e10, -1.5e2, -42, 0.0 };
		assertEquals(0.1, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxLastItemAsMax() {
		double[] inputArray = { -23.1d, -56.794611d, -0.1e10, -1.5e2, -42, 0.0 };
		assertEquals(0, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxAllValuesSame() {
		double[] inputArray = { -23.1d, -23.1d, -23.1d };
		assertEquals(-23.1d, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxNullArray() {
		double[] inputArray = null;
		assertEquals(Double.NaN, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxEmptyArray() {
		double[] inputArray = new double[0];
		assertEquals(Double.NaN, arrayHandler.findMax(inputArray));
	}

	@Test
	void testFindMaxFailCheck() {
		double[] inputArray = { 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 };
		assertNotEquals(42.0, arrayHandler.findMax(inputArray));
	}

	// Find x top values
	@Test
	void testFindMaxArrayCommonArray() {
		double[] inputArray = { 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 };
		double[] expectedResult = {150, 42, 23.1};
		assertArrayEquals(expectedResult, arrayHandler.findMax(inputArray, 3));
	}
	
	@Test
	void testFindMaxArraySameNumbers() {
		double[] inputArray = { 23.1d, 2.31e1, 23.1 };
		double[] expectedResult = {23.1};
		assertArrayEquals(expectedResult, arrayHandler.findMax(inputArray, 3));
	}
	
	@Test
	void testFindMaxArrayParamGreaterThanArraySize() {
		double[] inputArray = { 23.1d, 42 };
		double[] expectedResult = { 42.0, 23.1d,  };
		assertArrayEquals(expectedResult, arrayHandler.findMax(inputArray, 8));
	}
	
	@Test
	void testFindMaxArrayNullParam() {
		double[] inputArray = null;
		double[] expectedResult = {};
		assertArrayEquals(expectedResult, arrayHandler.findMax(inputArray, 3));
	}
	
	@Test
	void testFindMaxArrayEmptyArray() {
		double[] inputArray = {};
		double[] expectedResult = {};
		assertArrayEquals(expectedResult, arrayHandler.findMax(inputArray, 3));
	}
	
	@Test
	void testFindMaxArrayNegativeParam() {
		double[] inputArray = { 23.1d, -56.794611d, -0.0e10, 1.5e2, 42 };
		assertThrows(IllegalArgumentException.class, ()->{arrayHandler.findMax(inputArray, -3);} );
	}
}
