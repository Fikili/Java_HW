package com.tieto.ecm.training.java.validator;

public class Main {

	public static void main(String[] args) {
		SsnValidator ssnValidator = new SsnValidator(); 
		ssnValidator.isValidSsn("290648-306T");
	}

}
