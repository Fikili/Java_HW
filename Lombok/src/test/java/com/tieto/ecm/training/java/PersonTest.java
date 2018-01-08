package com.tieto.ecm.training.java;

import static com.tieto.ecm.training.java.TestData.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	@DisplayName("Test for instatiating Person using builder patter")
	@Test
	void instantiatePersonUsingBuilder() {
		Person person = Person.builder()
				.firstName("Filip")
				.lastName("Bruska")
				.birthDay(LocalDate.of(1999, 12, 31))
				.bald(false)
				.build();
		assertAll(() -> assertEquals("Filip", person.getFirstName()),
				() -> assertEquals("Bruska", person.getLastName()),
				() -> assertEquals(LocalDate.of(1999, 12, 31), person.getBirthDay()),
				() -> assertFalse(person.isBald())		
		);
	}
	
	@DisplayName("Test for NPE in case of instatiating Person without surname")
	@Test
	void illegalArgumentsPersonBuilder() {
		assertThrows(NullPointerException.class, 
				() -> Person.builder().firstName("Filip").birthDay(LocalDate.of(1999, 12, 31)).bald(false).build()
		);
	}
	
	@DisplayName("Object comparison test for verifying equals and hashCode")
	@Test
	void objectComparison() {
		Person person1 = Person.builder()
				.firstName("Filip")
				.lastName("Bruska")
				.birthDay(LocalDate.of(1999, 12, 31))
				.bald(false)
				.build();
		Person person2 = Person.builder()
				.firstName("Filip")
				.lastName("Bruska")
				.birthDay(LocalDate.of(1999, 12, 31))
				.bald(false)
				.build();
		assertAll(() -> assertEquals(person1, person2),
			() -> assertNotSame(person1, person2),
			() -> assertTrue(person1.hashCode() == person2.hashCode())
		);
	}
	
	@DisplayName("Compare P1 (Filip AAAA) with P2 (Filip Baaaa)")
	@Test
	void compareDifferentSurname() {
		assertTrue(P1.compareTo(P2) < 0);
		assertTrue(P2.compareTo(P1) > 0);
	}
	
	@DisplayName("Compare P5 (Adam Bruska) with P6 (Filip Bruska)")
	@Test
	void compareSameSurnameDifferentFirstName() {
		assertTrue(P5.compareTo(P6) < 0);
		assertTrue(P6.compareTo(P5) > 0);
	}
	
	@DisplayName("Compare P8 (Filip Bruska) with P9 (Filip Bruskaaa)")
	@Test
	void compareLongerSurname() {
		assertTrue(P8.compareTo(P9) < 0);
		assertTrue(P9.compareTo(P8) > 0);
	}
	
	@DisplayName("Compare P8 (Filip Bruska) with P9 (Filip Bruska)")
	@Test
	void compareSameSurnameAndFirstName() {
		assertEquals(0, P6.compareTo(P7));
		assertEquals(0, P7.compareTo(P6));
	}
}
