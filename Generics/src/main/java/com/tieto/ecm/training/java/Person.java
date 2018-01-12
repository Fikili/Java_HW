package com.tieto.ecm.training.java;

import java.time.LocalDate;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Person implements Comparable<Person> {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	private LocalDate birthDay;
	private boolean bald;

	@Override
	public int compareTo(Person anotherPerson) {
		if (this.equals(anotherPerson)) {
			return 0;
		}

		if (anotherPerson == null) {
			return +1;
		}

		if (!this.lastName.equals(anotherPerson.getLastName())) {
			return this.lastName.compareTo(anotherPerson.getLastName());
		}

		if (!this.firstName.equals(anotherPerson.getFirstName())) {
			return this.firstName.compareTo(anotherPerson.getFirstName());
		}

		// Most likely dead code
		return 0;
	}
}
