package com.tieto.ecm.training.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ImmutablePersonBuilderTest {

	@Test
	void instantiatePersonBuilder() {
		ImmutablePersonBuilder person = ImmutablePersonBuilder.builder()
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
	
	@Test
	void illegalArgumentsPersonBuilder() {
		assertThrows(NullPointerException.class, 
				() -> ImmutablePersonBuilder.builder().firstName("Filip").birthDay(LocalDate.of(1999, 12, 31)).bald(false).build()
		);
	}
	
	@Test
	void objectComparison() {
		ImmutablePersonBuilder person1 = ImmutablePersonBuilder.builder()
				.firstName("Filip")
				.lastName("Bruska")
				.birthDay(LocalDate.of(1999, 12, 31))
				.bald(false)
				.build();
		ImmutablePersonBuilder person2 = ImmutablePersonBuilder.builder()
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
}
