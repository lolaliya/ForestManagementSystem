package com.fms.exceptions;

public class SearchingFailedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public  SearchingFailedException(String exception)  {
		super(exception);
	}
}
