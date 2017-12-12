package com.tieto.ecm.training.java.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SsnValidatorTest {

	private SsnValidator ssnValidator;

	@BeforeEach
	void init() {
		ssnValidator = new SsnValidator();
	}

	// Syntax checks
	@DisplayName("Ssn with more chars")
	@Test
	void isValidSyntaxMoreChars() {
		assertFalse(ssnValidator.isValidSyntax("250900A126EY"));	
	}
	
	@DisplayName("Ssn with less chars")
	@Test
	void isValidSyntaxLessChars() {
		assertFalse(ssnValidator.isValidSyntax("250900A16E"));	
	}
	
	@DisplayName("Ssn with wrong century sign")
	@Test
	void isValidSyntaxWrongCenturySign() {
		assertFalse(ssnValidator.isValidSyntax("250900X126E"));	
	}
	
	@DisplayName("Ssn for man from 18xx")
	@Test
	void isValidSyntaxMan18xx() {
		assertTrue(ssnValidator.isValidSyntax("250900+125D"));	
	}
	
	@DisplayName("Ssn for woman from 18xx")
	@Test
	void isValidSyntaxWoman18xx() {
		assertTrue(ssnValidator.isValidSyntax("250900+126E"));	
	}

	@DisplayName("Ssn for man from 19xx")
	@Test
	void isValidSyntaxMan19xx() {
		assertTrue(ssnValidator.isValidSyntax("020456-739T"));	
	}
	
	@DisplayName("Ssn for woman from 19xx")
	@Test
	void isValidSyntaxWoman19xx() {
		assertTrue(ssnValidator.isValidSyntax("130860-6742"));	
	}
	
	@DisplayName("Ssn for man from 20xx")
	@Test
	void isValidSyntaxMan20xx() {
		assertTrue(ssnValidator.isValidSyntax("050409A6314"));	
	}
	
	@DisplayName("Ssn for woman from 20xx")
	@Test
	void isValidSyntaxWoman20xx() {
		assertTrue(ssnValidator.isValidSyntax("270209A108U"));	
	}

	// Semantics check
	@DisplayName("Ssn wrong Feb29")
	@Test
	void isValidSemanticsFeb29() {
		assertFalse(ssnValidator.isValidSemantics("290209A108U"));	
	}

	@DisplayName("Ssn wrong day Dec39")
	@Test
	void isValidSemanticsWrongDay() {
		assertFalse(ssnValidator.isValidSemantics("391202A108U"));	
	}
	
	@DisplayName("Ssn correct Feb29")
	@Test
	void isValidSemanticsCorrectFeb29() {
		assertTrue(ssnValidator.isValidSemantics("290208A108T"));	
	}
	
	@DisplayName("Ssn correct day Jan31")
	@Test
	void isValidSemanticsCorrectBirthday() {
		assertTrue(ssnValidator.isValidSemantics("310140-556C"));	
	}
	
	// Checksum
	@DisplayName("Ssn invalid checksum")
	@Test
	void isValidChecksumInvalidChecksum() {
		assertFalse(ssnValidator.isValidChecksum("270547-2930"));	
	}
	
	@DisplayName("Ssn valid checksum")
	@Test
	void isValidChecksumValidChecksum() {
		assertTrue(ssnValidator.isValidChecksum("270547-2931"));	
	}
	
	
	@DisplayName("Validate syntax of Ssn for man from 18")
	@Test
	void isValidSyntaxMan18Cent() {
		assertTrue(ssnValidator.isValidChecksum("230160-149X"));	
	}
	
	// Whole validation
	
	@DisplayName("Ssn with null")
	@Test
	void isValidSsnNull() {
		assertFalse(ssnValidator.isValidSsn(null));	
	}
	
	@DisplayName("Validate Ssn for man born in 19xx")
	@Test
	void isValidSsnMan19xx() {
		assertTrue(ssnValidator.isValidSsn("131155-8639"));
	}
	
	@DisplayName("Validate Ssn for woman born in 20xx")
	@Test
	void isValidSsnWoman19xx() {
		assertTrue(ssnValidator.isValidSsn("150833-718T"));
	}
	
	@DisplayName("Validate Ssn for man born in 20xx")
	@Test
	void isValidSsnMan20xx() {
		assertTrue(ssnValidator.isValidSsn("121209A555M"));
	}
	
	@DisplayName("Validate Ssn for woman born in 20xx")
	@Test
	void isValidSsnWoman20xx() {
		assertTrue(ssnValidator.isValidSsn("250908A0568"));
	}

	@DisplayName("Validate Ssn with wrong date")
	@Test
	void isValidSsnWrongDate() {
		assertFalse(ssnValidator.isValidSsn("121309A555N"));
	}
	
	@DisplayName("Validate Ssn for wrong checksum")
	@Test
	void isValidSsnWrongChecksum() {
		assertFalse(ssnValidator.isValidSsn("121309A555M"));
	}
}
