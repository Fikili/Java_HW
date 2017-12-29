package com.tieto.ecm.training.java.person;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ImmutablePersonTest {

	@Test
	void immutabilityVerification() {
		ImmutablePerson immutablePerson = new ImmutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		assertAll(() -> assertEquals("Filip", immutablePerson.getFirstName()),
			() -> assertEquals("Bruska", immutablePerson.getLastName()),
			() -> assertEquals(LocalDate.of(1999, 01, 01), immutablePerson.getBirthDay()),
			() -> assertFalse(immutablePerson.isBald())
		);
	}

	@Test
	void objectComparison() {
		ImmutablePerson immutablePerson1 = new ImmutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		ImmutablePerson immutablePerson2 = new ImmutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		assertAll(() -> assertEquals(immutablePerson1, immutablePerson2),
			() -> assertNotSame(immutablePerson1, immutablePerson2),
			() -> assertTrue(immutablePerson1.hashCode() == immutablePerson2.hashCode())
		);
	}
}
