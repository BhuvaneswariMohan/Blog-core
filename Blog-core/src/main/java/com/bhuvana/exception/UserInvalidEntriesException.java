package com.bhuvana.exception;



public class UserInvalidEntriesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInvalidEntriesException(String message) {
		super(message);
	}

}
