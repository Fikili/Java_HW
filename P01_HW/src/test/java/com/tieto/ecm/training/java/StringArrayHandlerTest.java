package com.tieto.ecm.training.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringArrayHandlerTest {
	
	StringArrayHandler stringArrayHandler;

	@BeforeEach
	void init() {
		stringArrayHandler = new StringArrayHandler();
	}
	
	@Test
	void orderStringArrayCommonInput() {
		String[] input = {"Hello", "Ahoj", "Hola", "Hallo", "Ciao", "Namaste", "Bonjour"};
		String[] expected = {"Ahoj", "Bonjour", "Ciao"};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 3));
	}
	
	@Test
	void orderStringArrayReverse() {
		String[] input = {"Namaste", "Hola", "Hello", "Hallo", "Ciao", "Bonjour", "Ahoj"};
		String[] expected = {"Ahoj", "Bonjour", "Ciao", "Hallo", "Hello"};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 5));
	}
	
	@Test
	void orderStringArrayParamGreaterThanArray() {
		String[] input = {"Namaste", "Hola", "Hello", "Hallo", "Ciao", "Bonjour", "Ahoj"};
		String[] expected = {"Ahoj", "Bonjour", "Ciao", "Hallo", "Hello", "Hola", "Namaste"};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 15));
	}

	@Test
	void orderStringArraySameValues() {
		String[] input = {"Hello", "Hello", "Hello", "Hello", "Hello", "Hello", "Hello"};
		String[] expected = {"Hello"};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 4));
	}
	
	@Test
	void orderStringArrayNull() {
		String[] input = null;
		String[] expected = {};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 5));
	}
	
	@Test
	void orderStringArrayEmpty() {
		String[] input = {};
		String[] expected = {};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 5));
	}
	
	@Test
	void orderStringArrayNullValues() {
		String[] input = {null, "Hello", null, "Ahoj", "Hola", null, "Hallo", "Ciao", "Namaste", "Bonjour", null};
		String[] expected =  {"Ahoj", "Bonjour", "Ciao", "Hallo"};
		assertArrayEquals(expected,  stringArrayHandler.orderStringArray(input, 4));
	}
	
	@Test
	void testFindMaxArrayNegativeParam() {
		String[] input = {"Hello", "Ahoj", "Hola", "Hallo", "Ciao", "Namaste", "Bonjour"};
		assertThrows(IllegalArgumentException.class, ()->{stringArrayHandler.orderStringArray(input, -4);} );
	}
}
