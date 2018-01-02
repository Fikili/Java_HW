package com.tieto.ecm.training.java.person;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ImmutableStudentTest {

	@Test
	void immutabilityVerification() {
		ImmutableStudent immutableStudent = new ImmutableStudent(new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false), 2);
		immutableStudent.getPerson().setFirstName("David");
		immutableStudent.getPerson().setLastName("Ruml");
		immutableStudent.getPerson().setBirthDay(LocalDate.of(2007, 10, 10));
		immutableStudent.getPerson().setBald(true);
		assertAll(() -> assertEquals("Filip", immutableStudent.getPerson().getFirstName()),
			() -> assertEquals("Bruska", immutableStudent.getPerson().getLastName()),
			() -> assertEquals(LocalDate.of(1999, 01, 01), immutableStudent.getPerson().getBirthDay()),
			() -> assertFalse(immutableStudent.getPerson().isBald())
		);
	}

	@Test
	void objectComparison() {
		ImmutableStudent immutableStudent1 = new ImmutableStudent(new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false), 2);
		ImmutableStudent immutableStudent2 = new ImmutableStudent(new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false), 2);
		assertAll(() -> assertEquals(immutableStudent1, immutableStudent2),
			() -> assertNotSame(immutableStudent1, immutableStudent2),
			() -> assertTrue(immutableStudent1.hashCode() == immutableStudent2.hashCode())
		);
	}
}
