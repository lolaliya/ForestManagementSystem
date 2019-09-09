package com.fms.exceptions;

public class OrderCreationFailedException  extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderCreationFailedException(String exception)  {
		super(exception);
	}

}
