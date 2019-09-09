package com.fms.exceptions;

public class CustomerCreationFailedException extends Exception {
private static final long serialVersionUID = 1L;

	public CustomerCreationFailedException(String exception)  {
		super(exception);
	}

}