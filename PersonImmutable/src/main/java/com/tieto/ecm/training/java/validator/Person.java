package com.tieto.ecm.training.java.validator;

import java.time.LocalDate;

public class Person {

	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private boolean bald;
	
	public Person(String firstName, String lastName, LocalDate birthDay, boolean bald) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bald ? 1231 : 1237);
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (bald != other.bald)
			return false;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
