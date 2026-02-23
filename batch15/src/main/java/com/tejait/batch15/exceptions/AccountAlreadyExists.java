package com.tejait.batch15.exceptions;

public class AccountAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAlreadyExists() {
		super();
		
	}

	public AccountAlreadyExists(String message) {
		super(message);
		
	}

}
