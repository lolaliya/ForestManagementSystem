package com.java.exceptions;

public class DeletionFailedException extends Exception {
private static final long serialVersionUID = 1L;

public DeletionFailedException(String exception) {
		super(exception);
	}

}
