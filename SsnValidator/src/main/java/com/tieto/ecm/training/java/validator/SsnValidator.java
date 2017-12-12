package com.tieto.ecm.training.java.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class SsnValidator {

	private static final int CHECKSUM_DIVIDER = 31;
	private static final char[] CHECK_SUMS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

	/**
	 * Validate provided Finnish Ssn 
	 * 
	 * @param ssn - String value with Social security number
	 * @return boolean value if provided Ssn is valid or not
	 */
	boolean isValidSsn(String ssn) {
		if (! isValidSyntax(ssn)) {
			return false;
		}
		
		if (! isValidSemantics(ssn)) {
			return false;
		}
		
		if (! isValidChecksum(ssn)) {
			return false;
		}
		
		return true;
	}

	/**
	 * Validate syntax
	 * @param ssn
	 * @return boolean value if provided Ssn has valid syntax
	 */
	boolean isValidSyntax(String ssn) {
		// Skip null values
		if (ssn == null) {
			return false;
		}
		
		// Check syntax of ssn DDMMYYCZZZQ
		if (! ssn.matches("[0-3][0-9][01][0-9]{3}[-|+|A][0-9]{3}[0-9A-Y]")) {
			return false;
		}
		
		// Check individual number ZZZ if woman or man - skipped
		return true;
	}

	/**
	 * Validate semantics
	 * @param ssn
	 * @return boolean value if provided Ssn contains real date
	 */
	boolean isValidSemantics(String ssn) {
		// Extract century - should we use Enum or Map for + - A???
		String century = "";
		switch (ssn.charAt(6)) {
		case '+': century = "18"; break;
		case '-': century = "19"; break;
		case 'A': century = "20"; break;

		default: return false;
		}
		
		// Convert to DD-MM-YYYY (dd-MM-uuuu in Java world)
		String dateString = String.format("%s-%s-%s%s", ssn.substring(0, 2), ssn.substring(2, 4), century, ssn.substring(4, 6));
		
		try {
			LocalDate.parse(dateString,	DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT));
		} catch (DateTimeParseException e) {
			// Should we test against false or against exception???
			//System.out.println("Invalid date " + e);
			return false;
		}
		return true;
	}

	/**
	 * Validate checksum
	 * @param ssn
	 * @return boolean value if provided Ssn contains valid checksum
	 */
	boolean isValidChecksum(String ssn) {
		// Extract 9 digit form DDMMYYZZZ (removed C and Q)
		int checkSum = Integer.valueOf(String.format("%s%s", ssn.substring(0, 6), ssn.substring(7, 10)));
		int remainder = checkSum % CHECKSUM_DIVIDER;
		char controlChar = ssn.charAt(ssn.length() - 1);
		// Compare remainder with control char defined in Char array
		if (CHECK_SUMS[remainder] == controlChar) {
			return true;
		}
		return false;
	}
}
