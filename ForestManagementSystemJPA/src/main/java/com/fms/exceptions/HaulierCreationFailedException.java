package com.fms.exceptions;

public class HaulierCreationFailedException extends Exception {
private static final long serialVersionUID = 1L;

	public HaulierCreationFailedException(String exception)  {
		super(exception);
	}

}