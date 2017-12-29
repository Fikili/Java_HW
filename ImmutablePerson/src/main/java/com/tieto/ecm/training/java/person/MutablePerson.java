package com.tieto.ecm.training.java.person;

import java.time.LocalDate;
import java.util.Objects;

public class MutablePerson {
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private boolean bald;

	public MutablePerson(String firstName, String lastName, LocalDate birthDay, boolean bald) {
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public void setBald(boolean bald) {
		this.bald = bald;
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
		if (!(other instanceof MutablePerson)) {
			return false;
		}
		MutablePerson castOther = (MutablePerson) other;
		return Objects.equals(firstName, castOther.firstName) && Objects.equals(lastName, castOther.lastName) && Objects.equals(birthDay, castOther.birthDay) && Objects.equals(bald, castOther.bald);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDay, bald);
	}
}
