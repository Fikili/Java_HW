package com.tieto.ecm.training.java.person;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MutablePersonTest {

	@Test
	void mutabilityVerification() {
		MutablePerson mutablePerson = new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		mutablePerson.setBirthDay(LocalDate.of(2000, 12, 31));
		mutablePerson.setFirstName("Phillip");
		mutablePerson.setBald(true);
		assertAll(() -> assertEquals("Phillip", mutablePerson.getFirstName()),
			() -> assertEquals("Bruska", mutablePerson.getLastName()),
			() -> assertEquals(LocalDate.of(2000, 12, 31), mutablePerson.getBirthDay()),
			() -> assertTrue(mutablePerson.isBald())
		);
	}
	
	@Test
	void objectComparison() {
		MutablePerson mutablePerson1 = new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		MutablePerson mutablePerson2 = new MutablePerson("Filip", "Bruska", LocalDate.of(1999, 01, 01), false);
		assertAll(() -> assertEquals(mutablePerson1, mutablePerson2),
			() -> assertNotSame(mutablePerson1, mutablePerson2),
			() -> assertTrue(mutablePerson1.hashCode() == mutablePerson2.hashCode())
		);
	}
}