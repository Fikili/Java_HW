package com.tieto.ecm.training.java.person;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Objects;

public class ImmutablePersonBuilder {
	private final String firstName;
	private final String lastName;
	private final LocalDate birthDay;
	private final boolean bald;

	public ImmutablePersonBuilder(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.birthDay = builder.birthDay;
		this.bald = builder.bald;
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
		if (!(other instanceof ImmutablePersonBuilder)) {
			return false;
		}
		ImmutablePersonBuilder castOther = (ImmutablePersonBuilder) other;
		return Objects.equals(firstName, castOther.firstName) && Objects.equals(lastName, castOther.lastName) && Objects.equals(birthDay, castOther.birthDay) && Objects.equals(bald, castOther.bald);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDay, bald);
	}

	static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String firstName;
		private String lastName;
		private LocalDate birthDay;
		private boolean bald;

		private Builder() {
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder birthDay(LocalDate birthDay) {
			this.birthDay = birthDay;
			return this;
		}

		public Builder bald(boolean bald) {
			this.bald = bald;
			return this;
		}

		public ImmutablePersonBuilder build() {
			if (firstName == null || lastName == null) {
				throw new InvalidParameterException("First name or last name is missing");
			}
			return new ImmutablePersonBuilder(this);
		}
	}
}
