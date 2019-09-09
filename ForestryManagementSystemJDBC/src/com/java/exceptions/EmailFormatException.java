package com.java.exceptions;

public class EmailFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailFormatException(){
		System.out.println(" Incorrect E-mail format!!!!!");	
	}

}
