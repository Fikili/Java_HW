package com.tieto.ecm.training.java.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class SsnValidator {

	private static final int CHECKSUM_DIVIDER = 31;


	/**
	 * Validate provided Ssn 
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

	
	boolean isValidChecksum(String ssn) {
		// Extract 9 digit form DDMMYYZZZ (removed C and Q)
		int checkSum = Integer.valueOf(String.format("%s%s", ssn.substring(0, 6), ssn.substring(7, 10)));
		char controlChar = ssn.charAt(ssn.length() - 1);
		int remainder = checkSum % CHECKSUM_DIVIDER;
		// Compare remainder with control char defined in map
		if (ControllerMap.controllerMap.get(remainder).equals(controlChar)) {
			return true;
		}
		return false;
	}
}
