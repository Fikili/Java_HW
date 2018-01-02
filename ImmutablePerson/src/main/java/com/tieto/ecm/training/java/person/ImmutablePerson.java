package com.tieto.ecm.training.java.person;

import java.time.LocalDate;
import java.util.Objects;

public class ImmutablePerson {
	private final String firstName;
	private final String lastName;
	private final LocalDate birthDay;
	private final boolean bald;

	public ImmutablePerson(String firstName, String lastName, LocalDate birthDay, boolean bald) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.bald = bald;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public boolean isBald() {
		return bald;
	}

	@Override
	public String toString() {
		return String.format("Person [firstName=%s, lastName=%s, birthDay=%s, bald=%s]", firstName, lastName, birthDay, bald);
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ImmutablePerson)) {
			return false;
		}
		ImmutablePerson castOther = (ImmutablePerson) other;
		return Objects.equals(firstName, castOther.firstName) && Objects.equals(lastName, castOther.lastName) && Objects.equals(birthDay, castOther.birthDay) && Objects.equals(bald, castOther.bald);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDay, bald);
	}
}
