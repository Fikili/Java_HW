package com.tieto.ecm.training.java.person;

import java.util.Objects;

public class ImmutableStudent {
	private MutablePerson person;
	private int year;

	public ImmutableStudent(MutablePerson person, int year) {
		this.person = new MutablePerson(person.getFirstName(), person.getLastName(), person.getBirthDay(), person.isBald());
		this.year = year;
	}

	// We need to create a new person using clone
	public MutablePerson getPerson() {
		return new MutablePerson(person.getFirstName(), person.getLastName(), person.getBirthDay(), person.isBald());
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return String.format("ImmutableStudent [person=%s, year=%s]", person, year);
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ImmutableStudent)) {
			return false;
		}
		ImmutableStudent castOther = (ImmutableStudent) other;
		return Objects.equals(person, castOther.person) && Objects.equals(year, castOther.year);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, year);
	}

}
