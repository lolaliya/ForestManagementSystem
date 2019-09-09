package com.fms.exceptions;

public class ProductCreationFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductCreationFailedException(String exception)  {
		super(exception);
	}

}
