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
	void findMinPersonsCommonInput() {
		Person[] input = { P2, P6, P9, P1, P3 };
		Person[] expected = { P1, P2, P3 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}

	@DisplayName("Person array with reverse input")
	@Test
	void findMinPersonsReverseInput() {
		Person[] input = { P5, P4, P3, P2, P1 };
		Person[] expected = { P1, P2, P3, P4, P5 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 5));
	}

	@DisplayName("Person array with parameter greater than array length")
	@Test
	void findMinPersonsParameterGreaterThanArray() {
		Person[] input = { P5, P4, P3, P2, P1 };
		Person[] expected = { P1, P2, P3, P4, P5 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 15));
	}

	@DisplayName("Person with same values - P6 and P7 are eqaul")
	@Test
	void findMinPersonsSameValues() {
		Person[] input = { P6, P7, P6, P7, P6 };
		Person[] expected1 = { P6 };
		Person[] expected2 = { P7 };
		assertAll(() -> assertArrayEquals(expected1, arrayHandler.findMinObjects(input, 3)),
				() -> assertArrayEquals(expected2, arrayHandler.findMinObjects(input, 3)));
	}

	@DisplayName("Input Person array is null")
	@Test
	void findMinPersonsNullInput() {
		Person[] input = null;
		assertThrows(IllegalArgumentException.class, () -> {
			arrayHandler.findMinObjects(input, 2);
		});
	}

	@DisplayName("Input Person array is empty")
	@Test
	void findMinPersonsEmptyArrayInput() {
		Person[] input = {};
		Person[] expected = {};
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 2));
	}

	@DisplayName("Person array with null values")
	@Test
	void findMinPersonsWithNullValues() {
		Person[] input = { null, P3, P8, null, P2, P5, null };
		Person[] expected = { P2, P3, P5 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}

	@DisplayName("Person array with null values and n param is greater than expected length")
	@Test
	void findMinPersonsWithNullValuesAndGreaterParam() {
		Person[] input = { null, P3, P8, null, P2, P5, null };
		Person[] expected = { P2, P3, P5, P8 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 8));
	}

	@DisplayName("Person array with negative parameter")
	@Test
	void findMinPersonsWithNegativeParam() {
		Person[] input = { P3, P8, P2, P5 };
		assertThrows(IllegalArgumentException.class, () -> {
			arrayHandler.findMinObjects(input, -4);
		});
	}

	@DisplayName("Double array with common input")
	@Test
	void findMinDoubleCommonInput() {
		Double[] input = { D2, D4, D1 };
		Double[] expected = { D1, D2, D4 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}

	@DisplayName("Double array with same values - D2 and D3 are eqaul")
	@Test
	void findMinDoubleSameValues() {
		Double[] input = { D2, D2, D3, D2, D3 };
		Double[] expected1 = { D2 };
		Double[] expected2 = { D3 };
		assertAll(() -> assertArrayEquals(expected1, arrayHandler.findMinObjects(input, 3)),
				() -> assertArrayEquals(expected2, arrayHandler.findMinObjects(input, 3)));
	}

	@DisplayName("Double array with null values")
	@Test
	void findMinDoubleWithNullValues() {
		Double[] input = { null, D1, D3, null, D4, null };
		Double[] expected = { D1, D3, D4 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}

	@DisplayName("String array with common input")
	@Test
	void findMinStringCommonInput() {
		String[] input = { S2, S4, S1 };
		String[] expected = { S1, S2, S4 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}

	@DisplayName("String array with same values - D2 and D3 are eqaul")
	@Test
	void findMinStringSameValues() {
		String[] input = { S2, S2, S3, S2, S3 };
		String[] expected1 = { S2 };
		String[] expected2 = { S3 };
		assertAll(() -> assertArrayEquals(expected1, arrayHandler.findMinObjects(input, 3)),
				() -> assertArrayEquals(expected2, arrayHandler.findMinObjects(input, 3)));
	}

	@DisplayName("String array with null values")
	@Test
	void findMinStringWithNullValues() {
		String[] input = { null, S1, S3, null, S4, null };
		String[] expected = { S1, S3, S4 };
		assertArrayEquals(expected, arrayHandler.findMinObjects(input, 3));
	}
}
