package com.tieto.ecm.training.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.tieto.ecm.training.java.TestData.*;

class ArrayHandlerTest {

	ArrayHandler arrayHandler;

	@BeforeEach
	void init() {
		arrayHandler = new ArrayHandler();
	}

	@DisplayName("Person array with common input")
	@Test
	void findMaxPersonsCommonInput() {
		Person[] input = { P2, P6, P9, P1, P3 };
		Person[] expected = { P1, P2, P3 };
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 3));
	}

	@DisplayName("Person array with reverse input")
	@Test
	void findMaxPersonsReverseInput() {
		Person[] input = { P5, P4, P3, P2, P1 };
		Person[] expected = { P1, P2, P3, P4, P5 };
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 5));
	}

	@DisplayName("Person array with parameter greater than array length")
	@Test
	void findMaxPersonsParameterGreaterThanArray() {
		Person[] input = { P5, P4, P3, P2, P1 };
		Person[] expected = { P1, P2, P3, P4, P5 };
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 15));
	}

	@DisplayName("Person with same values - P6 and P7 are eqaul")
	@Test
	void findMaxPersonsSameValues() {
		Person[] input = { P6, P7, P6, P7, P6 };
		Person[] expected1 = { P6 };
		Person[] expected2 = { P7 };
		assertAll(() -> assertArrayEquals(expected1, arrayHandler.findMaxPersons(input, 3)),
				() -> assertArrayEquals(expected2, arrayHandler.findMaxPersons(input, 3)));
	}

	@DisplayName("Input Person array is null")
	@Test
	void findMaxPersonsNullInput() {
		Person[] input = null;
		Person[] expected = {};
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 2));
	}

	@DisplayName("Input Person array is empty")
	@Test
	void findMaxPersonsEmptyArrayInput() {
		Person[] input = {};
		Person[] expected = {};
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 2));
	}

	@DisplayName("Person array with null values")
	@Test
	void findMaxPersonsWithNullValues() {
		Person[] input = { null, P3, P8, null, P2, P5, null };
		Person[] expected = { P2, P3, P5 };
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 3));
	}

	@DisplayName("Person array with null values and n param is greater than expected length")
	@Test
	void findMaxPersonsWithNullValuesAndGreaterParam() {
		Person[] input = { null, P3, P8, null, P2, P5, null };
		Person[] expected = { P2, P3, P5, P8 };
		assertArrayEquals(expected, arrayHandler.findMaxPersons(input, 8));
	}

	@DisplayName("Person array with negative parameter")
	@Test
	void findMaxPersonsWithNegativeParam() {
		Person[] input = { P3, P8, P2, P5 };
		assertThrows(IllegalArgumentException.class, () -> {
			arrayHandler.findMaxPersons(input, -4);
		});
	}
}
