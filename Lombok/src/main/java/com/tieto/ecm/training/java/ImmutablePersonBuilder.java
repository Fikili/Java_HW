package com.tieto.ecm.training.java;

import java.time.LocalDate;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ImmutablePersonBuilder {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	private LocalDate birthDay;
	private boolean bald;
}
