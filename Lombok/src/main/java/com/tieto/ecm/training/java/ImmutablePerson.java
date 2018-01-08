package com.tieto.ecm.training.java;

import java.time.LocalDate;

import lombok.Value;

@Value
public class ImmutablePerson {

	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private boolean bald;
}
